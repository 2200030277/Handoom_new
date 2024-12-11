package com.handloom.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.handloom.models.Product;

import java.io.*;
import java.util.*;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the product name and price from the request
    	String idstr=request.getParameter("id");
        String productName = request.getParameter("name");
        String description=request.getParameter("description");
        String priceStr = request.getParameter("price");
        String image=request.getParameter("image_url");

        // Check if the price is null or empty before trying to parse it
        if (productName != null && priceStr != null && !priceStr.isEmpty()) {
            try {
            	// Convert id to int
                int id = Integer.parseInt(idstr);

                // Convert price to Double
                double price = Double.parseDouble(priceStr);
                Product product = new Product(id,productName,description,price,image);

                // Get the cart from the session
                HttpSession session = request.getSession();
                List<Product> cartItems = new ArrayList<>();
             // Add product to cart
             cartItems.add(new Product(id,productName,description,price,image));
             request.setAttribute("cartItems", cartItems);

            } catch (NumberFormatException e) {
                // Handle the case where the price is not a valid number
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid price format.");
                return;
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Product name or price is missing.");
            return;
        }

        // Redirect back to the home page
        response.sendRedirect("index.jsp");
    }

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // You can handle POST requests if needed for cart functionality
}
}

