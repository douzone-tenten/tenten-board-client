package com.uni.tentenProject.view;


import com.uni.tentenProject.controller.postController;
import com.uni.tentenProject.model.dto.notice_post_dto;

import java.util.Scanner;



public class notice_postView {


    public static void insertPost(){
        postController postController = new postController();
        notice_post_dto notice_post_dto = new notice_post_dto();
        Scanner sc = new Scanner(System.in);
        System.out.println("공지사항을 작성합니다.");
        System.out.println("공지사항의 제목을 입력하세요 : ");
        String postTitle = sc.nextLine();
        System.out.println("공지사항의 내용을 입력하세요 : ");
        String postBody = sc.nextLine();
        notice_post_dto.setPostTitle(postTitle);
        notice_post_dto.setPostBody(postBody);
        System.out.println(notice_post_dto.getPostTitle());
        System.out.println(notice_post_dto.getPostBody());
        System.out.println("위 내용이 맞나요?");
        System.out.println("Y : 등록하기");
        System.out.println("N : 취소하기");
        char answer = sc.next().charAt(0);

        if(answer == 'Y'){
            postController.insertPost(notice_post_dto);
        }else if(answer == 'N'){
            System.out.println("글 작성을 취소합니다.");
        }else{
            System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
        }


    }

}
