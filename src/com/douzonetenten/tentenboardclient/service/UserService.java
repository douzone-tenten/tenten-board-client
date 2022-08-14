package com.douzonetenten.tentenboardclient.service;



import com.douzonetenten.tentenboardclient.dao.UserDao;
import com.douzonetenten.tentenboardclient.dto.UserDto;

import java.sql.Connection;

import static com.douzonetenten.tentenboardclient.DBConnector.*;

public class UserService {
    private UserDao userDao = new UserDao();

    public int insertUser(UserDto userDto){
        Connection connection = getConnection();
        int result = userDao.insertUser(connection, userDto);
        if (result > 0) {
            commit(connection);
        } else rollback(connection);
        return result;
    }
}
