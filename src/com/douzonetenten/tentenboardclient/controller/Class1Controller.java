package com.douzonetenten.tentenboardclient.controller;

import com.douzonetenten.tentenboardclient.dto.JoinPostDto;
import com.douzonetenten.tentenboardclient.dto.PostDto;
import com.douzonetenten.tentenboardclient.service.Class1Service;

import java.util.ArrayList;

public class Class1Controller {

    private static final Class1Service class1Service = new Class1Service();

    public void insertPost(PostDto postDto, String boardNumber)
    {
        class1Service.insertPost(postDto,boardNumber);
    }

    public static ArrayList<JoinPostDto> findByClass1(String selectNum) {
        ArrayList<JoinPostDto> joinPostDtoArrayList = Class1Service.findByPost(selectNum);
        return joinPostDtoArrayList;
    }

    public static void deletePost(String selectPost) {
        class1Service.deletePost(selectPost);
    }

    public static void editPost(String selectPost) {
       // class1Service.editPost(selectPost);
    }

    public static ArrayList<JoinPostDto> detailPost(String selectPost) {
        ArrayList<JoinPostDto> joinPostDtoArrayList = Class1Service.detailPost(selectPost);
        return joinPostDtoArrayList;
    }
}