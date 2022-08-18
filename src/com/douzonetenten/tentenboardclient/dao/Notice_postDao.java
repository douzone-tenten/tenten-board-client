package com.douzonetenten.tentenboardclient.dao;

import com.douzonetenten.tentenboardclient.dto.BoardDto;
import com.douzonetenten.tentenboardclient.dto.PostDto;
import com.douzonetenten.tentenboardclient.dto.Notice_JoinPostDto;

import java.sql.*;
import java.util.ArrayList;

public class Notice_postDao {

    public static int insertPost(Connection connection, PostDto postDto, BoardDto boardDto) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT  INTO  post (board_board_no, user_member_no, created_at, post_title, post_body) values (?,?,?,?,?)");
            preparedStatement.setString(1, "1");
            preparedStatement.setString(2, "1");
            preparedStatement.setString(3, String.valueOf(new Timestamp(new java.util.Date().getTime())));
            preparedStatement.setString(4, postDto.getPostTitle());
            preparedStatement.setString(5, postDto.getPostBody());
            int resultSet = preparedStatement.executeUpdate();
            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static int deletePost(Connection connection, String post_id) {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("DELETE FROM post WHERE post_id = ? ");
            preparedStatement.setString(1, post_id);
            int resultSet = preparedStatement.executeUpdate();
            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //DB에서 상세 조회에 필요한 컬럼 뽑아오기
    public static ArrayList<Notice_JoinPostDto> FindByAll(Connection connection, long post_id) {
        ArrayList<Notice_JoinPostDto> List = null;
        PreparedStatement preparedStatement = null;


        String sql = "select p.post_title, u.username, p.created_at, p.post_body from post p left join user u on p.user_member_no = u.user_no where p.post_id = ?";

        try {
            Notice_JoinPostDto noticeJoinPostDto = new Notice_JoinPostDto();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, post_id);
            List = new ArrayList<Notice_JoinPostDto>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Notice_JoinPostDto njp = new Notice_JoinPostDto();
                njp.setPost_title(resultSet.getString("post_title"));
                njp.setUsername(resultSet.getString("username"));
                njp.setCreated_at(resultSet.getTimestamp("created_at"));
                njp.setPost_body(resultSet.getString("post_body"));
                List.add(njp);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
            return List;
    }

    public static ArrayList<Notice_JoinPostDto> SubDelete(Connection connection, long post_id) {
        ArrayList<Notice_JoinPostDto> List = null;
        PreparedStatement preparedStatement = null;


        String sql = "delete from post (select userName from user where username = ?)";
        try {
            Notice_JoinPostDto noticeJoinPostDto = new Notice_JoinPostDto();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, post_id);
            List = new ArrayList<Notice_JoinPostDto>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Notice_JoinPostDto njp = new Notice_JoinPostDto();
                njp.setUsername(resultSet.getString("username"));
                List.add(njp);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return List;
    }
}