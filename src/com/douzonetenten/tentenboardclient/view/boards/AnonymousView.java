package com.douzonetenten.tentenboardclient.view.boards;

import com.douzonetenten.tentenboardclient.controller.PostController;
import com.douzonetenten.tentenboardclient.dto.JoinPostDto;
import com.douzonetenten.tentenboardclient.view.PostView;


import java.util.ArrayList;
import java.util.Scanner;

import static com.douzonetenten.tentenboardclient.utils.ConsoleUtils.logError;
import static com.douzonetenten.tentenboardclient.utils.ConsoleUtils.logWarn;
import static com.douzonetenten.tentenboardclient.utils.UserInterfaceUtils.uiSelectMenu;
import static com.douzonetenten.tentenboardclient.utils.UserInterfaceUtils.uiTitle;

/**
 * 익명 게시판 클래스입니다.
 * Author : 김성안
 */
public class AnonymousView {
    PostController postController = new PostController();
    PostView postView = new PostView();

    public void start(String selectNum) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // 게시글 등록 후 게시글 목록 최산화를 위해 while문 안으로 이동함
            ArrayList<JoinPostDto> getPostList = postController.findByPost(selectNum);

            uiTitle("익명게시판");

            // TODO : 게시판 목차 공통 메소드 작성
            System.out.print("--------------------------------\n"
                    + "게시글 번호      제목        작성자      작성시간\n"
                    + "--------------------------------\n");

            // 게시글 목록 조회
            // 접속한 게시판번호와 일치하는 게시글이 없을 시
            if (getPostList.isEmpty()) {
                logWarn("조회할 포스트가 없습니다.");
            }
            // 접속한 게시판번호와 일치하는 게시글이 있을 시
            if (!(getPostList.isEmpty())) {
                for (JoinPostDto joinPostDto : getPostList) {
                    System.out.println(joinPostDto.findPostToString());
                }
            }


            // 상세조회
            //            System.out.print("조회할 게시글 번호를 입력하세요(없을 시 x ) : ");
            //            String selectPost = scanner.next();

            uiSelectMenu();
            // TODO : 메뉴 선택 공통컴포넌트
            System.out.println("b. 뒤로가기  n. 다음페이지   f. 이전 페이지   w. 글쓰기  d: 상세조회");
            String selectPost2 = scanner.next();

            /**
             * 예외처리
             */
            if (!(selectPost2.equals("b") || selectPost2.equals("n") || selectPost2.equals("f") || selectPost2.equals("w") || selectPost2.equals("d"))) {
                logError("메뉴를 잘못 입력하셨습니다.");
            }
            /**
             * 뒤로가기
             */
            if (selectPost2.equals("b") || selectPost2.equals("B")) {
                break;
            }
            /**
             * 다음페이지
             */
            if (selectPost2.equals("n") || selectPost2.equals("N")) {
                // TODO : 다음페이지 기능구현
            }
            /**
             * 이전페이지
             */
            if (selectPost2.equals("f") || selectPost2.equals("F")) {
                // TODO : 이전페이지 기능구현
            }
            if (selectPost2.equals("w") || selectPost2.equals("W")) {
                postView.insertPost(selectNum);
            }
            if (selectPost2.equals("d") || selectPost2.equals("D")) {
                postView.findDetailByPost();
            }
        }
    }
}