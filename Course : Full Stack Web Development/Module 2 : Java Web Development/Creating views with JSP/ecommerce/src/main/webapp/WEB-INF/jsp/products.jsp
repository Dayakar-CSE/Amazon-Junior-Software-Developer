<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!-- TODO 11: Create the basic HTML structure by declaring the document type and opening html and head tags -->
<!DOCTYPE html>
<html>
    <head>
        <!-- TODO 12: Set the title of the page to "Product List" and close the head tag-->
        <title>Product List</title>
        <!-- TODO 17: Add a link tag to include the product-styles.css file -->
        <link rel="stylesheet" href="/css/product-styles.css">
    </head>
    <!-- TODO 13: Add the body tag and a heading tag with the text "Available Products" -->
    <body>
        <h1> Available Products </h1>

        <!-- TODO 14: Add a table with headers for ID, Name, Description, and Price. Set the table’s border attribute to 1 -->
        <table border = "1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Price</th>
                </tr>
            </thead>
            <!-- TODO 15: Inside a tbody tag and use the JSTL forEach tag to iterate over the “products” list passed by the controller -->
            <tbody>
                <c:forEach var="product" items="${products}">
                    <!-- TODO 16: Add a tr tag with td tags for the product’s ID, name, description, and price -->
                    <tr>
                        <td>${product.id}</td>
                        <td>${product.name}</td>
                        <td>${product.description}</td>
                        <td>${product.price}</td>
                    </tr>
                </c:forEach>
            </tbody>
         </table>
    </body>
</html>



