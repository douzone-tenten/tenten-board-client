package com.douzonetenten.tentenboardclient.view;

import com.douzonetenten.tentenboardclient.dto.JoinPostDto;

import java.util.ArrayList;
import java.util.Scanner;

public class AnonymousView {


    public void start(String selectNum){
        Scanner scanner = new Scanner(System.in);
        ArrayList<JoinPostDto> getPostList = postController.findByPost(selectNum);

        System.out.println("자유 게시판");
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





    }


}
