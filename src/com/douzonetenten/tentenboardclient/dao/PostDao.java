package com.douzonetenten.tentenboardclient.dao;

import com.douzonetenten.tentenboardclient.dto.PostDto;

import java.sql.*;

public class PostDao {
    public int insertPost(Connection connection, PostDto postDto){
        /**
         * 1. ...
         * 2. SQL Injection 공격을 방어하기 위해서
         */
        PreparedStatement preparedStatement = null;
        try {
            /**
             * SQL.timestamp를 이용하니, 시간과, 날짜가 제대로 바인딩 되어 들어감.
             */
            preparedStatement = connection.prepareStatement("INSERT INTO post (board_board_no, user_member_no, created_at, post_title, post_body) values (?,?,?,?,?)");
            preparedStatement.setString(1,"1"); // 현재 내가 작성하려고 하는 보드의 PK
            preparedStatement.setString(2,"1"); // 현재 로그인한 사용자의 PK
            preparedStatement.setTimestamp(3,new Timestamp(new java.util.Date().getTime()));
            preparedStatement.setString(4,postDto.getPostTitle());
            preparedStatement.setString(5,postDto.getPostBody());
            int resultSet = preparedStatement.executeUpdate();
            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
