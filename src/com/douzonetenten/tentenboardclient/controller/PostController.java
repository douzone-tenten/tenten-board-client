package com.douzonetenten.tentenboardclient.controller;

import com.douzonetenten.tentenboardclient.dto.PostDto;
import com.douzonetenten.tentenboardclient.service.PostService;

import java.util.ArrayList;

public class PostController {
    private final PostService postService = new PostService();

    public void insertPost(PostDto postDto) {
        postService.insertPost(postDto);
    }

    public void deletePost(String postNo) {
        postService.deletePost(postNo);
    }

    public void findAllByPost() {
        ArrayList<PostDto> postDtoArrayList = postService.findAllByPost();

        if (postDtoArrayList.isEmpty()) {
            System.out.println("조회할 포스트가 없습니다.");
        }

        if (!(postDtoArrayList.isEmpty())) {
            for (PostDto postDto : postDtoArrayList) {
                System.out.println(postDto.toString());
            }
        }
    }
}
