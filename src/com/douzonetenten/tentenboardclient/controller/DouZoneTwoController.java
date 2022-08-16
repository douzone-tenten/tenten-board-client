package com.douzonetenten.tentenboardclient.controller;

import com.douzonetenten.tentenboardclient.dao.DouZoneTwoDao;
import com.douzonetenten.tentenboardclient.dto.DouZoneTwoJoinDto;
import com.douzonetenten.tentenboardclient.dto.PostDto;
import com.douzonetenten.tentenboardclient.service.DouZoneTwoService;

import java.util.ArrayList;

public class DouZoneTwoController {
    private final DouZoneTwoService douZoneTwoService = new DouZoneTwoService();



    public ArrayList<DouZoneTwoJoinDto> douzoneFindByAll() {
        ArrayList<DouZoneTwoJoinDto> douzone_List = douZoneTwoService.douzoneFindByAll();
        return douzone_List;
    }

    public void dozoneTwoInsert(PostDto postDto, String BoardNum){
        douZoneTwoService.douZoneTwoInsert(postDto,BoardNum);

    }


    }


