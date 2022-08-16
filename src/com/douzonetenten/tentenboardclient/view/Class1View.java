package com.douzonetenten.tentenboardclient.view;

import com.douzonetenten.tentenboardclient.controller.Class1Controller;
import com.douzonetenten.tentenboardclient.dto.JoinPostDto;
import com.douzonetenten.tentenboardclient.dto.PostDto;

import java.util.ArrayList;
import java.util.Scanner;

import static com.douzonetenten.tentenboardclient.view.feature.Display.clearConsole;

public class Class1View {

    //private PostView postView = new PostView();
    //private Class1View class1View = new Class1View();
    Class1Controller class1Controller = new Class1Controller();

    //private  Scanner scanner = new Scanner(System.in);

    public void start(String selectNum) { //목록 조회
        Scanner scanner = new Scanner(System.in);
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


        int num = scanner.nextInt();
//        if (num == 1){
//            String boardNo = "2";
//            postView.insertPost(boardNo);
//        }
//        if (num == 2){
//            postView.deletePost();
//        }
        String boardNo = selectNum;
        if (num == 1){//게시글 작성
            insertPost(boardNo);
        }
        if (num == 2){
            deletePost(boardNo);
        }
        
        
    }
    public void insertPost(String boardNo){
        Scanner scanner = new Scanner(System.in);
        /*
         * next()와 nextLine()의 차이 : 공백 처리가 가능한가.
         */
        clearConsole();
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
           class1Controller.insertPost(postDto, boardNo);
        }
        if (select.equals("B")) {
            System.out.println("글 작성을 취소합니다.");
        }
    }

    public void deletePost(String boardNo){
        Scanner scanner = new Scanner(System.in);
        System.out.println("삭제할 포스트 번호를 입력해주세요.");
        String selectPost = scanner.next();
        Class1Controller.deletePost(selectPost);
    }
}
