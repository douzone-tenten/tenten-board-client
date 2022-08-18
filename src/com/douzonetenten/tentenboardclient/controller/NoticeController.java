package com.douzonetenten.tentenboardclient.controller;

import com.douzonetenten.tentenboardclient.dto.Notice_JoinPostDto;
import com.douzonetenten.tentenboardclient.service.NoticeService;

import java.util.ArrayList;

public class NoticeController {

    private static final NoticeService noticeService = new NoticeService();

    public static ArrayList<Notice_JoinPostDto> FindByAll(long post_id){
        ArrayList<Notice_JoinPostDto> notice_list = noticeService.FindByAll(post_id);
        return notice_list;
    }
    public void insertPost(Notice_JoinPostDto noticeJoinPostDto, String boardNumber) {

        noticeService.insertPost(noticeJoinPostDto, boardNumber);
    }

    public int SubDelete(int postId) {
        return noticeService.SubDelete(postId);
    }

    public int update(int postId,String test, String body) {

        int result = noticeService.update(postId,test, body);
        System.out.println(result);
        return result;
    }
}


