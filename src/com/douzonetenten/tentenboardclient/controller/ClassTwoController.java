package com.douzonetenten.tentenboardclient.controller;

import com.douzonetenten.tentenboardclient.dto.ClassTwoJoinDto;
import com.douzonetenten.tentenboardclient.dto.JoinPostDto;
import com.douzonetenten.tentenboardclient.dto.PostDto;
import com.douzonetenten.tentenboardclient.service.ClassTwoService;

import java.util.ArrayList;

public class ClassTwoController {
    private final ClassTwoService classTwoService = new ClassTwoService();



    public ArrayList<ClassTwoJoinDto> douzoneFindByAll(String boardNum) {
        ArrayList<ClassTwoJoinDto> douzone_List = classTwoService.douzoneFindByAll(boardNum);
        return douzone_List;
    }

    public ArrayList<JoinPostDto> douzoneTwoDetailSelect(int post_id){
        ArrayList<JoinPostDto> dozone_List = classTwoService.douzoneTwoDetailSelect(post_id);
        System.out.println(dozone_List);
        return dozone_List;
    }



    public void dozoneTwoInsert(PostDto postDto, String BoardNum){
        classTwoService.douZoneTwoInsert(postDto,BoardNum);

    }


    }


