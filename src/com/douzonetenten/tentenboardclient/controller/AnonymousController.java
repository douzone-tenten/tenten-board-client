package com.douzonetenten.tentenboardclient.controller;

import com.douzonetenten.tentenboardclient.dto.JoinPostDto;
import com.douzonetenten.tentenboardclient.service.AnonymousService;

import java.sql.SQLException;
import java.util.ArrayList;

public class AnonymousController {

    private static final AnonymousService anonymousService= new AnonymousService();

    public ArrayList<JoinPostDto> findDetailByPost(String boardNum, String postId, String userNo ){

        ArrayList<JoinPostDto> joinPostDtoArrayList=anonymousService.findDetailByPost(boardNum, postId, userNo);
        return joinPostDtoArrayList;
    }







}
