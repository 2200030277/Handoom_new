package com.handloom.util;

import com.handloom.models.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBHelper {

    private static final String URL = "jdbc:mysql://localhost:3306/handloom";
    private static final String USER = "root";
    private static final String PASSWORD = "Mylife@143";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Method to get a database connection
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Method to fetch all products from the database
    public static List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        String query = "SELECT id, name, description, price, image_url FROM products";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");
                String image = resultSet.getString("image_url");

                // Create a new Product object and add it to the list
                Product product = new Product(id, name, description, price, image);
                products.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }
}
