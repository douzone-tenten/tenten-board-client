package com.douzonetenten.tentenboardclient.view;

import com.douzonetenten.tentenboardclient.controller.PostController;
import com.douzonetenten.tentenboardclient.dto.PostDto;

import java.util.Scanner;

public class notice_postView {

    public static void insertPost(){
        PostController postController = new PostController();
        PostDto postDto = new PostDto();
        Scanner sc = new Scanner(System.in);
        System.out.println("공지사항을 작성합니다.");
        System.out.println("공지사항의 제목을 입력하세요 : ");
        String postTitle = sc.nextLine();
        System.out.println("공지사항의 내용을 입력하세요 : ");
        String postBody = sc.nextLine();
        postDto.setPostTitle(postTitle);
        postDto.setPostBody(postBody);
        System.out.println(postDto.getPostTitle());
        System.out.println(postDto.getPostBody());
        System.out.println("위 내용이 맞나요?");
        System.out.println("Y : 등록하기");
        System.out.println("N : 취소하기");
        char answer = sc.next().charAt(0);

        if(answer == 'Y' || answer == 'y'){
            PostController.insertPost(postDto, "3");
        }else if(answer == 'N' || answer == 'n'){
            System.out.println("글 작성을 취소합니다.");
        }else{
            System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
        }


    }

    public static void deletePost(){
        Scanner sc = new Scanner(System.in);
        System.out.println("삭제할 포스트 번호를 입력하세요 : ");
        String pno = sc.next();
        PostController.deletePost(pno);



    }
}
