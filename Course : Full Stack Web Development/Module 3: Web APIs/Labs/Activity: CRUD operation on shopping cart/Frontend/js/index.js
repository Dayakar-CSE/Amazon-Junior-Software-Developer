const PRODUCTS_API_URL = "http://localhost:8080/api/v1/products"

let products = []

// TODO 1: create an async function fetchProductsFromAPI() that makes a GET request to the backend API and fetches all products as JSON
async function fetchProductsFromAPI() {
    try {
        const apiResponse = await fetch(PRODUCTS_API_URL)
        if (!apiResponse.ok) {
            alert("Error fetching products from API")
        }
        products = await apiResponse.json()
    } catch (error) {
        alert("Error fetching products from API")
    }
}

// TODO 2: create a function displayProducts() that renders the products in a product card inside the productContainer in index.html
function displayProducts() {
    const productsContainer = document.getElementById("productContainer")
    productsContainer.innerHTML = ""

    products.forEach(product => {
        const productElement = document.createElement("div")
        productElement.classList.add("product-card")
        productElement.innerHTML = `
            <img src="${product.image}" alt="${product.title}">
            <a href="product.html?id=${product.id}">${product.title}</a>
            <p>$${product.price.toFixed(2)} Rating: ${product.rating.rate}</p>
        `
        productsContainer.appendChild(productElement)
    })
}

// TODO 3: call the fetchProductsFromAPI() function and the displayProducts() function on window load
window.onload = async function () {
    await fetchProductsFromAPI()
    displayProducts()
}