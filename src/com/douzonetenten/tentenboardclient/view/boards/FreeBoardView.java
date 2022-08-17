package com.douzonetenten.tentenboardclient.view.boards;

import com.douzonetenten.tentenboardclient.controller.PostController;
import com.douzonetenten.tentenboardclient.dto.JoinPostDto;

import java.util.ArrayList;
import java.util.Scanner;

import static com.douzonetenten.tentenboardclient.utils.ConsoleUtils.logWarn;
import static com.douzonetenten.tentenboardclient.utils.UserInterfaceUtils.uiTitle;

public class FreeBoardView {
    PostController PostController = new PostController();

    public void start(String selectNum) {
        Scanner scanner = new Scanner(System.in);
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

        System.out.print("조회할 게시글 번호를 입력하세요 : ");
        String selectPost = scanner.next();

        // TODO : 뒤로가기 및 상세보기 및 글작성 ...

    }
}
