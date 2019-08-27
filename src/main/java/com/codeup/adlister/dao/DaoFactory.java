package com.codeup.adlister.dao;


import com.codeup.adlister.models.User;

import java.util.List;

public class DaoFactory {
    private static Ads adsDao;
    private static User userDao;
    private static Config config = new Config();

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao(config);
        }
        return adsDao;
    }
//    public static User getUsers() {
//        if (userDao == null) {
//            userDao = new MySQLUsersDao(config);
//        }
//        return userDao;
//    }
}
