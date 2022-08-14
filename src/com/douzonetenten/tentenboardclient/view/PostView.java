package com.douzonetenten.tentenboardclient.view;

import com.douzonetenten.tentenboardclient.controller.PostController;
import com.douzonetenten.tentenboardclient.dto.PostDto;

import java.util.Scanner;

import static com.douzonetenten.tentenboardclient.view.MainView.clearConsole;

public class PostView {
    private PostController postController = new PostController();
    private Scanner scanner = new Scanner(System.in);
    public void insertPost(){
        /**
         * next()와 nextLine()의 차이 : 공백 처리가 가능한가.
         */
        clearConsole();
        PostDto postDto = new PostDto();
        System.out.print("제목을 입력하세요 : ");
        String postTitle = scanner.nextLine();
        System.out.print("글 내용을 입력하세요.");
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
        if (select.equals("Y")) {
            postController.insertPost(postDto);
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
}
