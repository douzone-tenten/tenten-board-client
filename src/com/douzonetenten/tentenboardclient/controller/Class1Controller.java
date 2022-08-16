package com.douzonetenten.tentenboardclient.controller;

import com.douzonetenten.tentenboardclient.dto.BoardDto;
import com.douzonetenten.tentenboardclient.dto.JoinPostDto;
import com.douzonetenten.tentenboardclient.service.Class1Service;

import java.util.ArrayList;

public class Class1Controller {

    private final Class1Service class1Service = new Class1Service();
    public static ArrayList<JoinPostDto> findByClass1(String selectNum) {
        ArrayList<JoinPostDto> joinPostDtoArrayList = Class1Service.findByPost(selectNum);
        return joinPostDtoArrayList;
    }
}