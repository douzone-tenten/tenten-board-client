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
    PostView postView = new PostView();
    public void start(String selectNum) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<JoinPostDto> getPostList = postController.findByPost(selectNum);
        PostDto postDto = new PostDto();

        while(true) {
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
                System.out.print("조회할 게시글 번호를 입력하세요 : ");
                String selectPost = scanner.next();


            }

            System.out.println("b. 뒤로가기  n. 다음페이지   f. 이전 페이지   w. 글쓰기  ");

            String selectPost2 = scanner.next();

            /**
             * 예외처리
             */
            if (!(selectPost2.equals("b") || selectPost2.equals("n") || selectPost2.equals("f") || selectPost2.equals("w"))) {
                displayError("메뉴를 잘못 입력하셨습니다.");
            }

            if (selectPost2.equals("b")) {
                System.out.println("b");
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
}