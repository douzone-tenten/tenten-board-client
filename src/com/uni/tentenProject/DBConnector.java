package com.uni.tentenProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    private static Connection connection = null;

    public static Connection getConnection(){
        String url = "jdbc:mysql://43.200.9.118:52867/tentenboard";
        String username = "tenten";
        String password = "1010board";

        if(connection == null){
            try {
                connection = DriverManager.getConnection(url, username, password);
                connection.setAutoCommit(false);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }

    public static void commit(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.commit();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void rollback(Connection connection){
        try {
            if(connection != null && !connection.isClosed()){
                connection.rollback();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
