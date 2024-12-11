<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order Confirmation</title>
</head>
<body>
    <h1>Order Confirmation</h1>

    <%
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        
        if (name != null && address != null) {
            // Simulate order completion by clearing the cart
            session.removeAttribute("cart");
    %>
        <p>Thank you <%= name %>! Your order will be shipped to <%= address %>.</p>
        <a href="index.jsp">Back to Home</a>
    <%
        } else {
    %>
        <p>Error: Order could not be completed. Please try again.</p>
        <a href="checkout.jsp">Go back to Checkout</a>
    <%
        }
    %>

</body>
</html>
