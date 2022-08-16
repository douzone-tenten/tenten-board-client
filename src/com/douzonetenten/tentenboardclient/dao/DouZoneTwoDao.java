package com.douzonetenten.tentenboardclient.dao;

import com.douzonetenten.tentenboardclient.dto.PostDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.douzonetenten.tentenboardclient.common.DBConnector.getConnection;
import static com.douzonetenten.tentenboardclient.service.UserService.loginUserContext;
import static com.douzonetenten.tentenboardclient.service.UserService.loginUserContext;
public class DouZoneTwoDao {


    public ArrayList<PostDto> douZoneFindByAll(Connection connection) {
            ArrayList<PostDto> list = null;
            PreparedStatement preparedStatement = null;
            String sql = "select * from post where board_board_no = 7";
        try {
            list = new ArrayList<PostDto>();
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                PostDto postDto = new PostDto();
                postDto.setBoardNo(Long.valueOf(resultSet.getString("board_board_no")));
                postDto.setMemberNo(Long.valueOf(resultSet.getString("user_member_no")));
                postDto.setPostId(Long.valueOf(resultSet.getString("post_id")));
                postDto.setCreatedAt(resultSet.getTimestamp("created_at"));
                postDto.setPostTitle(resultSet.getString("post_title"));
                postDto.setPostBody(resultSet.getString("post_body"));
                list.add(postDto);

            }
            return list;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }










}