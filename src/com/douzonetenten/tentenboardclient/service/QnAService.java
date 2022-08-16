package com.douzonetenten.tentenboardclient.service;

import com.douzonetenten.tentenboardclient.DBConnector;
import com.douzonetenten.tentenboardclient.dao.PostDao;
import com.douzonetenten.tentenboardclient.dao.QnADao;
import com.douzonetenten.tentenboardclient.dto.PostDto;

import java.sql.Connection;
import java.util.ArrayList;

public class QnAService {
    private final QnADao qnADao = new QnADao();

    public QnAService() {}
    public ArrayList<PostDto> findAllByQnA() {
        Connection connection = DBConnector.getConnection();
        ArrayList<PostDto> postDtoArrayList = this.qnADao.findAllByQnA(connection);
        return postDtoArrayList;
    }
}
