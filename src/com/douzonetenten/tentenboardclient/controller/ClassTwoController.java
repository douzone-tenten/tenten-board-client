package com.douzonetenten.tentenboardclient.controller;

import com.douzonetenten.tentenboardclient.dto.ClassTwoJoinDto;
import com.douzonetenten.tentenboardclient.dto.PostDto;
import com.douzonetenten.tentenboardclient.service.ClassTwoService;

import java.util.ArrayList;

public class ClassTwoController {
    private final ClassTwoService douZoneTwoService = new ClassTwoService();



    public ArrayList<ClassTwoJoinDto> douzoneFindByAll(String boardNum) {
        ArrayList<ClassTwoJoinDto> douzone_List = douZoneTwoService.douzoneFindByAll(boardNum);
        return douzone_List;
    }

//    public ArrayList<DouZoneTwoJoinDto> douzoneTwoDetailSelect(String boardNum){
//        ArrayList<DouZoneTwoJoinDto> dozone_List = douZoneTwoService.douzoneTwoDetailSelect(boardNum);
//        return dozone_List;
//    }



    public void dozoneTwoInsert(PostDto postDto, String BoardNum){
        douZoneTwoService.douZoneTwoInsert(postDto,BoardNum);

    }


    }


