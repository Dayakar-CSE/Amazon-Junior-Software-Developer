const PRODUCTS_API_URL = "http://localhost:8080/api/v1/products"

async function addProduct() {
    // TODO 6: fetch the form values from the #addProductForm in add.html and create a product object
    const product = {
        title: document.getElementById("title").value,
        price: parseFloat(document.getElementById("price").value),
        description: document.getElementById("description").value,
        category: document.getElementById("productCategory").value,
        image: document.getElementById("imageURL").value,
        rating: {
            rate: parseFloat(document.getElementById("rating").value),
            count: parseInt(document.getElementById("ratingCount").value)
        }
    }

    // TODO 7: make a POST request to the backend API and send the product in the body as JSON
    try {
        await fetch(
            PRODUCTS_API_URL,
            {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(product)
            }
        )
        alert("Product added successfully")
        window.location.href = "index.html"
    } catch (error) {
        alert("Error adding product to API")
    }
}

// TODO 8: add an evenlistener on the submit button of the #addProductForm in add.html
window.onload = function () {
    document.getElementById("addProductForm").addEventListener("submit", function (event) {
        event.preventDefault()
        addProduct()
    })
}

