package com.douzonetenten.tentenboardclient.service;

import com.douzonetenten.tentenboardclient.dao.PostDao;
import com.douzonetenten.tentenboardclient.dto.JoinPostDto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.douzonetenten.tentenboardclient.common.DBConnector.getConnection;

public class AnonymousService {

    private final PostDao postDao = new PostDao();

    public ArrayList<JoinPostDto> findDetailByPost(String boardNum, String postId, String userNo){
        Connection connection = getConnection();
        ArrayList<JoinPostDto> joinPostDtoArrayList = postDao.findDetailByPost(connection, boardNum, postId, userNo);
        return joinPostDtoArrayList;
    }


}
