package com.uni.tentenProject.controller;

import com.uni.tentenProject.model.dto.notice_post_dto;
import com.uni.tentenProject.service.postService;

public class postController {

    private final postService postService = new postService();

    public void insertPost(notice_post_dto notice_post_dto){
        postService.insertPost(notice_post_dto);
    }

}
