package com.douzonetenten.tentenboardclient.view;

import com.douzonetenten.tentenboardclient.controller.PostController;
import com.douzonetenten.tentenboardclient.dto.PostDto;

import java.util.Scanner;

public class PostView {
    private PostController postController = new PostController();
    private Scanner scanner = new Scanner(System.in);
    public void insertPost(){
        PostDto postDto = new PostDto();
        System.out.println("포스트를 생성합니다.");
        System.out.println("포스트의 제목이 뭔가요?");
        String postTitle = scanner.next();
        System.out.println("포스트의 내용이 뭔가요?");
        String postBody = scanner.next();
        postDto.setPostTitle(postTitle);
        postDto.setPostBody(postBody);
        postController.insertPost(postDto);
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
