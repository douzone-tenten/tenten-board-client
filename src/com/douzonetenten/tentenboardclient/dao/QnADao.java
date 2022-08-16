package com.douzonetenten.tentenboardclient.dao;

import com.douzonetenten.tentenboardclient.dto.BoardDto;
import com.douzonetenten.tentenboardclient.dto.PostDto;

import com.douzonetenten.tentenboardclient.dto.BoardDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QnADao {
    public QnADao() {
    }

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
                postDto.setPostId(resultSet.getLong("post_id"));
                postDtoArrayList.add(postDto);
            }
            return postDtoArrayList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
