package com.douzonetenten.tentenboardclient.service;

import com.douzonetenten.tentenboardclient.dao.PostDao;
import com.douzonetenten.tentenboardclient.dto.JoinPostDto;
import com.douzonetenten.tentenboardclient.dto.PostDto;

import java.sql.Connection;
import java.util.ArrayList;

/**
 * wildcard import
 */
import static com.douzonetenten.tentenboardclient.common.DBConnector.*;

public class PostService {
    private final PostDao postDao = new PostDao();

    public int insertPost(PostDto postDto, String boardNumber) {
        Connection connection = getConnection();
        int result = postDao.insertPost(connection, postDto, boardNumber);
        if (result > 0) {
            commit(connection);
        } else rollback(connection);
        return result;
    }

    public static int deletePost(String postNo){
        Connection connection = getConnection();
        int result = PostDao.deletePost(connection,postNo);
        if (result > 0) {
            commit(connection);
        } else rollback(connection);
        return result;
    }

    // TODO : 포스트 수정 기능 추가.

    public ArrayList<PostDto> findAllByPost(){
        Connection connection = getConnection();
        ArrayList<PostDto> postDtoArrayList = postDao.findAllByPost(connection);
        return postDtoArrayList;
    }

    public ArrayList<JoinPostDto> findByPost(String boardNum){
        Connection connection = getConnection();
        ArrayList<JoinPostDto> joinPostDtoArrayList = postDao.findByPost(connection, boardNum);
        return joinPostDtoArrayList;
    }

    // 익명게시판에 사용
    // 상세조회 시 로그인한 유저가 쓴 글만 출력해주기
    public ArrayList<JoinPostDto> findSameUserByPost(String user_no, String board_no){
        Connection connection= getConnection();
        ArrayList<JoinPostDto> joinPostDtoArrayList = postDao.findSameUserByPost(connection, user_no, board_no);
        return  joinPostDtoArrayList;
    }

    // 익명게시판에서의 게시글번호를 통해 게시글의 user_id 추출
    public ArrayList<PostDto> findIdByPost(String boardNUm, String postId){
        Connection connection = getConnection();
        ArrayList<PostDto> PostDtoArrayList = postDao.findIdByPost(connection, boardNUm, postId);
        return PostDtoArrayList;
    }

    // 익명게시판 게시글 삭제
    // 로그인한 유저가 본인글만 삭제 가능

    public int deleteIdByPost(String boardNo, String userNo, String postNo){
        Connection connection = getConnection();
        int result = postDao.deleteIdByPost(connection, boardNo, userNo, postNo);
        if (result > 0) {
            commit(connection);
        } else rollback(connection);
        return result;
    }

    public int updateIdByPost(String boardNo, String userNo, String postNo, String postTitle, String postBody){
        Connection connection =getConnection();
        int result = postDao.updateIdByPost(connection, boardNo,  userNo,  postNo,  postTitle,  postBody);
        if(result>0){
            commit(connection);
        }else rollback(connection);
        return result;
    }

}
