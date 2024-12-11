<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.handloom.models.Cart" %>
<%@ page import="java.text.DecimalFormat" %>

<%
    // Get the cart items from the session or request
    List<Cart> cartItems = (List<Cart>) session.getAttribute("cart-list");
    DecimalFormat dcf = new DecimalFormat("#.##");

    // Initialize total price variable
    double totalPrice = 0.0;
%>

<!DOCTYPE html>
<html>
<head>
    <title>Checkout</title>
    <style type="text/css">
        .table tbody td{
            vertical-align: middle;
        }
    </style>
</head>
<body>
    <div class="container my-3">
        <h3>Checkout</h3>

        <% if (cartItems != null && !cartItems.isEmpty()) { %>
            <ul>
                <%
                    // Loop through cartItems and calculate the total price
                    for (Cart item : cartItems) {
                        totalPrice += item.getPrice(); // Add item price to total
                %>
                    <li><%= item.getName() %> - $<%= item.getPrice() %></li>
                <% 
                    }
                %>
            </ul>
            <h4>Total Price: $<%= dcf.format(totalPrice) %></h4>

            <!-- Add form for proceeding with the order -->
            <form action="place-order" method="post">
                <input type="hidden" name="totalPrice" value="<%= totalPrice %>">
                <button type="submit" class="btn btn-primary">Place Order</button>
            </form>

        <% } else { %>
            <p>Your cart is empty. Please add items to your cart before checking out.</p>
        <% } %>
    </div>
</body>
</html>
