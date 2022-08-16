package com.douzonetenten.tentenboardclient.controller;

import com.douzonetenten.tentenboardclient.dto.PostDto;
import com.douzonetenten.tentenboardclient.dto.UserDto;
import com.douzonetenten.tentenboardclient.service.QnAService;


import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;

public class QnAController {
    private final QnAService qnAService = new QnAService();

    public QnAController() {}

    //QnA 목록조회
    public void findAllByQnA() {
        ArrayList<PostDto> postDtoArrayList = this.qnAService.findAllByQnA();

        if (postDtoArrayList.isEmpty()) {
            System.out.println("조회할 QnA가 없습니다.");
        }
        if (!postDtoArrayList.isEmpty()) {
            Iterator var1 = postDtoArrayList.iterator();

            while (var1.hasNext()) {
                PostDto postDto = (PostDto) var1.next();
                System.out.println(postDto.toString());
            }
        }
    }


    //QnA 게시글 작성
    public void insertQnA(PostDto postDto) {
        qnAService.insertPost(postDto);
    }
}