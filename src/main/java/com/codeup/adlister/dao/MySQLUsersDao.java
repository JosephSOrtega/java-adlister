package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MySQLUsersDao implements Users {

    private Connection connection = null;

    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public Long insert(User user) {
        return null;
    }
}

//package com.codeup.adlister.dao;
//
//import com.codeup.adlister.models.Ad;
//import com.codeup.adlister.models.User;
//import com.mysql.cj.jdbc.Driver;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class MySQLUsersDao implements Users {
//    private Connection connection = null;
//
//    public MySQLUsersDao(Config config) {
//        try {
//            DriverManager.registerDriver(new Driver());
//            connection = DriverManager.getConnection(
//                    config.getUrl(),
//                    config.getUsername(),
//                    config.getPassword()
//            );
//        } catch (SQLException e) {
//            throw new RuntimeException("Error connecting to the database!", e);
//        }
//
//    }
//
//
//    @Override
//    public User findByUsername(String username) {
////        try {
////            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM User WHERE username like ?");
////            stmt.setString(1, username);
////            stmt.executeQuery();
////            ResultSet rs = stmt.getGeneratedKeys();
////            createListFromResults(rs);
////        } catch (SQLException e) {
////            throw new RuntimeException("Error creating a new ad.", e);
////        }
////    }
//
////    private List<String> createListFromResults(ResultSet rs) throws SQLException {
////        List<String> UsernameList = new ArrayList<>();
////        while (rs.next()) {
////            UsernameList.add(extractString(rs));
////        }
////        return UsernameList;
////    }
////
////    private String extractString(ResultSet rs) throws SQLException {
////        return rs.getString("username");
////    }
//    }
//
//    @Override
//    public Long insert(User user) {
//        return null;
//    }
//}
