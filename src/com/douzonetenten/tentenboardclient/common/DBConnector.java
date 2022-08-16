package com.douzonetenten.tentenboardclient.common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnector {
    private static Connection connection = null;
    public static Connection getConnection() {
        if (connection == null) {

//            try (connection = DriverManager.getConnection(url, username, password)) {
//                /**
//                 * Class.forName = JDBC 4 버전 이후부터는 사용을 안해도 됩니다.
//                 * https://kyun2.tistory.com/23
//                 */
//                connection.setAutoCommit(false);
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }

            try {
                Properties properties = new Properties();
                properties.load(new FileReader("resources/driver.properties"));
                connection = DriverManager.getConnection(
                        properties.getProperty("JDBC.ConnectionURL"),
                        properties.getProperty("JDBC.Username"),
                        properties.getProperty("JDBC.Password"));
                connection.setAutoCommit(false);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }

    public static void commit(Connection connection){
        try {
            /**
             * 드모르간 법칙 성립 안됨.
             */
            if (connection != null && !connection.isClosed()){
                connection.commit();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void rollback(Connection connection){
        try {
            if (connection != null && !connection.isClosed()){
                connection.rollback();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
