const LOGIN_API_URL = "http://localhost:8080/user/login";

async function login(event) {
    // TODO 5: Prevent the default form submission behavior inside the login() function
    event.preventDefault();

    // TODO 6: Retrieve the username and password entered by the user
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    const role = username === "root" ? "ADMIN" : "USER";

    try {
        // TODO 7: Send a POST request to LOGIN_API_URL with the login credentials
        const response = await fetch(LOGIN_API_URL, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ username, password, role })
        });
        if (!response.ok) throw new Error("Login failed");

        // TODO 8: If the response is successful, store the user ID and role in sessionStorage { userID, username, role } and redirect to index.html. 
        //         Show an error message if log in fails
        const responseData = await response.json();
        const userID = responseData;
        sessionStorage.setItem("user", JSON.stringify({ userID, username, role }));
        window.location.href = "index.html";
    } catch (error) {
        alert(error.message);
    }
}

function isLoggedIn() {
    return Boolean(sessionStorage.getItem("user"));
}

function isAdminLoggedIn() {
    const user = JSON.parse(sessionStorage.getItem("user") || "{}");
    return isLoggedIn() && user.role === "ADMIN";
}

function logout() {
    sessionStorage.removeItem("user");
    window.location.href = "login.html";
}

window.addEventListener("load", () => {
    const addProductButton = document.getElementById("add-product-button");
    if (addProductButton) {
        addProductButton.style.display = isAdminLoggedIn() ? "inline" : "none";
    }

    // Add event listener to the login form
    const loginForm = document.getElementById("loginForm");
    if (loginForm) {
        loginForm.addEventListener("submit", login);
    }

    // Add event listener for the logout button
    const logoutButton = document.getElementById("logout-button");
    if (logoutButton) {
        logoutButton.addEventListener("click", (event) => {
            event.preventDefault();
            logout();
        });
    }
});
