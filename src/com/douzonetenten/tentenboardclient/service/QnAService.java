package com.douzonetenten.tentenboardclient.service;

import com.douzonetenten.tentenboardclient.DBConnector;
import com.douzonetenten.tentenboardclient.dao.QnADao;
import com.douzonetenten.tentenboardclient.dto.PostDto;
import com.douzonetenten.tentenboardclient.dto.UserDto;

import java.sql.Connection;
import java.util.ArrayList;

public class QnAService {
    private final QnADao qnADao = new QnADao();

    public QnAService() {}


    //QnA 목록조회
    public ArrayList<PostDto> findAllByQnA() {
        Connection connection = DBConnector.getConnection();
        ArrayList<PostDto> postDtoArrayList = this.qnADao.findAllByQnA(connection);
        return postDtoArrayList;
    }

    public int insertPost(PostDto postDto) {
        Connection connection = DBConnector.getConnection();
        int result = this.qnADao.insertQnA(connection, postDto);
            if (result > 0){
                DBConnector.commit(connection);
            }
            else {
                DBConnector.rollback(connection);
            }
            return result;
    }
}
