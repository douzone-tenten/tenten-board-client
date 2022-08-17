package com.douzonetenten.tentenboardclient.service;

import com.douzonetenten.tentenboardclient.dao.PostDao;
import com.douzonetenten.tentenboardclient.dto.JoinPostDto;
import com.douzonetenten.tentenboardclient.dto.PostDto;

import java.sql.Connection;
import java.util.ArrayList;

import static com.douzonetenten.tentenboardclient.common.DBConnector.*;

public class Class1Service {

    private static final PostDao postDao = new PostDao();
    public static ArrayList<JoinPostDto> findByPost(String selectNum) {
        Connection connection = getConnection();
        ArrayList<JoinPostDto> joinPostDtoArrayList = postDao.findByPost(connection, "2");
        return joinPostDtoArrayList;
    }

    public int insertPost(PostDto postDto, String boardNumber) {
        Connection connection = getConnection();
        int result = postDao.insertPost(connection, postDto, boardNumber);
        if (result > 0) {
            commit(connection);
        } else rollback(connection);
        return result;
    }

    public int deletePost(String selectPost) {
        Connection connection = getConnection();
        int result = postDao.deletePost(connection,selectPost);
        if (result > 0) {
            commit(connection);
        } else rollback(connection);
        return result;
    }

    public static ArrayList<JoinPostDto> detailPost(String selectPost) {//선택 포스팅 보기
        Connection connection = getConnection();
        ArrayList<JoinPostDto> joinPostDtoArrayList = postDao.findByPostDetail(connection, selectPost);
        return joinPostDtoArrayList;
    }
}
