package com.douzonetenten.tentenboardclient.service;



import com.douzonetenten.tentenboardclient.dao.UserDao;
import com.douzonetenten.tentenboardclient.dto.UserDto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.douzonetenten.tentenboardclient.common.DBConnector.*;


/**
 * 유저 관련 서비스입니다.
 * @author : 김민준
 */
public class UserService {
    /**
     * 로그인 성공시 전역적으로 사용할 유저 정보 컨텍스트입니다.
     * @author : 김민준
     */
    public static List<UserDto> loginUserContext = new ArrayList<>();

    private UserDao userDao = new UserDao();

    /**
     * UserDto 객체로 부터 전달받은 데이터로 회원가입합니다.
     * @author : 김민준
     * @return : 쿼리 성공여부
     */
    public int insertUser(UserDto userDto) throws SQLException {
        Connection connection = getConnection();
        int result = userDao.insertUser(connection, userDto);
        if (result > 0) {
            commit(connection);
        } else rollback(connection);
        return result;
    }
    /**
     * UserDto 객체로 부터 전달받은 데이터로 로그인합니다.
     * @author : 김민준
     * @return : 로그인에 성공한 UserDto
     */
    public UserDto login(UserDto userDto) throws Exception {
        Connection connection = getConnection();
        loginUserContext.add(userDao.login(connection,userDto));
        return userDao.login(connection,userDto);
    }
    /**
     * 컨텍스트에 있는 유저 정보를 삭제 하여 로그아웃합니다.
     * @author : 김민준
     */
    public void logout(){
        loginUserContext.remove(0);
    }
}
