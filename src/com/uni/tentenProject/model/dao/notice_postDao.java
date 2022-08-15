package com.uni.tentenProject.model.dao;

import com.uni.tentenProject.model.dto.notice_post_dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class notice_postDao {

    public static int insertPost(Connection connection, notice_post_dto notice_post_dto){
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT  INTO  post (board_board_no, user_member_no, created_at, post_title, post_body) values (?,?,?,?,?)");
            preparedStatement.setString(1,"1");
            preparedStatement.setString(2, "1");
            preparedStatement.setString(3, String.valueOf(new Timestamp(new java.util.Date().getTime())));
            preparedStatement.setString(4, notice_post_dto.getPostTitle());
            preparedStatement.setString(5, notice_post_dto.getPostBody());
            int resultSet = preparedStatement.executeUpdate();
            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
