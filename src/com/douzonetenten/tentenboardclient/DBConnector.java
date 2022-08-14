package com.douzonetenten.tentenboardclient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    private static Connection connection = null;
    public static Connection getConnection() {
        String url = "jdbc:mysql://43.200.9.118:52867/tentenboard";
        String username = "tenten";
        String password = "1010board";
        if (connection == null) {
            /**
             * try-with-resources 문법을 통해,
             * close를 하지 않아도 된다.
             */
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                /**
                 * Class.forName = JDBC 6 버전 이후부터는 사용을 안해도 됩니다.
                 */
                connection.setAutoCommit(false);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
}
