package com.douzonetenten.tentenboardclient.dao;

import com.douzonetenten.tentenboardclient.dto.JoinPostDto;
import com.douzonetenten.tentenboardclient.dto.PostDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class QnADao {
    public QnADao() {
    }

    //QnA 게시글 목록조회
    public ArrayList<JoinPostDto> findAllByQnA(Connection connection, String selectNum) {
        ArrayList<JoinPostDto> joinPostDtoArrayList = null;
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(
                    "SELECT post_id, post_title, username FROM post LEFT JOIN user u ON user_member_no = u.user_no WHERE board_board_no = ?");

            joinPostDtoArrayList = new ArrayList();
            preparedStatement.setString(1, selectNum);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                JoinPostDto joinPostDto = new JoinPostDto();
                joinPostDto.setPostId(resultSet.getLong("post_id"));
                joinPostDto.setPostTitle(resultSet.getString("post_title"));
                joinPostDto.setUsername(resultSet.getString("username"));
               // joinPostDto.setCreatedAt(resultSet.getTimestamp("created_at"));

                joinPostDtoArrayList.add(joinPostDto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return joinPostDtoArrayList;
    }


    //QnA 게시글 작성
    public int insertQnA(Connection connection, PostDto postDto, Long userId, String selectNum){
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO post (board_board_no, user_member_no, created_at, post_title, post_body) values (?,?,?,?,?)");
            preparedStatement.setString(1, selectNum);
            preparedStatement.setLong(2, userId);
            preparedStatement.setTimestamp(3, new Timestamp((new Date()).getTime()));
            preparedStatement.setString(4, postDto.getPostTitle());
            preparedStatement.setString(5, postDto.getPostBody());

            int resultSet = preparedStatement.executeUpdate();
            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    //QnA 게시글 상세조회
    public ArrayList<JoinPostDto> detailQnA(Connection connection, String selectDetailNum) {
        ArrayList<JoinPostDto> joinPostDtoListDetail = null;
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(
                    "SELECT post_title, username, post_body FROM post LEFT JOIN user u ON user_member_no = u.user_no WHERE post_id = ?");

            joinPostDtoListDetail = new ArrayList<>();
            preparedStatement.setString(1, selectDetailNum);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                JoinPostDto joinPostDto = new JoinPostDto();
                joinPostDto.setPostTitle(resultSet.getString("post_title"));
                joinPostDto.setUsername(resultSet.getString("username"));
               // joinPostDto.setCreatedAt(resultSet.getTimestamp("created_at"));
                joinPostDto.setPostBody(resultSet.getString("post_body"));

                joinPostDtoListDetail.add(joinPostDto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return joinPostDtoListDetail;
    }


    //QnA 게시글 삭제
    public int deleteQnA(Connection connection, String postNo) {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("DELETE FROM post WHERE post_id = ?");
            preparedStatement.setString(1, postNo);
            int resultSet = preparedStatement.executeUpdate();
            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    //QnA 게시글 수정
    public int updateQnA(Connection connection, PostDto postDto, String selectDetailNum) {

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(
                    "UPDATE post p LEFT JOIN user u ON p.user_member_no = u.user_no SET post_title = ?, post_body =? WHERE post_id = ?");
            preparedStatement.setString(1, postDto.getPostTitle());
            preparedStatement.setString(2, postDto.getPostBody());
            preparedStatement.setString(3, selectDetailNum);
            int resultSet = preparedStatement.executeUpdate();
            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
