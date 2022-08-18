package com.douzonetenten.tentenboardclient.view.boards;

import com.douzonetenten.tentenboardclient.controller.PostController;
import com.douzonetenten.tentenboardclient.dto.JoinPostDto;
import com.douzonetenten.tentenboardclient.view.PostView;


import java.util.ArrayList;
import java.util.Scanner;

import static com.douzonetenten.tentenboardclient.service.UserService.loginUserContext;
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
    private Scanner scanner = new Scanner(System.in);
    public void start(String selectNum) {


        while (true) {
            // 게시글 등록 후 게시글 목록 최신화를 위해 while문 안으로 이동함
            //ArrayList<JoinPostDto> getPostList = postController.findByPost(selectNum);

            // 로그인한 객체에서 user_id 추출
            String login_user_no = loginUserContext.get(0).getUserNo().toString();
            // 로그인한 유저의 게시글만 보일 수 있도록 출력
            // login_user_no = 로그인 한 객체의 user_no ,  selectNum = 접속한 게시판 번호
            ArrayList<JoinPostDto> getPostList =postController.findSameUserByPost(login_user_no, selectNum);

            uiTitle("익명게시판");

            // TODO : 게시판 목차 공통 메소드 작성
            System.out.print("--------------------------------\n"
                    + "게시글 번호      제목        작성자      작성시간\n"
                    + "--------------------------------\n");

            // 게시글 목록 조회
            // 접속한 게시판번호와 일치하는 게시글이 없을 시
            String login_userName = loginUserContext.get(0).getUsername().toString();

            if (getPostList.isEmpty()) {
                logWarn(login_userName+"님이 작성한 게시글이 없습니다.");
            }
            // 접속한 게시판번호와 일치하는 게시글이 있을 시
            if (!(getPostList.isEmpty())) {
                for (JoinPostDto joinPostDto : getPostList) {
                    System.out.println(joinPostDto.findPostToString());
                }
            }

            uiSelectMenu();

            //TODO 하단 메뉴 공통 컨포넌트화
            //postView.footerMenu(selectNum);   // => 뒤로가기 기능 다시 구상 필요 break;

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
                findDetailByPost();   //익명게시판 전용 상세조회
            }
        }


    }

    // 익명게시판의 상세조회
    public void findDetailByPost () {
        System.out.println("게시글 상세조회");

        // 익명게시판은 자신이 작성한 게시글에 대해서만 상세조회가 가능
        // 우선 로그인한 회원의 user_no이 post의 user_member_no과 일치하는 글들만 조회,
        // 일치하는 글이 없으면 "~ 님이 작성하신 글은 없습니다"로 출력








        /*
         * 로그인한 객체정보와 상세조회할 게시글의 작성자 일치여부 & 권한 여부 체크
         * */


        System.out.println("상세 조회할 게시글의 번호를 입력하세요 : ");
        long post_id = scanner.nextLong();
        //test
        System.out.println("현재 로그인한 객체 : " + loginUserContext);


        //









//        for (int i = 0; i < loginUserContext.size(); i++) {
//            System.out.println(loginUserContext.get(i));
//        }
//
//        System.out.println("리스트 사이즈"+loginUserContext.size());








    }


}