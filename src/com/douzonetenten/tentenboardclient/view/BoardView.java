package com.douzonetenten.tentenboardclient.view;

import com.douzonetenten.tentenboardclient.controller.PostController;
import com.douzonetenten.tentenboardclient.dto.JoinPostDto;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardView {
    PostController PostController = new PostController();

    public void start(String selectNum) {
        Scanner scanner = new Scanner(System.in);
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

        System.out.print("조회할 게시글 번호를 입력하세요 : ");
        String selectPost = scanner.next();
        // 6번 게시글 조회를 어떻게 할것인가?
    }
}
