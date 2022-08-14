package com.douzonetenten.tentenboardclient.service;

import com.douzonetenten.tentenboardclient.dao.PostDao;
import com.douzonetenten.tentenboardclient.dto.PostDto;

import java.sql.Connection;

/**
 * wildcard import
 */
import static com.douzonetenten.tentenboardclient.DBConnector.*;

public class PostService {
    private final PostDao postDao = new PostDao();

    public int insertPost(PostDto postDto) {
        Connection connection = getConnection();
        int result = postDao.insertPost(connection,postDto);
        if (result > 0) {
            commit(connection);
        } else rollback(connection);
        return result;
    }
}
