package com.douzonetenten.tentenboardclient.controller;

import com.douzonetenten.tentenboardclient.dto.PostDto;
import com.douzonetenten.tentenboardclient.service.DouZoneTwoService;

import java.util.ArrayList;

public class DouZoneTwoController {
    private final DouZoneTwoService douZoneTwoService = new DouZoneTwoService();
    public ArrayList<PostDto> douzoneFindByAll() {
        ArrayList<PostDto> douzone_List = douZoneTwoService.douzoneFindByAll();
        return douzone_List;
    }


    }


