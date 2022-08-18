package com.douzonetenten.tentenboardclient.view.boards;

import com.douzonetenten.tentenboardclient.controller.PostController;
import com.douzonetenten.tentenboardclient.dto.JoinPostDto;
import com.douzonetenten.tentenboardclient.view.PostView;

import java.util.ArrayList;
import java.util.Scanner;

import static com.douzonetenten.tentenboardclient.service.UserService.loginUserContext;
import static com.douzonetenten.tentenboardclient.utils.ConsoleUtils.logError;
import static com.douzonetenten.tentenboardclient.utils.ConsoleUtils.logWarn;
import static com.douzonetenten.tentenboardclient.utils.UserInterfaceUtils.uiTitle;

public class FreeBoardView {
    PostController PostController = new PostController();

    public FreeBoardView freeBoardView=new FreeBoardView();

    private PostView postView = new PostView();
    private Scanner scanner = new Scanner(System.in);
    public void start(String selectNum) {
        while(true) {

            ArrayList<JoinPostDto> getPostList = PostController.findByPost(selectNum);
            uiTitle("자유게시판");
            // TODO : 게시판 공통 컴포넌트
            System.out.printf("--------------------------------\n" + "게시글 번호      제목        작성자      작성시간\n" + "--------------------------------\n");

            // 게시글 목록 조회
            if (getPostList.isEmpty()) {
                logWarn("조회할 포스트가 없습니다.");
            }

            if (!(getPostList.isEmpty())) {
                for (JoinPostDto joinPostDto : getPostList) {
                    System.out.println(joinPostDto.findPostToString());
                }
            }


            System.out.println("b. 뒤로가기  w. 글쓰기  d: 상세조회");

            String selectPostMenu1 = scanner.next();

            /**
             * 예외처리
             */
            if (!(selectPostMenu1.equals("b") || selectPostMenu1.equals("w") || selectPostMenu1.equals("d"))) {
                logError("메뉴를 잘못 입력하셨습니다.");
            }
            /**
             * 뒤로가기
             */
            if (selectPostMenu1.equals("b") || selectPostMenu1.equals("B")) {
                break;
            }
            if (selectPostMenu1.equals("w") || selectPostMenu1.equals("W")) {
                postView.insertPost(selectNum);
            }
            if (selectPostMenu1.equals("d") || selectPostMenu1.equals("D")) {
                freeDetailByView(selectNum);
            }

        }




    }

    public void freeDetailByView(String selectNum){

        // 로그인한 객체에서 user_id 추출
        String login_user_no = loginUserContext.get(0).getUserNo().toString();


        System.out.print("조회할 게시글 번호를 입력하세요 : ");
        String selectPost = scanner.next();


    }

}
