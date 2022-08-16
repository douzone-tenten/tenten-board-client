package com.douzonetenten.tentenboardclient.view;

import com.douzonetenten.tentenboardclient.controller.Class1Controller;
import com.douzonetenten.tentenboardclient.dto.JoinPostDto;

import java.util.ArrayList;
import java.util.Scanner;

public class Class1View {

    private PostView postView = new PostView();

    Class1Controller class1PostController = new Class1Controller();

    public void start(String selectNum) { //목록 조회
        ArrayList<JoinPostDto> getClass1List = Class1Controller.findByClass1(selectNum);

        System.out.println("더존 1반 게시판");
        System.out.printf("--------------------------------\n" +
                "게시글 번호      제목        작성자      작성시간\n" +
                "--------------------------------\n");

        //게시글 목록 조회
        if (getClass1List.isEmpty()) {
            System.out.println("조회할 포스트가 없습니다.");
        }
        if (!(getClass1List.isEmpty())) {
            for (JoinPostDto joinPostDto : getClass1List) {
                System.out.println(joinPostDto.findPostToString());
            }
        }

        System.out.println("1. 게시글 작성");
        System.out.println("2. 게시글 삭제");
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        if (num == 1){
            String boardNo = "2";
            postView.insertPost(boardNo);
        }



        


        

    }




}
