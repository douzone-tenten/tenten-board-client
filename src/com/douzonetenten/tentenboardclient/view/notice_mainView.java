package com.douzonetenten.tentenboardclient.view;

import com.douzonetenten.tentenboardclient.controller.PostController;
import com.douzonetenten.tentenboardclient.dto.JoinPostDto;
import com.douzonetenten.tentenboardclient.dto.PostDto;

import java.util.ArrayList;
import java.util.Scanner;

public class notice_mainView {
    private PostView postwiew = new PostView();
    private Scanner sc = new Scanner(System.in);

    public void start(String selectNum) {
        Scanner sc = new Scanner(System.in);
        ArrayList<JoinPostDto> getPostList = PostController.findByPost(selectNum);

        System.out.println("공지사항 게시판");
        System.out.printf("-----------------------------------------------\n" +
                "게시글 번호       제목          작성자        작성시간\n" +
                "-----------------------------------------------\n");

        // 게시글 목록 조회
        if (getPostList.isEmpty()) {
            System.out.println("조회할 포스트가 없습니다.");
        }

        if (!(getPostList.isEmpty())) {
            for (JoinPostDto joinPostDto : getPostList) {
                System.out.println(joinPostDto.findPostToString());
            }
        }
        System.out.println("b.뒤로가기  n.다음 페이지  f.이전 페이지   s.공지사항 상세 조회    w.글쓰기  d.공지사항 삭제");
        char a = sc.next().charAt(0);
        if (a == 'w' || a == 'W') {
            insertAll();
        }else if(a == 'd' || a == 'D' ){
            delete();}
//        } else if (a == 's' || a == 'S') {
//            selectAll();
//        }
    }
    // TODO: 2022-08-17 게시글 상세 조회
//    public void select() {
//        System.out.print("조회할 게시글 번호를 입력하세요 : ");
//        String selectPost = sc.next();
//            PostDto postDto = new PostDto();
//
//                System.out.println("조회할 공지사항 번호를 입력하세요.");
//            int select = sc.nextInt();
//
//                if (select == select) {
//                System.out.println("공지사항 제목 : " + postDto.getPostTitle());
//                System.out.println("공지사항 번호 : " + postDto.getPostId());
//                System.out.println("공지사항 내용 : " + postDto.getPostBody());
//            }else {
//                System.out.println("입력하신 번호의 공지사항이 존재하지 않습니다.");
//            }
//    }


    public void insertAll() {

        PostDto postDto = new PostDto();
            System.out.println("공지사항의 제목을 입력하세요 : ");
            String postTitle = sc.nextLine();
            System.out.println("공지사항의 내용을 입력하세요 : ");
            String postBody = sc.nextLine();
            postDto.setPostTitle(postTitle);
            postDto.setPostBody(postBody);
            System.out.println(postDto.getPostTitle());
            System.out.println(postDto.getPostBody());
            sc.nextLine();
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

         System.out.println("정상적으로 공지사항이 삭제되었습니다.");
     }
}
