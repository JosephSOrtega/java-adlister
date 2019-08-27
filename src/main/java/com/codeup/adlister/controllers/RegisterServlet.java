package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.Config;
import com.codeup.adlister.dao.MySQLUsersDao;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: show the registration form
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User newUser = new User(1, username, email, password);

        // TODO: ensure the submitted information is valid
        boolean validAttempt = false;
        Config config = new Config();

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
            try {
                PreparedStatement stmt = connection.prepareStatement("insert  INTO User(id, username, email, password) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
                stmt.setLong(1,newUser.getId());
                stmt.setString(2,newUser.getUsername());
                stmt.setString(3,newUser.getEmail());
                stmt.setString(4,newUser.getPassword());
                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();
//                rs.next();
//                rs.getLong(1);
                validAttempt = true;
            } catch (SQLException e) {
                throw new RuntimeException("Error creating a new ad.", e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (validAttempt) {
            // TODO: store the logged in user object in the session, instead of just the username
            request.getSession().setAttribute("user", username);
            response.sendRedirect("/profile");
        } else {
            response.sendRedirect("/register");
        }

        // TODO: create a new user based off of the submitted information
        // TODO: if a user was successfully created, send them to their profile
    }
}
