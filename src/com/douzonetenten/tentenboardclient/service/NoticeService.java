package com.douzonetenten.tentenboardclient.service;


import com.douzonetenten.tentenboardclient.dao.PostDao;
import com.douzonetenten.tentenboardclient.dao.Notice_postDao;
import com.douzonetenten.tentenboardclient.dto.Notice_JoinPostDto;
import com.douzonetenten.tentenboardclient.dao.NoticePostDao;
import com.douzonetenten.tentenboardclient.dto.JoinPostDto;
import com.douzonetenten.tentenboardclient.dto.PostDto;

import java.sql.Connection;
import java.util.ArrayList;

import static com.douzonetenten.tentenboardclient.common.DBConnector.*;

public class NoticeService {
    private final PostDao postDao = new PostDao();
    //private final Notice_JoinPostDto noticeJoinPostDto = new Notice_JoinPostDto();

    public ArrayList<Notice_JoinPostDto> FindByAll(long post_id){
        Connection connection = getConnection();
        ArrayList<Notice_JoinPostDto> notice_list = Notice_postDao.FindByAll(connection, post_id);
        return notice_list;
    }

    public int insertPost(PostDto postDto, String boardNumber) {
        Connection connection = getConnection();
        int result = postDao.insertPost(connection, postDto, boardNumber);
        if (result > 0) {
            commit(connection);
        } else rollback(connection);
        return result;
    }

    public static int deletePost(String post_id){
        Connection connection = getConnection();
        int result = Notice_postDao.deletePost(connection, post_id);
        if(result > 0){
            commit(connection);
        }else {
            rollback(connection);
        }
        return result;
    }


}
