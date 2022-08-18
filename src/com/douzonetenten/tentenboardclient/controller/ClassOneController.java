package com.douzonetenten.tentenboardclient.controller;

import com.douzonetenten.tentenboardclient.dto.JoinPostDto;
import com.douzonetenten.tentenboardclient.dto.PostDto;
import com.douzonetenten.tentenboardclient.service.ClassOneService;

import java.util.ArrayList;

public class ClassOneController {

    private static final ClassOneService classOneService = new ClassOneService();

    public static ArrayList<JoinPostDto> findByClassOne(String selectNum) {
        ArrayList<JoinPostDto> joinPostDtoArrayList = ClassOneService.findByPost(selectNum);
        return joinPostDtoArrayList;
    }
    public void insertPost(PostDto postDto, String boardNumber)
    {
        classOneService.insertPost(postDto,boardNumber);
    }

    public static void deletePost(String selectPost) {
        classOneService.deletePost(selectPost);
    }

    public static void editPost(PostDto postDto, String boardNumber) {
        classOneService.editPost(postDto,boardNumber);
    }

    public static ArrayList<JoinPostDto> detailPost(String selectPost) {
        ArrayList<JoinPostDto> joinPostDtoArrayList = ClassOneService.detailPost(selectPost);
        return joinPostDtoArrayList;
    }
}