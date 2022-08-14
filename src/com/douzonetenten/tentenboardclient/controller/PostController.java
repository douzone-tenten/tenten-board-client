package com.douzonetenten.tentenboardclient.controller;

import com.douzonetenten.tentenboardclient.dto.PostDto;
import com.douzonetenten.tentenboardclient.service.PostService;

public class PostController {
    private PostService postService = new PostService();
    public void insertPost(PostDto postDto){
        postService.insertPost(postDto);
    }
}
