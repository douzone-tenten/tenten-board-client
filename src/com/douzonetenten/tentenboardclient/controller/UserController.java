package com.douzonetenten.tentenboardclient.controller;

import com.douzonetenten.tentenboardclient.dto.UserDto;
import com.douzonetenten.tentenboardclient.service.UserService;

public class UserController {
    private UserService userService = new UserService();

    public int insertUser(UserDto userDto){
        return userService.insertUser(userDto);
    }

    public void login(UserDto userDto){
        userService.login(userDto);
    }

    public void logout() { userService.logout();}
}
