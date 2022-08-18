package com.douzonetenten.tentenboardclient.service;


import com.douzonetenten.tentenboardclient.dao.Notice_postDao;
import com.douzonetenten.tentenboardclient.dto.Notice_JoinPostDto;

import java.sql.Connection;
import java.util.ArrayList;

import static com.douzonetenten.tentenboardclient.common.DBConnector.*;

public class NoticeService {
    private final Notice_postDao notice_postDao = new Notice_postDao();


    //상세 조회
    public ArrayList<Notice_JoinPostDto> FindByAll(long postId){
        Connection connection = getConnection();
        ArrayList<Notice_JoinPostDto> noticeList = Notice_postDao.FindByAll(connection, postId);
        return noticeList;
    }
    //글쓰기
    public int insertPost(Notice_JoinPostDto noticeJoinPostDto, String boardNumber) {
        Connection connection = getConnection();
        Notice_postDao notice_postDao = new Notice_postDao();
        int result = Notice_postDao.insertPost(connection, noticeJoinPostDto, boardNumber);
        if (result > 0) {
            commit(connection);
        } else rollback(connection);
        return result;
    }

    public  int SubDelete(int postId) {
        Connection connection = getConnection();
        return notice_postDao.SubDelete(connection, postId);
    }

    public int update(int  postId,String test, String body) {
        Connection connection = getConnection();
        Notice_JoinPostDto noticeJoinPostDto = new Notice_JoinPostDto();
        int result = notice_postDao.update(connection, postId,test,body ); //noticeJoinPostDto
        System.out.println(result);

        if (result > 0) {
            commit(connection);
        } else rollback(connection);
        return result;
    }


}
