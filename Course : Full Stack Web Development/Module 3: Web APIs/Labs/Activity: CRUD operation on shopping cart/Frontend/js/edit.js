const PRODUCTS_API_URL = "http://localhost:8080/api/v1/products"

// fetch id parameter's value from window url
const urlParams = new URLSearchParams(window.location.search)
const productId = urlParams.get("id")

window.onload = function () {
    fetchProductFromAPI(productId)

    document.getElementById("editProductForm").addEventListener("submit", function (event) {
        event.preventDefault()
        updateProduct(productId)
    })
}

async function fetchProductFromAPI(productId) {
    try {
        const apiResponse = await fetch(`${PRODUCTS_API_URL}/${productId}`)
        if (!apiResponse.ok) {
            alert(`Error fetching product with ${productId} from API`)
        }
        await apiResponse.json().then(product => {
            preFillFormData(product)
        })
    } catch (error) {
        alert("Error fetching product from API")
    }
}

// TODO 10: create a function preFillFormData() to fill product details in edit product form
function preFillFormData(product) {
    document.getElementById("title").value = product.title
    document.getElementById("price").value = product.price
    document.getElementById("description").value = product.description
    document.getElementById("productCategory").value = product.category
    document.getElementById("imageURL").value = product.image
    document.getElementById("rating").value = product.rating.rate
    document.getElementById("ratingCount").value = product.rating.count
}

async function updateProduct(productId) {
    // TODO 11: fetch the form values and store them in a product object named 'updatedProduct'
    const updatedProduct = {
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

    // TODO 12: make a PUT request to the backend API and send the updatedProduct in the body as JSON
    try {
        await fetch(`${PRODUCTS_API_URL}/${productId}`, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(updatedProduct)
        })
        alert(`Product with ${productId} updated successfully`)
        loadProductDetailsPage(productId)
    } catch (error) {
        alert("Error updating product in API")
    }
}

function loadProductDetailsPage() {
    window.location.href = `product.html?id=${productId}`
}