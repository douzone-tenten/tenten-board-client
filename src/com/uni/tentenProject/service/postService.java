package com.uni.tentenProject.service;

import com.uni.tentenProject.model.dao.notice_postDao;
import com.uni.tentenProject.model.dto.notice_post_dto;

import java.sql.Connection;

import static com.uni.tentenProject.DBConnector.rollback;
import static com.uni.tentenProject.DBConnector.commit;
import static com.uni.tentenProject.DBConnector.getConnection;

public class postService {

    private final notice_post_dto notice_post_dto = new notice_post_dto();
    
    public int insertPost(notice_post_dto notice_post_dto){
        Connection conn = getConnection();
        int result = notice_postDao.insertPost(conn, notice_post_dto);
        if(result > 0){
            commit(conn);
        }else rollback(conn);
        return result;
    }

    
}
