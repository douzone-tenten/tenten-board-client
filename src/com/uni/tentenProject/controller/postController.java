package com.uni.tentenProject.controller;

import com.uni.tentenProject.model.dto.notice_post_dto;
import com.uni.tentenProject.service.postService;

public class postController {

    private static final postService postService = new postService();

    public void insertPost(notice_post_dto notice_post_dto, String boardNumber){

        postService.insertPost(notice_post_dto, boardNumber);
    }

    public static void deletePost(String post_id){

        postService.deletePost(post_id);
    }
}
