package com.douzonetenten.tentenboardclient.dao;

import com.douzonetenten.tentenboardclient.dto.ClassTwoJoinDto;
import com.douzonetenten.tentenboardclient.dto.JoinPostDto;
import com.douzonetenten.tentenboardclient.dto.PostDto;

import java.sql.*;
import java.util.ArrayList;

import static com.douzonetenten.tentenboardclient.service.UserService.loginUserContext;

public class DouZoneTwoDao {


    public ArrayList<ClassTwoJoinDto> douZoneFindByAll(Connection connection, String boardNum) {
        ArrayList<ClassTwoJoinDto> list = null;
        PreparedStatement preparedStatement = null;
//        String sql = "select * from post where board_board_no = 1";


        String sql = "select post_id,post_title,username,u.created_at from post left join user u on post.user_member_no = u.user_no where board_board_no = ?";


        try {


            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, boardNum);
            list = new ArrayList<ClassTwoJoinDto>();
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                ClassTwoJoinDto douZoneTwoJoinDto = new ClassTwoJoinDto();
                douZoneTwoJoinDto.setpost_id(Long.valueOf(resultSet.getString("post_id")));
                douZoneTwoJoinDto.setPost_title(resultSet.getString("post_title"));
                douZoneTwoJoinDto.setUsername(resultSet.getString("username"));
                douZoneTwoJoinDto.setCreated_at(resultSet.getTimestamp("created_at"));

                list.add(douZoneTwoJoinDto);

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public ArrayList<JoinPostDto> dzTwoDeTailSelect(Connection connection, int post_id) {
        ArrayList<JoinPostDto> list = null;
        PreparedStatement preparedStatement = null;

        String sql = "select board_board_no, post_id, post_title, post_body, u.username, u.name, p.created_at from post p left join user u on p.user_member_no = u.user_no where p.post_id = ?";
        try {

            JoinPostDto joinPostDto = new JoinPostDto();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, post_id);
            list = new ArrayList<JoinPostDto>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                joinPostDto.setBoardNo(Long.valueOf(resultSet.getString("board_board_no")));
                joinPostDto.setPostId(Long.valueOf(resultSet.getString("post_id")));
                joinPostDto.setPostTitle(resultSet.getString("post_title"));
                joinPostDto.setPostBody(resultSet.getString("post_body"));
                joinPostDto.setUsername(resultSet.getString("username"));
                joinPostDto.setName(resultSet.getString("name"));
                joinPostDto.setCreatedAt(resultSet.getTimestamp("created_at"));

                list.add(joinPostDto);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;

    }


    public int douzoneTwoInsert(Connection connection, PostDto postDto, String BoardNum) {
        int result = 0;
        PreparedStatement preparedStatement = null;
        String sql = "insert into post(board_board_no, user_member_no, created_at, post_title, post_body) values (?,?,?,?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, BoardNum);
            preparedStatement.setLong(2, loginUserContext.get(0).getUserNo());
            preparedStatement.setTimestamp(3, new Timestamp(new java.util.Date().getTime()));
            preparedStatement.setString(4, postDto.getPostTitle());
            preparedStatement.setString(5, postDto.getPostBody());

            result = preparedStatement.executeUpdate();

            if (result > 0) {
                System.out.println("게시글 작성 성공");
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    /*
    *
    UPDATE [테이블명1] A INNER JOIN [테이블명2] B
    ON A.[조인할 컬럼명] = B.[조인할 컬럼명]
    SET [변경할 컬럼명] = 변경할값
    * */


    public int douzoneTwoDelete(Connection connection, int port_id) {
        int result = 0;
        PreparedStatement preparedStatement = null;
        String sql = "delete from post where post_id = ? and user_member_no=(select user_no from user where username= ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,port_id);
            preparedStatement.setString(2,loginUserContext.get(0).getUsername());
            result = preparedStatement.executeUpdate();
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    // login index 4 = name








    public int dzTwoUpdate(Connection connection,int port,String title, String body) {
        int result = 0;

        PreparedStatement preparedStatement = null;
        String sql = "update post p Left Join user u on p.user_member_no = u.user_no set post_title  = ?, post_body =? where username = ? AND post_id = ?";

        try {

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,title);
            preparedStatement.setString(2,body);
            preparedStatement.setString(3,loginUserContext.get(0).getUsername());
            preparedStatement.setInt(4,port);
            result = preparedStatement.executeUpdate();

            if(result > 0){
                System.out.println("성공");
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return result;

    }


}