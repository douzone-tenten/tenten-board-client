package com.douzonetenten.tentenboardclient.service;

import com.douzonetenten.tentenboardclient.common.DBConnector;
import com.douzonetenten.tentenboardclient.dao.QnADao;
import com.douzonetenten.tentenboardclient.dto.JoinPostDto;
import com.douzonetenten.tentenboardclient.dto.PostDto;


import java.sql.Connection;
import java.util.ArrayList;

public class QnAService {
    private final QnADao qnADao = new QnADao();

    public QnAService() {}


    //QnA 목록조회
    public ArrayList<JoinPostDto> findAllByQnA(String selectNum) {
        Connection connection = DBConnector.getConnection();
        ArrayList<JoinPostDto> joinPostDtoArrayList = this.qnADao.findAllByQnA(connection, selectNum);
        return joinPostDtoArrayList;
    }

    public int insertQnA(PostDto postDto, Long userId, String selectNum) {
        Connection connection = DBConnector.getConnection();
        int result = this.qnADao.insertQnA(connection, postDto, userId, selectNum);
            if (result > 0){
                DBConnector.commit(connection);
            }
            else {
                DBConnector.rollback(connection);
            }
            return result;
    }

    public int deleteQnA(String postNo) {
        Connection connection = DBConnector.getConnection();
        int result = this.qnADao.deleteQnA(connection, postNo);
        if(result > 0) {
            DBConnector.commit(connection);
        }
        else {
            DBConnector.rollback(connection);
        }
        return result;
    }
}
