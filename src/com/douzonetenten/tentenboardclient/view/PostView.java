package com.douzonetenten.tentenboardclient.view;

import com.douzonetenten.tentenboardclient.controller.PostController;
import com.douzonetenten.tentenboardclient.dto.PostDto;
import com.douzonetenten.tentenboardclient.service.UserService;
import com.douzonetenten.tentenboardclient.view.boards.AnonymousView;

import java.util.Scanner;

import static com.douzonetenten.tentenboardclient.service.UserService.loginUserContext;
import static com.douzonetenten.tentenboardclient.utils.ConsoleUtils.clearConsole;
import static com.douzonetenten.tentenboardclient.utils.ConsoleUtils.logError;

public class PostView {
    //AnonymousView anonymousView = new AnonymousView();
   UserService userService = new UserService();
    private PostController postController = new PostController();
    private Scanner scanner = new Scanner(System.in);

    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    // insertPost()  함수에  접속한 게시판의 번호를 전달하는 파라미터(selectNum) 추가

    public void insertPost(String selectNum){
        /**
         * next()와 nextLine()의 차이 : 공백 처리가 가능한가.
         */


        //clearConsole();  // 제목이 자동입력되는 오류 추측
        PostDto postDto = new PostDto();
        System.out.println("제목을 입력하세요 : ");
        String postTitle = scanner.nextLine();
        System.out.println("글 내용을 입력하세요.");
        String postBody = scanner.nextLine();
        postDto.setPostTitle(postTitle);
        postDto.setPostBody(postBody);
        clearConsole();
        System.out.println(postDto.getPostTitle());
        System.out.println(postDto.getPostBody());
        System.out.println("위 내용이 맞나요?");
        System.out.println("Y : 등록하기");
        System.out.println("B : 취소하기");

        String select = scanner.next();
        // TODO : 예외처리
        if (select.equals("Y") || select.equals("y")) {
            // TODO : 게시판 번호 조회를 어떻게 할 것인가?
            postController.insertPost(postDto, selectNum);
        }
        if (select.equals("B")) {
            System.out.println("글 작성을 취소합니다.");
        }
    }

    // 익명게시판 글 등록
    public void InsertPost(String selectNum){
        /**
         * next()와 nextLine()의 차이 : 공백 처리가 가능한가.
         */
        // 글쓰기를 연속으로 진행 시 메뉴 선택 후 엔터가 제목으로 입력되는 것 방지
        scanner.nextLine();

        //clearConsole();  // 제목이 자동입력되는 오류 추측
        PostDto postDto = new PostDto();
        System.out.println("제목을 입력하세요 : ");
        String postTitle = scanner.nextLine();
        System.out.println("글 내용을 입력하세요.");
        String postBody = scanner.nextLine();
        postDto.setPostTitle(postTitle);
        postDto.setPostBody(postBody);
        clearConsole();
        System.out.println(postDto.getPostTitle());
        System.out.println(postDto.getPostBody());
        System.out.println("위 내용이 맞나요?");
        System.out.println("Y : 등록하기");
        System.out.println("B : 취소하기");

        String select = scanner.next();
        // TODO : 예외처리
        if (select.equals("Y") || select.equals("y")) {
            // TODO : 게시판 번호 조회를 어떻게 할 것인가?
            postController.insertPost(postDto, selectNum);
        }
        if (select.equals("B")) {
            System.out.println("글 작성을 취소합니다.");
        }
    }

    public void deletePost(){
        System.out.println("삭제할 포스트 번호를 입력해주세요.");
        String selectPost = scanner.next();
        postController.deletePost(selectPost);
    }

    public void findAllByPost(){
        System.out.println("전체 포스트를 조회합니다.");
        postController.findAllByPost();
    }


//게시판 하단 메뉴 공통 컴포넌트화
//    public void footerMenu(String selectNum){
//        System.out.println("b. 뒤로가기  n. 다음페이지   f. 이전 페이지   w. 글쓰기  d: 상세조회");
//        String selectPost2 = scanner.next();
//
//        /**
//         * 예외처리
//         */
//        if (!(selectPost2.equals("b") || selectPost2.equals("n") || selectPost2.equals("f") || selectPost2.equals("w") || selectPost2.equals("d"))) {
//            logError("메뉴를 잘못 입력하셨습니다.");
//        }
//        /**
//         * 뒤로가기
//         */
//        if (selectPost2.equals("b") || selectPost2.equals("B")) {
//            break;   //
//        }
//        /**
//         * 다음페이지
//         */
//        if (selectPost2.equals("n") || selectPost2.equals("N")) {
//            // TODO : 다음페이지 기능구현
//        }
//        /**
//         * 이전페이지
//         */
//        if (selectPost2.equals("f") || selectPost2.equals("F")) {
//            // TODO : 이전페이지 기능구현
//        }
//        if (selectPost2.equals("w") || selectPost2.equals("W")) {
//            insertPost(selectNum);
//        }
//        if (selectPost2.equals("d") || selectPost2.equals("D")) {
//            anonymousView.findDetailByPost();   //익명게시판 전용 상세조회
//        }
//    }






}






