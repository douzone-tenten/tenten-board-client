package com.douzonetenten.tentenboardclient.controller;

import com.douzonetenten.tentenboardclient.dto.JoinPostDto;
import com.douzonetenten.tentenboardclient.dto.PostDto;
import com.douzonetenten.tentenboardclient.service.PostService;

import java.util.ArrayList;

public class notice_boardController {

    private static final PostService postService = new PostService();

    public void insertPost(PostDto postDto, String boardNumber){

        postService.insertPost(postDto, boardNumber);
    }

    public static void deletePost(String post_id){

        postService.deletePost(post_id);
    }

    public ArrayList<PostDto> findAllByPost() {
        ArrayList<PostDto> postDtoArrayList = postService.findAllByPost();
        return postDtoArrayList;
    }

    public ArrayList<JoinPostDto> findByPost(String boardNum){
        ArrayList<JoinPostDto> joinPostDtoArrayList = postService.findByPost(boardNum);
        return joinPostDtoArrayList;
    }
}

