package com.douzonetenten.tentenboardclient.dao;

import com.douzonetenten.tentenboardclient.dto.DouZoneTwoJoinDto;
import com.douzonetenten.tentenboardclient.dto.PostDto;

import java.sql.*;
import java.util.ArrayList;

import static com.douzonetenten.tentenboardclient.common.DBConnector.getConnection;
import static com.douzonetenten.tentenboardclient.service.UserService.loginUserContext;
import static com.douzonetenten.tentenboardclient.service.UserService.loginUserContext;
import static com.douzonetenten.tentenboardclient.service.UserService.loginUserContext;
public class DouZoneTwoDao {


    public ArrayList<DouZoneTwoJoinDto> douZoneFindByAll(Connection connection,String boardNum) {
        ArrayList<DouZoneTwoJoinDto> list = null;
        PreparedStatement preparedStatement = null;
//        String sql = "select * from post where board_board_no = 1";



        String sql = "select post_id,post_title,username,u.created_at from post left join user u on post.user_member_no = u.user_no where board_board_no = ?";


        try {


            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,boardNum);
            list = new ArrayList<DouZoneTwoJoinDto>();
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                DouZoneTwoJoinDto douZoneTwoJoinDto = new DouZoneTwoJoinDto();
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

    public ArrayList<DouZoneTwoJoinDto> dzTwoDeTailSelect(Connection connection,String boardNum) {
        ArrayList<DouZoneTwoJoinDto> list = null;
        PreparedStatement preparedStatement = null;

        String sql = "select post_id,post_title,post_body,username,u.created_at from post left join user u on post.user_member_no = u.user_no where post_id = ?";
        try {
            DouZoneTwoJoinDto douZoneTwoJoinDto = new DouZoneTwoJoinDto();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, douZoneTwoJoinDto.getpost_id());
            list = new ArrayList<DouZoneTwoJoinDto>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                douZoneTwoJoinDto.setPost_title(resultSet.getString("post_title"));
                douZoneTwoJoinDto.setPost_body(resultSet.getString("post_body"));
                douZoneTwoJoinDto.setUsername(resultSet.getString("username"));
                douZoneTwoJoinDto.setCreated_at(resultSet.getTimestamp("created_at"));

                list.add(douZoneTwoJoinDto);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;

    }



    public int douzoneTwoInsert(Connection connection,PostDto postDto,String BoardNum) {
        int result =0;
        PreparedStatement preparedStatement = null;
        String sql = "insert into post(board_board_no, user_member_no, created_at, post_title, post_body) values (?,?,?,?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,BoardNum);
            preparedStatement.setLong(2,loginUserContext.get(0).getUserNo());
            preparedStatement.setTimestamp(3,new Timestamp(new java.util.Date().getTime()));
            preparedStatement.setString(4, postDto.getPostTitle());
            preparedStatement.setString(5, postDto.getPostBody());

            result = preparedStatement.executeUpdate();

            if (result > 0){
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
    public int douzoneTwoUpdate(Connection connection,PostDto postDto,String BoardNum ){
        int result = 0;
        PreparedStatement preparedStatement = null;
        String sql = "update post set postitle = ? , post_body = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,postDto.getPostTitle());
            preparedStatement.setString(2,postDto.getPostBody());
            result = preparedStatement.executeUpdate();
            if (result > 0){
                System.out.println("수정이 성공 되었습니다.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return result;
    }

    public int douzoneTwoDelete(Connection connection, String BoardNum){
        int result = 0;
        PreparedStatement preparedStatement = null;
        String sql = "Delete post ";

        return result;
    }

    // login index 4 = name

}