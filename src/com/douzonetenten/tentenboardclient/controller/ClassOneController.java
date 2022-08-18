package com.douzonetenten.tentenboardclient.controller;

import com.douzonetenten.tentenboardclient.dto.JoinPostDto;
import com.douzonetenten.tentenboardclient.dto.PostDto;
import com.douzonetenten.tentenboardclient.service.ClassOneService;

import java.util.ArrayList;

public class ClassOneController {
    /**
     * ClassOneController 입니다.
     *
     * @author : 정수연
     */
    private static final ClassOneService classOneService = new ClassOneService();
    /**
     * 게시판 조회할 게시글 리턴 메소드입니다.
     *
     * @selectNum : 카테고리 번호입니다.
     * @return : 조회할 게시글 정보들을 반환합니다.
     * @author : 정수연
     */
    public static ArrayList<JoinPostDto> findByClassOne(String selectNum) {
        ArrayList<JoinPostDto> joinPostDtoArrayList = ClassOneService.findByPost(selectNum);
        return joinPostDtoArrayList;
    }

    /**
     * 게시판에 글을 작성하는 메소드입니다.
     *
     * @param postDto : 입력한 값을 저장하기 위한 변수입니다.
     * @param boardNumber : 카테고리 번호입니다.
     * @author : 정수연
     */
    public void insertPost(PostDto postDto, String boardNumber)
    {
        classOneService.insertPost(postDto,boardNumber);
    }

    /**
     * 게시판에 글을 삭제하는 메소드입니다.
     *
     * @param selectPost : 게시글 번호입니다.
     * @author : 정수연
     */
    public static void deletePost(String selectPost) {
        classOneService.deletePost(selectPost);
    }

    /**
     * 게시판에 글을 수정하는 메소드입니다.
     *
     * @param postDto : 입력한 값을 저장하기 위한 변수입니다.
     * @param boardNumber : 카테고리 번호입니다.
     * @author : 정수연
     */
    public static void editPost(PostDto postDto, String boardNumber) {
        classOneService.editPost(postDto,boardNumber);
    }

    /**
     * 게시판에 글을 삭제하는 메소드입니다.
     *
     * @param selectPost : 게시글 번호입니다.
     * @return : 조회할 게시글 정보들을 반환합니다.
     * @author : 정수연
     */
    public static ArrayList<JoinPostDto> detailPost(String selectPost) {
        ArrayList<JoinPostDto> joinPostDtoArrayList = ClassOneService.detailPost(selectPost);
        return joinPostDtoArrayList;
    }
}