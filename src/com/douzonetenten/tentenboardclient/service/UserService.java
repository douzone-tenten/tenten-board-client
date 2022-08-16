package com.douzonetenten.tentenboardclient.service;



import com.douzonetenten.tentenboardclient.dao.UserDao;
import com.douzonetenten.tentenboardclient.dto.UserDto;
import com.douzonetenten.tentenboardclient.exception.user.UnAuthorizationException;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import static com.douzonetenten.tentenboardclient.common.DBConnector.*;

public class UserService {
    /**
     * 저희가 이제 로그인 한 객체를 사용해야 할 때.
     * 예를 들어서, 어떤 자유게시판 접속하면,
     * 글을 써야 하는데,
     * user_member_no에 어떻게 값을 넣을수가 있죠?
     */
    public static List<UserDto> loginUserContext = new ArrayList<>();

    private UserDao userDao = new UserDao();

    public int insertUser(UserDto userDto){
        Connection connection = getConnection();
        // TODO : unique_id 제약조건 예외처리
        int result = userDao.insertUser(connection, userDto);
        if (result > 0) {
            commit(connection);
        } else rollback(connection);
        return result;
    }

    public UserDto login(UserDto userDto) throws UnAuthorizationException {
        Connection connection = getConnection();
        loginUserContext.add(userDao.login(connection,userDto));
        return userDao.login(connection,userDto);
    }

    public void logout(){
        loginUserContext.remove(0);
    }
}
