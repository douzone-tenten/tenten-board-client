package com.douzonetenten.tentenboardclient.controller;

import com.douzonetenten.tentenboardclient.dto.UserDto;
import com.douzonetenten.tentenboardclient.service.UserService;

/**
 * UserDto를 전달하기 위한 UserController 입니다.
 * @author : 김민준
 */
public class UserController {
    private UserService userService = new UserService();

    public int insertUser(UserDto userDto){
        return userService.insertUser(userDto);
    }

    public void login(UserDto userDto) throws Exception {
        userService.login(userDto);
    }

    public void logout() { userService.logout();}
}
