package com.douzonetenten.tentenboardclient.controller;

import com.douzonetenten.tentenboardclient.dto.PostDto;
import com.douzonetenten.tentenboardclient.service.PostService;

public class notice_boardController {

    private static final PostService postService = new PostService();

    public void insertPost(PostDto postDto, String boardNumber){

        postService.insertPost(postDto, boardNumber);
    }

    public static void deletePost(String post_id){

        postService.deletePost(post_id);
    }
}

