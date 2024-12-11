package com.handloom.servlet;

import com.handloom.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/testConnection")
public class TestConnectionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Try to get a connection to the database
        try (Connection connection = DBUtil.getConnection()) {
            if (connection != null) {
                response.getWriter().write("Database connection successful!");
            } else {
                response.getWriter().write("Failed to connect to the database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().write("Error occurred while connecting to the database.");
        }
    }
}
