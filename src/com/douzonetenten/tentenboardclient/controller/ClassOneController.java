package com.douzonetenten.tentenboardclient.controller;

import com.douzonetenten.tentenboardclient.dto.JoinPostDto;
import com.douzonetenten.tentenboardclient.dto.PostDto;
import com.douzonetenten.tentenboardclient.service.ClassOneService;

import java.util.ArrayList;

public class ClassOneController {

    private static final ClassOneService class1Service = new ClassOneService();

    public void insertPost(PostDto postDto, String boardNumber)
    {
        class1Service.insertPost(postDto,boardNumber);
    }

    public static ArrayList<JoinPostDto> findByClass1(String selectNum) {
        ArrayList<JoinPostDto> joinPostDtoArrayList = ClassOneService.findByPost(selectNum);
        return joinPostDtoArrayList;
    }

    public static void deletePost(String selectPost) {
        class1Service.deletePost(selectPost);
    }

    public static void editPost(String selectPost) {
       // class1Service.editPost(selectPost);
    }

    public static ArrayList<JoinPostDto> detailPost(String selectPost) {
        ArrayList<JoinPostDto> joinPostDtoArrayList = ClassOneService.detailPost(selectPost);
        return joinPostDtoArrayList;
    }
}