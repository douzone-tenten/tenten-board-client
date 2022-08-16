package com.douzonetenten.tentenboardclient.view;

import com.douzonetenten.tentenboardclient.controller.PostController;
import com.douzonetenten.tentenboardclient.dto.JoinPostDto;
import com.douzonetenten.tentenboardclient.view.feature.Display;

import java.util.ArrayList;
import java.util.Scanner;

public class EmpBoardView {

    PostController postController = new PostController();

    public void start(String selectNum) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<JoinPostDto> getPostList = postController.findByPost(selectNum);

        System.out.println("직원 전용 게시판");
        System.out.printf("--------------------------------------\n" +
                "게시글 번호      제목        작성자      작성시간\n" +
                "--------------------------------------\n");

        // 게시글 목록 조회
        if (getPostList.isEmpty()) {
            System.out.println("조회할 포스트가 없습니다.");
        }

        if (!(getPostList.isEmpty())) {
            for (JoinPostDto joinPostDto : getPostList) {
                System.out.println(joinPostDto.findPostToString());
            }
        }

        System.out.print("조회할 게시글 번호를 입력하세요 : ");
        Long selectPost = scanner.nextLong();
        // 6번 게시글 조회를 어떻게 할것인가? 입력받은 숫자 == post_id
        // b. 뒤로가기, n. 다음 페이지, f. 이전 페이지, w. 글쓰기로 이동
        for (JoinPostDto joinPostDto : getPostList) {
            if ( selectPost == joinPostDto.getPostId() ) {
                Display.clearConsole();
                Display.displayTitle("게시글 상세조회");
                System.out.println(joinPostDto.detailPostToString());
            } else {
                System.out.println("선택하신 번호의 게시글은 없습니다. 다시 선택해주세요.");
            }
        }



    }
}
