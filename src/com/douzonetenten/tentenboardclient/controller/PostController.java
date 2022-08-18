package com.douzonetenten.tentenboardclient.controller;

import com.douzonetenten.tentenboardclient.dto.JoinPostDto;
import com.douzonetenten.tentenboardclient.dto.PostDto;
import com.douzonetenten.tentenboardclient.service.PostService;

import java.util.ArrayList;

public class PostController {
    private static final PostService postService = new PostService();

    public static void insertPost(PostDto postDto, String boardNumber){

        postService.insertPost(postDto, boardNumber);
    }

    public static void deletePost(String post_id){

        PostService.deletePost(post_id);
    }


    public ArrayList<PostDto> findAllByPost() {
        ArrayList<PostDto> postDtoArrayList = postService.findAllByPost();
        return postDtoArrayList;
    }

    public static ArrayList<JoinPostDto> findByPost(String boardNum){
        ArrayList<JoinPostDto> joinPostDtoArrayList = postService.findByPost(boardNum);
        return joinPostDtoArrayList;
    }

    // 익명게시판에 사용
    // 상세조회 시 로그인한 유저가 쓴 글만 출력해주기
    public static ArrayList<JoinPostDto> findSameUserByPost(String user_no, String board_no){
        ArrayList<JoinPostDto> joinPostDtoArrayList= postService.findSameUserByPost(user_no, board_no);
        return  joinPostDtoArrayList;
    }

    // 익명게시판에서의 게시글번호를 통해 게시글의 user_id 추출
    public static ArrayList<PostDto> findIdByPost(String boardNum, String postId){

        ArrayList<PostDto> PostDtoArrayList=postService.findIdByPost(boardNum, postId);
        return  PostDtoArrayList;
    }




}
