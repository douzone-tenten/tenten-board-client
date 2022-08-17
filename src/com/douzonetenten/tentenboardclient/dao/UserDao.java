package com.douzonetenten.tentenboardclient.dao;

import com.douzonetenten.tentenboardclient.dto.UserDto;
import com.douzonetenten.tentenboardclient.exception.user.UnAuthorizationException;

import java.sql.*;

public class UserDao {
    public UserDto login(Connection connection, UserDto userDto) throws UnAuthorizationException {
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
            throw new UnAuthorizationException();
        }
        return loginUserDto;
    }


    public int insertUser(Connection connection, UserDto userDto) {
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
            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
