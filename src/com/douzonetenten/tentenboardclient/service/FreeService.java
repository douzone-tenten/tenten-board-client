package com.douzonetenten.tentenboardclient.service;

import com.douzonetenten.tentenboardclient.dao.PostDao;
import com.douzonetenten.tentenboardclient.dto.JoinPostDto;
import com.douzonetenten.tentenboardclient.dto.PostDto;

import java.sql.Connection;
import java.util.ArrayList;

import static com.douzonetenten.tentenboardclient.common.DBConnector.*;

public class FreeService {

    private final PostDao postDao = new PostDao();

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

    public ArrayList<JoinPostDto> FindDetailByPost(String boardNum, String postId, String userNo){
        Connection connection = getConnection();
        ArrayList<JoinPostDto> joinPostDtoArrayList = postDao.FindDetailByPost(connection, boardNum, postId, userNo);
        return joinPostDtoArrayList;
    }


}

