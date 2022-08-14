package com.douzonetenten.tentenboardclient.dao;

import com.douzonetenten.tentenboardclient.dto.UserDto;

import java.sql.*;
import java.util.ArrayList;

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
//    preparedStatement = connection.prepareStatement("DELETE FROM user where name = '김민준'");
//        }
//    }

    public int insertUser(Connection connection, UserDto userDto) {
        /**
         * UTC 적용필요
         */
        try {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("INSERT INTO user(username,password,department,name,created_at) values (?,?,?,?,?)");
            preparedStatement.setString(1, userDto.getUsername());
            preparedStatement.setString(2, userDto.getPassword());
            preparedStatement.setString(3, userDto.getDepartment());
            preparedStatement.setString(4, userDto.getName());
            preparedStatement.setTimestamp(5, new Timestamp(new java.util.Date().getTime()));
            /**
             * executeQuery : SELECT
             * executeUpdate : INSERT INTO , CREATE, DELETE, DROP
             */
            int resultSet = preparedStatement.executeUpdate();
            System.out.println(resultSet);
            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
