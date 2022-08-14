package com.douzonetenten.tentenboardclient.controller;

import com.douzonetenten.tentenboardclient.dto.UserDto;
import com.douzonetenten.tentenboardclient.service.UserService;

public class UserController {
    private UserService userService = new UserService();
//
//    public void findAll(){
//        userService.findAll();
//    }
    public void insertUser(UserDto userDto){
        userService.insertUser(userDto);
    }
}
