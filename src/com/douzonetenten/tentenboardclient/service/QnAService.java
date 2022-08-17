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


    //QnA 게시글 목록조회
    public ArrayList<JoinPostDto> findAllByQnA(String selectNum) {
        Connection connection = DBConnector.getConnection();
        ArrayList<JoinPostDto> joinPostDtoArrayList = this.qnADao.findAllByQnA(connection, selectNum);
        return joinPostDtoArrayList;
    }


    //QnA 게시글 작성
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


    //QnA 게시글 상세조회
    public ArrayList<JoinPostDto> detailQnA(String selectDetailNum) {
        Connection connection = DBConnector.getConnection();
        ArrayList<JoinPostDto> joinPostDtoListDetail = this.qnADao.detailQnA(connection, selectDetailNum);

        return joinPostDtoListDetail;
    }
    
    
    //QnA 게시글 삭제
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


    //QnA 게시글 수정
    public int updateQnA(PostDto postDto, String selectDetailNum) {
        Connection connection = DBConnector.getConnection();
        int resultUpdate = this.qnADao.updateQnA(connection, postDto, selectDetailNum);

        if(resultUpdate > 0) {
            DBConnector.commit(connection);
        }
        else {
            DBConnector.rollback(connection);
        }
        return resultUpdate;
    }
}
