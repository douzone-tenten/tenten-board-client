package com.douzonetenten.tentenboardclient.service;


import com.douzonetenten.tentenboardclient.dao.PostDao;
import com.douzonetenten.tentenboardclient.dao.Notice_postDao;
import com.douzonetenten.tentenboardclient.dto.Notice_JoinPostDto;
import com.douzonetenten.tentenboardclient.dto.PostDto;

import java.sql.Connection;
import java.util.ArrayList;

import static com.douzonetenten.tentenboardclient.common.DBConnector.*;

public class NoticeService {
    private final PostDao postDao = new PostDao();
    public ArrayList<Notice_JoinPostDto> FindByAll(long postId){
        Connection connection = getConnection();
        ArrayList<Notice_JoinPostDto> noticeList = Notice_postDao.FindByAll(connection, postId);
        return noticeList;
    }

    public int insertPost(PostDto postDto, String boardNumber) {
        Connection connection = getConnection();
        int result = postDao.insertPost(connection, postDto, boardNumber);
        if (result > 0) {
            commit(connection);
        } else rollback(connection);
        return result;
    }

    public static int deletePost(String postId){
        Connection connection = getConnection();
        int result = Notice_postDao.deletePost(connection, postId);
        if(result > 0){
            commit(connection);
        }else {
            rollback(connection);
        }
        return result;
    }


}
