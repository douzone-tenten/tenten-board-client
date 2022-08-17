package com.douzonetenten.tentenboardclient.controller;

import com.douzonetenten.tentenboardclient.dto.JoinPostDto;
import com.douzonetenten.tentenboardclient.dto.PostDto;
import com.douzonetenten.tentenboardclient.service.QnAService;


import java.util.ArrayList;

public class QnAController {
    private final QnAService qnAService = new QnAService();

    public QnAController() {}

    //QnA 게시글 목록조회
    public ArrayList<JoinPostDto> findAllByQnA(String selectNum) {
        ArrayList<JoinPostDto> joinPostDtoArrayList = this.qnAService.findAllByQnA(selectNum);

        return joinPostDtoArrayList;
    }


    //QnA 게시글 작성
    public void insertQnA(PostDto postDto, Long userId, String selectNum) {
        qnAService.insertQnA(postDto, userId, selectNum);
    }


    //QnA 게시글 상세조회
    public ArrayList<JoinPostDto> detailQnA(String selectDetailNum) {
        ArrayList<JoinPostDto> joinPostDtoListDetail = this.qnAService.detailQnA(selectDetailNum);

        return joinPostDtoListDetail;
    }


    //QnA 게시글 삭제
    public void deleteQnA(String postNo) {
        this.qnAService.deleteQnA(postNo);
    }
}