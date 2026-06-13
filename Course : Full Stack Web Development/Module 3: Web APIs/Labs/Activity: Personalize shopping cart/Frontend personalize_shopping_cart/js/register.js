const REGISTER_API_URL = "http://localhost:8080/user/register";

async function registerUser(event) {
    // Use event.preventDefault() to prevent the default action from being executed
    event.preventDefault();

    // TODO 1: Inside the registerUser() function, retrieve the form values: username, password, and confirmPassword
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;
    const confirmPassword = document.getElementById("confirm-password").value;

    // TODO 2: Add form validation to ensure that password and confirmPassword match. If they don’t, display an alert: Passwords do not match
    if (password !== confirmPassword) {
        alert("Passwords do not match");
        return;
    }

    try {
        // TODO 3: If passwords match, create a POST request to REGISTER_API_URL to send the user data { username, password, role: "USER" }
        const response = await fetch(REGISTER_API_URL, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ username, password, role: "USER" })
        });
        if (!response.ok) throw new Error("Registration failed");

        // TODO 4: If registration is successful, display a success alert and redirect the user to the login.html page
        alert("Registration successful");
        window.location.href = "login.html";
    } catch (error) {
        alert(error.message);
    }
}
