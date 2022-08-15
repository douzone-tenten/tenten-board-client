package com.douzonetenten.tentenboardclient.dao;

import com.douzonetenten.tentenboardclient.dto.UserDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public UserDto login(Connection connection, UserDto userDto) {
        UserDto loginUserDto = new UserDto();

        try {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE username = ? AND password = ?");
            preparedStatement.setString(1, userDto.getUsername());
            preparedStatement.setString(2, userDto.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            // 로그인한 단 하나의 아이디만 들어있다.
            loginUserDto.setUserNo(resultSet.getLong("user_no"));
            loginUserDto.setUsername(resultSet.getString("username"));
            loginUserDto.setName(resultSet.getString("name"));
            loginUserDto.setDepartment(resultSet.getString("department"));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return loginUserDto;
    }


    public int insertUser(Connection connection, UserDto userDto) {
        /**
         * UTC 적용필요
         * User Unique Key 예외처리 해아함.
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
