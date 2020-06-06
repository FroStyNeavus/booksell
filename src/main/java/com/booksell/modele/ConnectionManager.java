/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.booksell.modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author usager
 */
public class ConnectionManager {
    private static Connection cnx;
    private static String url = "",
            user = "", password = "";

    private ConnectionManager() {
    }

    public static Connection getConnection() {
        url = "jdbc:mysql://localhost/booksell?serverTimezone=UTC";
        user = "root";
        password = "root";
        try {
            if (cnx == null || cnx.isClosed())
                try {
                    if (user.equals(""))
                        cnx = DriverManager.getConnection(url);
                    else
                        Class.forName("com.mysql.cj.jdbc.Driver");
                    cnx = DriverManager.getConnection(url, user, password);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
                }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cnx;
    }

    public static void reinit() {
        close();
        cnx = null;
    }

    public static void close() {
        try {
            if (cnx != null) {
                cnx.close();
                cnx = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        ConnectionManager.url = url;
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        ConnectionManager.user = user;
    }

    public static void setPassword(String password) {
        ConnectionManager.password = password;
    }

}