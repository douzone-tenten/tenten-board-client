package com.douzonetenten.tentenboardclient.controller;

import com.douzonetenten.tentenboardclient.dto.PostDto;
import com.douzonetenten.tentenboardclient.dto.UserDto;
import com.douzonetenten.tentenboardclient.service.QnAService;


import java.util.ArrayList;

public class QnAController {
    private final QnAService qnAService = new QnAService();

    public QnAController() {}

    //QnA 목록조회
    public ArrayList<PostDto> findAllByQnA(String selectNum) {
        ArrayList<PostDto> postDtoArrayList = this.qnAService.findAllByQnA();

        return postDtoArrayList;
    }


    //QnA 게시글 작성
    public void insertQnA(PostDto postDto, Long userId, String selectNum) {
        qnAService.insertQnA(postDto, userId, selectNum);
    }


    //QnA 게시글 삭제
    public void deleteQnA(String postNo) {
        this.qnAService.deleteQnA(postNo);
    }
}