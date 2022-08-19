package com.douzonetenten.tentenboardclient.controller;

import com.douzonetenten.tentenboardclient.dto.Notice_JoinPostDto;
import com.douzonetenten.tentenboardclient.service.NoticeService;

import java.util.ArrayList;

public class NoticeController {

    /**
     * noticeService 객체 생성
     * @author 김승혁
     * */
    private static final NoticeService noticeService = new NoticeService();


    /**
     * @param  ArrayList<Notice_JoinPostDto> FindByAll(long post_id)
     *         -long 타입의 post_id를 매개변수로 가지고 있는 FindByAll 메서드를 Notice_postDao에서 가져와 ArrayList에 집어넣는 기능
     * @author 김승혁
     * */
    public static ArrayList<Notice_JoinPostDto> FindByAll(long post_id){
        ArrayList<Notice_JoinPostDto> notice_list = noticeService.FindByAll(post_id);
        return notice_list;
    }

    /**
     * @param  insertPost(Notice_JoinPostDto noticeJoinPostDto, String boardNumber)
     *        -noticeJoinPostDto와 boardNumber를 매개변수로 가지고 있는 insertPost를 Notice_postDao에서 가져오는 메서드
     * @author 김승혁
     * */
    public void insertPost(Notice_JoinPostDto noticeJoinPostDto, String boardNumber) {

        noticeService.insertPost(noticeJoinPostDto, boardNumber);
    }


    /**
     * @param  SubDelete(int postId)
     *        -postId를 매개변수로 가지고 있는 SubDelete를 Notice_postDao에서 가져오는 메서드
     * @author 김승혁
     * */
    public int SubDelete(int postId) {
        return noticeService.SubDelete(postId);
    }


    /**
     * @param  update(int postId,String test, String body)
     *        -postId와 test와  body를 매개변수로 가지고 있는 update를 Notice_postDao에서 가져오는 메서드
     * @author 김승혁
     * */
    public int update(int postId,String test, String body) {

        int result = noticeService.update(postId,test, body);
        System.out.println(result);
        return result;
    }
}


