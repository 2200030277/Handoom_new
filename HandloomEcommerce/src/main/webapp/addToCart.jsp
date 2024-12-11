<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shopping Cart</title>
</head>
<body>
    <h1>Shopping Cart</h1>
    <%
        String product = request.getParameter("product");
    %>

    <p>You added: <%= product %></p>
    <a href="index.jsp">Go back to Home</a>
</body>
</html>
