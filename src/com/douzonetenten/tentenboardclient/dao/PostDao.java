package com.douzonetenten.tentenboardclient.dao;

import com.douzonetenten.tentenboardclient.dto.JoinPostDto;
import com.douzonetenten.tentenboardclient.dto.PostDto;

import java.sql.*;
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

    public static int deletePost(Connection connection, String postNo){
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
                joinPostDto.setPostId(Long.valueOf(resultSet.getString("post_id")));
                joinPostDto.setPostTitle(resultSet.getString("post_title"));
                joinPostDto.setUsername(resultSet.getString("username"));
                joinPostDto.setCreatedAt(resultSet.getTimestamp("created_at"));
                joinPostDtoArrayList.add(joinPostDto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return joinPostDtoArrayList;
    }

    //수연 상세조회 테스트입니다.
    public ArrayList<JoinPostDto> findByPostDetail(Connection connection, String boardNum){
        ArrayList<JoinPostDto> joinPostDtoArrayList = null;
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("select board_board_no, post_id, post_title, post_body, u.username, u.name, p.created_at from post p left join user u on p.user_member_no = u.user_no where p.post_id = ?");
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

    public int editPost(Connection connection, PostDto postDto, String boardNumber) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("UPDATE post SET post_title = ?, post_body =? WHERE board_board_no = ?");
//            preparedStatement.setString(1,boardNumber); // 현재 내가 작성하려고 하는 보드의 PK
//            preparedStatement.setLong(2,loginUserContext.get(0).getUserNo()); // 현재 로그인한 사용자의 PK
//            preparedStatement.setTimestamp(3, new Timestamp(new java.util.Date().getTime()));
//            preparedStatement.setString(4, postDto.getPostTitle());
//            preparedStatement.setString(5, postDto.getPostBody());

              preparedStatement.setString(1,postDto.getPostTitle());
              preparedStatement.setString(2, postDto.getPostBody());
              preparedStatement.setString(3,boardNumber);

            int resultSet = preparedStatement.executeUpdate();
            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




    // 익명게시판 조회자 게시글만 조회
    // 로그인한 유저가 작성한 게시글만 보일 수 있도록 조회
    public ArrayList<JoinPostDto> findSameUserByPost(Connection connection, String user_no, String board_no){
        ArrayList<JoinPostDto> joinPostDtoArrayList = null;
        PreparedStatement preparedStatement = null;     // 쿼리문을 저장할 객체 생성

        try {
            /**
             * Board 테이블도 join 해서, 보드의 이름도 가지고 오면 좋을듯.
             */
            preparedStatement = connection.prepareStatement("select p.user_member_no ,p.board_board_no, p.post_id, p.post_title, p.post_body, u.username, u.name, p.created_at from post p left join user u on p.user_member_no = u.user_no where p.user_member_no = ? and p.board_board_no=?");
            preparedStatement.setString(1, user_no);
            preparedStatement.setString(2, board_no);
            joinPostDtoArrayList = new ArrayList<JoinPostDto>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                JoinPostDto joinPostDto = new JoinPostDto();
                joinPostDto.setPostId(Long.valueOf(resultSet.getString("post_id")));
                joinPostDto.setPostTitle(resultSet.getString("post_title"));
                joinPostDto.setPostBody(resultSet.getString("post_body"));
                joinPostDto.setUsername(resultSet.getString("username"));
                joinPostDto.setCreatedAt(resultSet.getTimestamp("created_at"));


                joinPostDtoArrayList.add(joinPostDto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return joinPostDtoArrayList;
    }


    // 익명게시판 게시글번호를 통해 게시글의 user_id 추출
    public ArrayList<PostDto> findIdByPost(Connection connection, String boardNum, String postId){
        ArrayList<PostDto> postDtoArrayList = null;
        PreparedStatement preparedStatement = null;

        try {
            /**
             * Board 테이블도 join 해서, 보드의 이름도 가지고 오면 좋을듯.
             */
            preparedStatement = connection.prepareStatement("select p.user_member_no from post p left join user u on p.user_member_no = u.user_no where p.board_board_no = ? and p.post_id=?");
            preparedStatement.setString(1,boardNum);
            preparedStatement.setString(2,postId);
            postDtoArrayList = new ArrayList<PostDto>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                PostDto postDto = new PostDto();

                postDto.setMemberNo(resultSet.getLong("user_member_no"));

                postDtoArrayList.add(postDto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return postDtoArrayList;
    }

    // 익명게시판의 상세조회
    public ArrayList<JoinPostDto> findDetailByPost(Connection connection, String boardNum, String postId, String userNo){
        ArrayList<JoinPostDto> joinPostDtoArrayList= null;
        PreparedStatement preparedStatement =null;


        try {
            preparedStatement=connection.prepareStatement("select p.user_member_no, board_board_no, post_id, post_title, post_body, u.username, u.name, p.created_at from post p left join user u on p.user_member_no = u.user_no where p.board_board_no = ? and p.post_id=?and user_member_no=?");
            preparedStatement.setString(1,boardNum);
            preparedStatement.setString(2,postId);
            preparedStatement.setString(3,userNo);

            joinPostDtoArrayList=new ArrayList<JoinPostDto>();
            ResultSet resultSet =preparedStatement.executeQuery();

            while (resultSet.next()){

                JoinPostDto joinPostDto =new JoinPostDto();
                joinPostDto.setPostId(resultSet.getLong("post_id"));
                joinPostDto.setPostBody(resultSet.getString("post_body"));
                joinPostDto.setPostTitle(resultSet.getString("post_title"));
                joinPostDto.setCreatedAt(resultSet.getTimestamp("created_at"));
                joinPostDto.setUsername(resultSet.getString("username"));

                joinPostDtoArrayList.add(joinPostDto);

            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return joinPostDtoArrayList;
    }

    // 익명게시판 게시글 삭제
    // 로그인한 유저가 본인글만 삭제 가능
    public int deleteIdByPost(Connection connection, String boardNo ,String userNo,String postNo){
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM post WHERE board_board_no = ? AND user_member_no = ? AND post_id = ?");

            preparedStatement.setString(1,boardNo);
            preparedStatement.setString(2,userNo);
            preparedStatement.setString(3,postNo);
            int resultSet = preparedStatement.executeUpdate();
            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 익명게시판 게시글 수정
    // 로그인한 유저가 본인글만 수정 가능







}
