package com.douzonetenten.tentenboardclient.service;

import com.douzonetenten.tentenboardclient.dao.DouZoneTwoDao;
import com.douzonetenten.tentenboardclient.dao.PostDao;
import com.douzonetenten.tentenboardclient.dto.ClassTwoJoinDto;
import com.douzonetenten.tentenboardclient.dto.PostDto;

import java.sql.Connection;
import java.util.ArrayList;

import static com.douzonetenten.tentenboardclient.common.DBConnector.*;

public class ClassTwoService {
    private final PostDao postDao = new PostDao();
    private final DouZoneTwoDao douZoneTwoDao = new DouZoneTwoDao();

    public ArrayList<ClassTwoJoinDto> douzoneFindByAll(String boardNum){
        Connection connection = getConnection();
        ArrayList<ClassTwoJoinDto> douzone_List = douZoneTwoDao.douZoneFindByAll(connection,boardNum);
        return douzone_List;
    }
    public int douZoneTwoInsert(PostDto postDto, String boardNum) {
        Connection connection = getConnection();
        int result = postDao.insertPost(connection, postDto, boardNum);
        if (result > 0) {
            commit(connection);
        } else rollback(connection);
        return result;
    }




}
