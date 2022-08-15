package com.douzonetenten.tentenboardclient.dao;

import com.douzonetenten.tentenboardclient.dto.JoinPostDto;
import com.douzonetenten.tentenboardclient.dto.PostDto;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static com.douzonetenten.tentenboardclient.service.UserService.loginUserContext;

public class PostDao {
    public int insertPost(Connection connection, PostDto postDto , String boardNumber){
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
            preparedStatement.setString(1,boardNumber); // 현재 내가 작성하려고 하는 보드의 PK
            preparedStatement.setLong(2,loginUserContext.get(0).getUserNo()); // 현재 로그인한 사용자의 PK
            preparedStatement.setTimestamp(3, new Timestamp(new java.util.Date().getTime()));
            preparedStatement.setString(4, postDto.getPostTitle());
            preparedStatement.setString(5, postDto.getPostBody());
            int resultSet = preparedStatement.executeUpdate();
            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int deletePost(Connection connection, String postNo){
        PreparedStatement preparedStatement = null;
        try {
//            preparedStatement = connection.prepareStatement("DELETE FROM post WHERE board_board_no = ? AND user_member_no = ? AND post_id = ?");
            preparedStatement = connection.prepareStatement("DELETE FROM post WHERE post_id = ?");
            preparedStatement.setString(1,postNo);
            int resultSet = preparedStatement.executeUpdate();
            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<PostDto> findAllByPost(Connection connection){
        ArrayList<PostDto> postDtoArrayList = null;
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM post");
            postDtoArrayList = new ArrayList<PostDto>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                PostDto postDto = new PostDto();
                postDto.setBoardNo(Long.valueOf(resultSet.getString("board_board_no")));
                postDto.setMemberNo(Long.valueOf(resultSet.getString("user_member_no")));
                postDto.setPostId(Long.valueOf(resultSet.getString("post_id")));
                postDto.setCreatedAt(resultSet.getTimestamp("created_at"));
                postDto.setPostTitle(resultSet.getString("post_title"));
                postDto.setPostBody(resultSet.getString("post_body"));
                postDtoArrayList.add(postDto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return postDtoArrayList;
    }

    public ArrayList<JoinPostDto> findByPost(Connection connection, String boardNum){
        ArrayList<JoinPostDto> joinPostDtoArrayList = null;
        PreparedStatement preparedStatement = null;



        try {
            /**
             * Board 테이블도 join 해서, 보드의 이름도 가지고 오면 좋을듯.
             */
            preparedStatement = connection.prepareStatement("select board_board_no, post_id, post_title, post_body, u.username, u.name, p.created_at from post p left join user u on p.user_member_no = u.user_no where p.board_board_no = ?");
            preparedStatement.setString(1,boardNum);
            joinPostDtoArrayList = new ArrayList<JoinPostDto>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                JoinPostDto joinPostDto = new JoinPostDto();
                joinPostDto.setBoardNo(Long.valueOf(resultSet.getString("board_board_no")));
                joinPostDto.setPostId(Long.valueOf(resultSet.getString("post_id")));
                joinPostDto.setPostTitle(resultSet.getString("post_title"));
                joinPostDto.setPostBody(resultSet.getString("post_body"));
                joinPostDto.setUsername(resultSet.getString("username"));
                joinPostDto.setName(resultSet.getString("name"));
                joinPostDto.setCreatedAt(resultSet.getTimestamp("created_at"));
                joinPostDtoArrayList.add(joinPostDto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return joinPostDtoArrayList;
    }
}
