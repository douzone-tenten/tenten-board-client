package com.douzonetenten.tentenboardclient.service;

import com.douzonetenten.tentenboardclient.dao.DouZoneTwoDao;
import com.douzonetenten.tentenboardclient.dao.PostDao;
import com.douzonetenten.tentenboardclient.dto.PostDto;

import java.sql.Connection;
import java.util.ArrayList;

import static com.douzonetenten.tentenboardclient.common.DBConnector.getConnection;

public class DouZoneTwoService {
    private final PostDao postDao = new PostDao();
    private final DouZoneTwoDao douZoneTwoDao = new DouZoneTwoDao();
    public ArrayList<PostDto> douzoneFindByAll(){
        Connection connection = getConnection();
        ArrayList<PostDto> douzone_List = douZoneTwoDao.douZoneFindByAll(connection);
        return douzone_List;
    }

}
