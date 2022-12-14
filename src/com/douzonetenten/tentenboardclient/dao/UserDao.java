package com.douzonetenten.tentenboardclient.dao;

import com.douzonetenten.tentenboardclient.dto.UserDto;


import java.sql.*;

public class UserDao {
    public UserDto login(Connection connection, UserDto userDto){
        UserDto loginUserDto = new UserDto();
        try {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("SELECT * FROM user u LEFT JOIN user_roles ur on u.user_no = ur.user_user_no WHERE u.username = ? AND u.password = ?");
            preparedStatement.setString(1, userDto.getUsername());
            preparedStatement.setString(2, userDto.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            loginUserDto.setUserNo(resultSet.getLong("user_no"));
            loginUserDto.setUsername(resultSet.getString("username"));
            loginUserDto.setName(resultSet.getString("name"));
            loginUserDto.setDepartment(resultSet.getString("department"));
            loginUserDto.setRoleNo(resultSet.getLong("roles_role_no"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return loginUserDto;
    }


    public int insertUser(Connection connection, UserDto userDto) throws SQLException {
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


            /**
             * ????????? ?????? PK ??????
             */
            PreparedStatement selectPreparedStatement;
            selectPreparedStatement = connection.prepareStatement("SELECT * FROM user WHERE username = ?");
            selectPreparedStatement.setString(1, userDto.getUsername());

            ResultSet selectResultSet = selectPreparedStatement.executeQuery();
            selectResultSet.next();


            /**
             * ?????? ?????? ?????? ??????
             */
            PreparedStatement rolesPreparedStatement;
            rolesPreparedStatement = connection.prepareStatement("INSERT INTO user_roles(user_user_no) values (?)");
            rolesPreparedStatement.setLong(1,selectResultSet.getLong("user_no"));
            rolesPreparedStatement.executeUpdate();

            return resultSet;
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }
}
