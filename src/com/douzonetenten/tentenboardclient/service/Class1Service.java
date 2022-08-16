package com.douzonetenten.tentenboardclient.service;

import com.douzonetenten.tentenboardclient.dao.BoardDao;
import com.douzonetenten.tentenboardclient.dao.PostDao;
import com.douzonetenten.tentenboardclient.dto.BoardDto;
import com.douzonetenten.tentenboardclient.dto.JoinPostDto;

import java.sql.Connection;
import java.util.ArrayList;

import static com.douzonetenten.tentenboardclient.common.DBConnector.getConnection;

public class Class1Service {

    private static final PostDao postDao = new PostDao();
    public static ArrayList<JoinPostDto> findByPost(String selectNum) {
        Connection connection = getConnection();
        ArrayList<JoinPostDto> joinPostDtoArrayList = postDao.findByPost(connection, "2");
        return joinPostDtoArrayList;
    }
}
