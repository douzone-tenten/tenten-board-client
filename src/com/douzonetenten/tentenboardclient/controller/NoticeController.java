package com.douzonetenten.tentenboardclient.controller;

import com.douzonetenten.tentenboardclient.dto.Notice_JoinPostDto;
import com.douzonetenten.tentenboardclient.dto.PostDto;
import com.douzonetenten.tentenboardclient.service.NoticeService;

import java.util.ArrayList;

public class NoticeController {

    private static final NoticeService noticeService = new NoticeService();

    public static ArrayList<Notice_JoinPostDto> FindByAll(long post_id){
        ArrayList<Notice_JoinPostDto> notice_list = noticeService.FindByAll(post_id);
        return notice_list;
    }
    public void insertPost(PostDto postDto, String boardNumber) {

        noticeService.insertPost(postDto, boardNumber);
    }

    public static void deletePost(String post_id) {

        NoticeService.deletePost(post_id);
    }
}

