package com.douzonetenten.tentenboardclient.dao;

import com.douzonetenten.tentenboardclient.dto.BoardDto;
import com.douzonetenten.tentenboardclient.dto.PostDto;

import com.douzonetenten.tentenboardclient.dto.BoardDto;
import com.douzonetenten.tentenboardclient.dto.UserDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class QnADao {
    public QnADao() {
    }

    //QnA 목록조회
    public ArrayList<PostDto> findAllByQnA(Connection connection) {
        ArrayList<PostDto> postDtoArrayList = null;
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM post WHERE board_board_no = ?");
            postDtoArrayList = new ArrayList();
            preparedStatement.setString(1, "4");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                PostDto postDto = new PostDto();
                postDto.setBoardNo(resultSet.getLong("board_board_no"));
                postDto.setMemberNo(resultSet.getLong("user_member_no"));
                postDto.setPostId(resultSet.getLong("post_id"));
                postDto.setCreatedAt(resultSet.getTimestamp("created_at"));
                postDto.setPostTitle(resultSet.getString("post_title"));
                postDto.setPostBody(resultSet.getString("post_body"));
                postDtoArrayList.add(postDto);
            }
            return postDtoArrayList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    //QnA 게시글 작성
    public int insertQnA(Connection connection, PostDto postDto){
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO post (board_board_no, user_member_no, created_at, post_title, post_body) values (?,?,?,?,?)");
            preparedStatement.setString(1, "4");
            preparedStatement.setString(2, "4");
            preparedStatement.setTimestamp(3, new Timestamp((new Date()).getTime()));
            preparedStatement.setString(4, postDto.getPostTitle());
            preparedStatement.setString(5, postDto.getPostBody());

            int resultSet = preparedStatement.executeUpdate();
            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
