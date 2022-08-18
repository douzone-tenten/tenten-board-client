package com.douzonetenten.tentenboardclient.controller;

import com.douzonetenten.tentenboardclient.dto.JoinPostDto;
import com.douzonetenten.tentenboardclient.dto.PostDto;
import com.douzonetenten.tentenboardclient.service.QnAService;


import java.util.ArrayList;

public class QnAController {
    private final QnAService qnAService = new QnAService();

    /**
     * QnAController 생성자
     *
     * @author 강도영
     */
    public QnAController() {}


    /**
     * QnA 게시판에 조회할 게시글을 모두 List에 추가하여 리턴하는 메소드
     *
     * @param selectNum - 조회할 게시판의 카테고리 넘버입니다.
     * @author 강도영
     */
    //QnA 게시글 목록조회
    public ArrayList<JoinPostDto> findAllByQnA(String selectNum) {
        ArrayList<JoinPostDto> joinPostDtoArrayList = this.qnAService.findAllByQnA(selectNum);

        return joinPostDtoArrayList;
    }


    /**
     * QnA 게시판에 게시글을 작성하는 메소드
     *
     * @param selectNum - 조회할 게시판의 카테고리 넘버입니다.
     * @param postDto - 입력한 값을 저장하기 위한 변수입니다.
     * @param userId - 로그인한 사용자의 아이디를 출력하기 위해 사용하는 변수입니다.
     * @author 강도영
     */
    //QnA 게시글 작성
    public void insertQnA(PostDto postDto, Long userId, String selectNum) {
        qnAService.insertQnA(postDto, userId, selectNum);
    }


    /**
     * QnA 게시판에 게시글을 상세조회 하는 메소드
     *
     * @param selectDetailNum - 상세조회할 게시글의 넘버입니다.
     * @author 강도영
     */
    //QnA 게시글 상세조회
    public ArrayList<JoinPostDto> detailQnA(String selectDetailNum) {
        ArrayList<JoinPostDto> joinPostDtoListDetail = this.qnAService.detailQnA(selectDetailNum);

        return joinPostDtoListDetail;
    }


    /**
     * QnA 게시판에 게시글을 삭제하는 메소드
     *
     * @param postNo - 삭제할 게시글의 번호 넘버입니다.
     * @author 강도영
     */
    //QnA 게시글 삭제
    public void deleteQnA(String postNo) {
        this.qnAService.deleteQnA(postNo);
    }


    /**
     * QnA 게시판에 게시글을 수정하는 메소드
     *
     * @param postDto - 입력한 값을 저장하기 위한 변수입니다.
     * @param selectDetailNum - 상세조회할 게시글의 넘버입니다.
     * @author 강도영
     */
    //QnA 게시글 수정
    public void updateQnA(PostDto postDto, String selectDetailNum) {
        this.qnAService.updateQnA(postDto, selectDetailNum);
    }
}