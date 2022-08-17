package com.douzonetenten.tentenboardclient.view;

import com.douzonetenten.tentenboardclient.controller.PostController;
import com.douzonetenten.tentenboardclient.dto.JoinPostDto;
import com.douzonetenten.tentenboardclient.dto.PostDto;

import java.util.ArrayList;
import java.util.Scanner;

import static com.douzonetenten.tentenboardclient.view.feature.Display.displayError;

public class AnonymousView {
    PostController postController = new PostController();
    BoardView boardView = new BoardView();
    //CategoriesView categoriesView = new CategoriesView();   // 오류 발생 왜 이런거지??
    PostView postView = new PostView();
    public void start(String selectNum) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<JoinPostDto> getPostList = postController.findByPost(selectNum);
        PostDto postDto = new PostDto();


      while(true) {   //while(true)개선해야함 : (뒤로가기 구현시)categoriesView.start()가 블록안에 있으면 => stackoverflow 발생
            System.out.println("익명 게시판");
            System.out.printf("--------------------------------\n" +
                    "게시글 번호      제목        작성자      작성시간\n" +
                    "--------------------------------\n");

            // 게시글 목록 조회
            // 접속한 게시판번호와 일치하는 게시글이 없을 시
            if (getPostList.isEmpty()) {
                System.out.println("조회할 포스트가 없습니다.");
            }
            // 접속한 게시판번호와 일치하는 게시글이 있을 시
            if (!(getPostList.isEmpty())) {
                for (JoinPostDto joinPostDto : getPostList) {
                    System.out.println(joinPostDto.findPostToString());
                }
            }
            System.out.println();
            //하단메뉴
            System.out.println("b. 뒤로가기  n. 다음페이지   f. 이전 페이지   w. 글쓰기  ");

            // 상세조회
//            System.out.print("조회할 게시글 번호를 입력하세요(없을 시 x ) : ");
//            String selectPost = scanner.next();





            // 하단 메뉴 선택
            String selectPost2 = scanner.next();

            /**
             * 예외처리
             */
            if (!(selectPost2.equals("b") || selectPost2.equals("n") || selectPost2.equals("f") || selectPost2.equals("w"))) {
                displayError("메뉴를 잘못 입력하셨습니다.");
            }

            if (selectPost2.equals("b")) {
                //categoriesView.start();
            }
            if (selectPost2.equals("n")) {
                System.out.println("n");
            }
            if (selectPost2.equals("f")) {
                System.out.println("f");
            }
            if (selectPost2.equals("w")) {
                postView.insertPost(selectNum);
            }

        }
    }

    // 하단 메뉴
    public void footerMenu(){





    }
    // 상세조회
    public  void detailPost()



}