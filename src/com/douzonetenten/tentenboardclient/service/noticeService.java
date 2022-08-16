package com.douzonetenten.tentenboardclient.service;


import com.douzonetenten.tentenboardclient.dao.PostDao;
import com.douzonetenten.tentenboardclient.dao.notice_postDao;
import com.douzonetenten.tentenboardclient.dto.PostDto;

import java.sql.Connection;

import static com.douzonetenten.tentenboardclient.common.DBConnector.*;

public class noticeService {
    private final PostDao postDao = new PostDao();

    public int insertPost(PostDto postDto, String boardNumber) {
        Connection connection = getConnection();
        int result = postDao.insertPost(connection, postDto, boardNumber);
        if (result > 0) {
            commit(connection);
        } else rollback(connection);
        return result;
    }

    public int deletePost(String post_id){
        Connection connection = getConnection();
        int result = notice_postDao.deletePost(connection, post_id);
        if(result > 0){
            commit(connection);
        }else {
            rollback(connection);
        }
        return result;
    }
}
