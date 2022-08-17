package com.douzonetenten.tentenboardclient.view;

import com.douzonetenten.tentenboardclient.controller.PostController;
import com.douzonetenten.tentenboardclient.dto.BoardDto;
import com.douzonetenten.tentenboardclient.dto.JoinPostDto;
import com.douzonetenten.tentenboardclient.dto.PostDto;
import com.douzonetenten.tentenboardclient.dto.UserDto;
import com.douzonetenten.tentenboardclient.view.feature.Display;

import java.util.ArrayList;
import java.util.Scanner;

public class EmpBoardView {

    PostController postController = new PostController();

    PostDto postDto = new PostDto();

    UserDto userDto = new UserDto();

    BoardDto boardDto = new BoardDto();

    public void start(String selectNum) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<JoinPostDto> getPostList = postController.findByPost(selectNum);

        System.out.println("직원 전용 게시판");
        System.out.printf("--------------------------------------\n" +
                "게시글 번호      제목        작성자      작성시간\n" +
                "--------------------------------------\n");

        /*게시글 목록 조회*/
        if (getPostList.isEmpty()) {
            System.out.println("조회할 포스트가 없습니다.");
        }

        if (!(getPostList.isEmpty())) {
            for (JoinPostDto joinPostDto : getPostList) {
                System.out.println(joinPostDto.findPostToString());
            }
        }

        System.out.print("조회할 게시글 번호를 입력하세요 : ");
        String selectPost = scanner.next();
        // b. 뒤로가기, n. 다음 페이지, f. 이전 페이지, w. 글쓰기로 이동
        if (selectPost == "w") { /* 게시글 쓰기 (CREATE) */
            insertPost(); // ??
        }
        // 6번 게시글 조회를 어떻게 할것인가? 입력받은 숫자 == post_id
        /* 게시글 상세조회 (READ) */
        for (JoinPostDto joinPostDto : getPostList) {
            if ( Long.parseLong(selectPost) == joinPostDto.getPostId() ) {
                Display.clearConsole();
                Display.displayTitle("게시글 상세조회");
                System.out.println(joinPostDto.detailPostToString());
            } else {
                System.out.println("선택하신 번호의 게시글은 없습니다. 다시 선택해주세요.");
            }
        }
        // b. 뒤로가기, e. 게시글 수정, d. 게시글 삭제
        String move = scanner.next();
        if ( move == "b" ) {
            start("6"); // 뒤로가기 ( start 메소드 실행 )
        }
        /* 게시글 삭제 (DELETE) */
        if ( move == "d" ) {
            System.out.println("정말 게시물을 삭제하시겠습니까? (Y/N)");
            char ans = scanner.next().charAt(0);
            if ( ans == 'y' || ans == 'Y') {
                postController.deletePost(selectPost); // selectPost 변수 재활용
            } else if ( ans == 'n' || ans == 'N' ) {
                System.out.println("게시물이 삭제되지 않았습니다.");
            } else {
                System.out.println("유효하지 않은 입력입니다. 다시 입력해주세요."); // 반복문으로 수정해야 질문으로 돌아갈 듯
            }
        }

        // 메소드 선언 및 호출에서 모르겠음
        public static void insertPost() { /* 글쓰기 메소드 */
            Display.clearConsole();
            Display.displayTitle("글쓰기");
            postDto.setUserNo(userDto.getUserNo()); // 로그인한 회원의 넘버 가져옴
            postDto.setBoardNo(boardDto.getBoardNo()); // 직원용 게시판 넘버 강제 셋팅
            System.out.println("글 제목을 입력하세요.");
            postDto.setPostTitle(scanner.nextLine());
            System.out.println("글 내용을 입력하세요.");
            postDto.setPostBody(scanner.nextLine());

            int result = postController.insertPost(postDto, ); // 매개변수....뭐지

            if (result == 1) {
                System.out.println("게시글이 작성되었습니다.");
            }


        }







    }
}
