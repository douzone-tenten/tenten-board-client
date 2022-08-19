package com.douzonetenten.tentenboardclient.controller;

import com.douzonetenten.tentenboardclient.dto.JoinPostDto;
import com.douzonetenten.tentenboardclient.service.FreeService;
import com.douzonetenten.tentenboardclient.service.PostService;

import java.util.ArrayList;

public class FreeController {

    private FreeService freeService = new FreeService();
    private PostService postService = new PostService();


    public int deleteIdByPost(String boardNo, String userNo, String postNo){
        return postService.deleteIdByPost(boardNo,userNo,postNo);
    }


    public int updateIdByPost(String boardNo, String userNo, String postNo, String postTitle, String postBody){
        return postService.updateIdByPost( boardNo,  userNo,  postNo,  postTitle,  postBody);

    }

    public ArrayList<JoinPostDto> FindDetailByPost(String boardNum, String postId, String userNo){

        ArrayList<JoinPostDto> joinPostDtoArrayList=freeService.FindDetailByPost(boardNum, postId, userNo);
        return joinPostDtoArrayList;
    }






}
