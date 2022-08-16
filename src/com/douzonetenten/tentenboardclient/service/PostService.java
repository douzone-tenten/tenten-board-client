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
}
