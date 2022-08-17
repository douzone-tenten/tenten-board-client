package com.douzonetenten.tentenboardclient.view;

import com.douzonetenten.tentenboardclient.controller.PostController;
import com.douzonetenten.tentenboardclient.dto.JoinPostDto;
import com.douzonetenten.tentenboardclient.dto.PostDto;

import java.util.ArrayList;
import java.util.Scanner;

public class notice_mainView {
    private notice_postView notice_postwiew = new notice_postView();
    private Scanner sc = new Scanner(System.in);

    public void start(String selectNum) {
        Scanner sc = new Scanner(System.in);
        ArrayList<JoinPostDto> getPostList = PostController.findByPost(selectNum);

        System.out.println("공지사항 게시판");
        System.out.printf("--------------------------------\n" +
                "게시글 번호      제목        작성자      작성시간\n" +
                "--------------------------------\n");

        // 게시글 목록 조회
        if (getPostList.isEmpty()) {
            System.out.println("조회할 포스트가 없습니다.");
        }

        if (!(getPostList.isEmpty())) {
            for (JoinPostDto joinPostDto : getPostList) {
                System.out.println(joinPostDto.findPostToString());
            }
        }
        System.out.println("b.뒤로가기  n.다음 페이지  f.이전 페이지  w.글쓰기  d.공지사항 삭제");
        char a = sc.next().charAt(0);
        if (a == 'w' || a == 'W') {
            insertAll();
        }else if(a == 'd' || a == 'D' ){
            delete();
        }
    }
//    public void select() {
//        System.out.print("조회할 게시글 번호를 입력하세요 : ");
//        String selectPost = sc.next();
//    }
    public void insertAll() {

        PostDto postDto = new PostDto();
            System.out.println("공지사항의 제목을 입력하세요 : ");
            String postTitle = sc.next();
            System.out.println("공지사항의 내용을 입력하세요 : ");
            String postBody = sc.next();
            postDto.setPostTitle(postTitle);
            postDto.setPostBody(postBody);
            System.out.println(postDto.getPostTitle());
            System.out.println(postDto.getPostBody());
            System.out.println("위 내용이 맞나요?");
            System.out.println("Y : 등록하기");
            System.out.println("N : 취소하기");
            char answer = sc.next().charAt(0);


            if (answer == 'Y' || answer == 'y') {
                PostController.insertPost(postDto, "3");
                System.out.println("공지사항이 정상적으로 등록되었습니다.");
            } else if (answer == 'N' || answer == 'n') {
                System.out.println("글 작성을 취소합니다.");
            } else {
                System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
            }

        }

     public void delete() {
         System.out.println("삭제할 포스트 번호를 입력하세요 : ");
         String pno = sc.next();
         PostController.deletePost(pno);
     }
}
