<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Details</title>
</head>
<body>
    <h1>Product Details</h1>

    <%
        String productId = request.getParameter("productId");
        // Simulate fetching product details (In real applications, you would query the database here)
        String productName = "Sample Product " + productId;
        String productDescription = "Detailed description of the product.";
        double price = 199.99;

        if (productId != null) {
    %>
        <h2><%= productName %></h2>
        <p><%= productDescription %></p>
        <p>Price: $<%= price %></p>
        <a href="addToCart.jsp?product=<%= productName %>">Add to Cart</a>
        <a href="index.jsp">Back to Home</a>
    <%
        } else {
    %>
        <p>Product not found.</p>
    <%
        }
    %>
</body>
</html>
