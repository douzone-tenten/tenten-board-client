package com.douzonetenten.tentenboardclient.dao;

import java.sql.*;

public class UserDao {

//    public void findAll(Connection connection) {
//        try (connection = DriverManager.getConnection(url, username, password)) {
//            PreparedStatement preparedStatement;
//            preparedStatement = connection.prepareStatement("SELECT * FROM user");
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                System.out.println(resultSet.getString("username"));
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public int createUser(Connection connection){

            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("DELETE FROM user where name = '김민준'");
            preparedStatement = connection.prepareStatement("INSERT INTO user(username,password,department,name,created_at) values (?,?,?,?,?)");
            preparedStatement.setString(1,"kimminjun");
            preparedStatement.setString(2,"minjun");
            preparedStatement.setString(3,"1반");
            preparedStatement.setString(4,"김민준");
            preparedStatement.setDate(5,new Date(new java.util.Date().getTime()));
            /**
             * executeQuery : SELECT
             * executeUpdate : INSERT INTO , CREATE, DELETE, DROP
             */
            int resultSet = preparedStatement.executeUpdate();
            System.out.println(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

