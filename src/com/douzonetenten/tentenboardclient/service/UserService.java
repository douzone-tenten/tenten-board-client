package com.douzonetenten.tentenboardclient.service;

import com.douzonetenten.tentenboardclient.dao.UserDao;

import java.sql.Connection;

import static com.douzonetenten.tentenboardclient.DBConnector.getConnection;

public class UserService {
    private UserDao userDao = new UserDao();

//    public void findAll(){
////        Connection connection = getConnection();
//        userDao.findAll();
//    }

//    public void createUser(){
//        userDao.createUser();
//    }
}
