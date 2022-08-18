package com.douzonetenten.tentenboardclient.dao;

import com.douzonetenten.tentenboardclient.dto.ClassTwoJoinDto;
import com.douzonetenten.tentenboardclient.dto.JoinPostDto;
import com.douzonetenten.tentenboardclient.dto.PostDto;

import java.sql.*;
import java.util.ArrayList;

import static com.douzonetenten.tentenboardclient.service.UserService.loginUserContext;

public class DouZoneTwoDao {

    public ArrayList<ClassTwoJoinDto> douZoneFindByAll(Connection connection, String boardNum) {
        /**
         * douZoneFindByAll() = 선택한 게시판에 게시글을 모두 조회할 수 있는 메소드
         * detailPostToString() = joinPostDto 에 있는 값 출력 메소드
         * @param connection - DB 연결하는 매개변수
         * @param boardNum - 게시판 번호
         * @author 황명수
         */

        ArrayList<ClassTwoJoinDto> list = null;
        PreparedStatement preparedStatement = null;
//        String sql = "select * from post where board_board_no = 1";

        /**
         * post table(게시글) 에 없는 columns 을 user 테이블과 join을 통해 username 가져옴
         * select post_id,post_title,username,u.created_at
         * from post
         * left join user u on post.user_member_no = u.user_no where board_board_no = ?
         */

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

    public ArrayList<JoinPostDto> dzTwoDeTailSelect(Connection connection, int postId) {
        /**
         * dzTwoDeTailSelect() = 사용자가 선택한 게시판에 게시글을 상세조회할 수 있는 메소드
         * detailPostToString() = joinPostDto 에 있는 값 출력 메소드
         * @param connection - DB와 연결하는 매개변수
         * @param postId - 게시글 번호
         * @author 황명수
         */
        ArrayList<JoinPostDto> list = null;
        PreparedStatement preparedStatement = null;

        String sql = "select board_board_no, post_id, post_title, post_body, u.username, u.name, p.created_at from post p left join user u on p.user_member_no = u.user_no where p.post_id = ?";
        try {

            JoinPostDto joinPostDto = new JoinPostDto();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, postId);
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

    /*
    *
    UPDATE [테이블명1] A INNER JOIN [테이블명2] B
    ON A.[조인할 컬럼명] = B.[조인할 컬럼명]
    SET [변경할 컬럼명] = 변경할값
    * */


    public int douzoneTwoDelete(Connection connection, int postId) {
        /**
         * douzoneTwoDelete() = 사용자가 선택한 게시판에 게시글을 삭제할 수 있는 메소드
         * (단, 본인이 작성한 글만 삭제할 수 있다)
         * @param connection - DB와 연결하는 매개변수
         * @param postId - 게시글 번호
         * @author 황명수
         */

        /**
         * delete
         * from post where post_id = ? and user_member_no=(select user_no from user where username= ?
         * */
        int result = 0;
        PreparedStatement preparedStatement = null;
        String sql = "delete from post where post_id = ? and user_member_no=(select user_no from user where username= ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,postId);
            preparedStatement.setString(2,loginUserContext.get(0).getUsername());
            result = preparedStatement.executeUpdate();
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public int dzTwoUpdate(Connection connection,int postId,String title, String body) {
        /**
         * dzTwoUpdate() = 사용자가 선택한 게시판에 게시글을 수정할 수 있는 메소드
         * @param connection - DB와 연결하는 매개변수
         * @param postId - 게시글 번호
         * @param title - 게시글 제목
         * @param body - 게시글 내용
         * @author 황명수
         */

        /**
         * update
         * post p
         * Left Join user u on p.user_member_no = u.user_no
         * set post_title  = ?, post_body =? where username = ? AND post_id = ?
         * */
        int result = 0;

        PreparedStatement preparedStatement = null;
        String sql = "update post p Left Join user u on p.user_member_no = u.user_no set post_title  = ?, post_body =? where username = ? AND post_id = ?";

        try {

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,title);
            preparedStatement.setString(2,body);
            preparedStatement.setString(3,loginUserContext.get(0).getUsername());
            preparedStatement.setInt(4,postId);
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