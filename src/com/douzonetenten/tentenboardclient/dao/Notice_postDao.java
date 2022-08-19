package com.douzonetenten.tentenboardclient.dao;

import com.douzonetenten.tentenboardclient.dto.Notice_JoinPostDto;

import java.sql.*;
import java.util.ArrayList;

import static com.douzonetenten.tentenboardclient.service.UserService.loginUserContext;

public class Notice_postDao {
    /**
     * insertPost : 공지사항 게시판 게시글 작성하는 메서드
     * @param  connection : sql과 java를 연결해주는 매개변수
     * @author 김승혁
     * */
    public static int insertPost(Connection connection, Notice_JoinPostDto noticeJoinPostDto, String boardNumber) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT  INTO  post (board_board_no, user_member_no, created_at, post_title, post_body) values (?,?,?,?,?)");
            preparedStatement.setString(1, "1");
            preparedStatement.setString(2, "1");
            preparedStatement.setString(3, String.valueOf(new Timestamp(new java.util.Date().getTime())));
            preparedStatement.setString(4, noticeJoinPostDto.getPost_title());
            preparedStatement.setString(5, noticeJoinPostDto.getPost_body());
            int resultSet = preparedStatement.executeUpdate();
            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * deletePost : 공지사항 게시판 게시글을 삭제하는 메서드
     * @param  post_id : 게시글 번호 매개변수
     * @author 김승혁
     * */
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

    /**
     * FindByAll : 공지사항 게시판의 전체 게시글을 조회하는 메서드 / DB에서 상세 조회에 필요한 컬럼 뽑아오기 위해 사용하는 메서드
     * @param  post_id : 게시글 번호 매개변수
     * @author 김승혁
     * */
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

    /**
     * SubDelete : 상세 조회한 게시글을 삭제하기 위해 사용하는 메서드,
     * loginUserContext.get(0).getUsername()을 이용하여 게시글의 작성자의 아이디와 비교하여 같은 아이디여야만 게시글을 삭제할 수 있록 하는 메서드
     * @param  postId : post_id와 같은 게시글 번호 매개변수
     * @author 김승혁
     * */
    public static int SubDelete(Connection connection, int postId) {
        ArrayList<Notice_JoinPostDto> List = null;
        PreparedStatement preparedStatement = null;
        int result = 0;

        String sql = "delete from post where post_id = ? and user_member_no=(select user_no from user where username= ?)";
        try {

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, postId);
            preparedStatement.setString(2,loginUserContext.get(0).getUsername());
            result = preparedStatement.executeUpdate();
            return result;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * update : 상세 조회한 게시글을 수정하는 메서드,
     * loginUserContext.get(0).getUsername()를 사용하여 게시글 작성자 아이디를 비교하여 같은 아이디가 아니라면
     * 공지사항 게시글을 수정하지 못하게 하는 메서드
     * @param  postId : 게시글 번호 매개변수
     * @param  title : 게시글의 제목 매개변수
     * @param  body : 게시글의 내용 매개변수
     * @author 김승혁
     * */
    public int update(Connection connection,int postId,String title, String body) {
        int result = 0;

        PreparedStatement preparedStatement = null;
        String sql = "update post p Left Join user u on p.user_member_no = u.user_no set post_title  = ?, post_body =? where post_id = ? and username = ?";

        try {

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,title);
            preparedStatement.setString(2,body);
            preparedStatement.setInt(3,postId);
            preparedStatement.setString(4,loginUserContext.get(0).getUsername());
            result = preparedStatement.executeUpdate();
            return result;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }
}