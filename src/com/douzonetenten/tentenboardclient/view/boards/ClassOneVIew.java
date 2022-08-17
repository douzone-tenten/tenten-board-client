package com.douzonetenten.tentenboardclient.view.boards;

import com.douzonetenten.tentenboardclient.controller.ClassOneController;
import com.douzonetenten.tentenboardclient.dto.JoinPostDto;
import com.douzonetenten.tentenboardclient.dto.PostDto;
import com.douzonetenten.tentenboardclient.view.LoginMainView;

import java.util.ArrayList;
import java.util.Scanner;

import static com.douzonetenten.tentenboardclient.utils.ConsoleUtils.clearConsole;

public class ClassOneVIew {
    ClassOneController class1Controller = new ClassOneController();
    public void start(String selectNum) { //목록 조회
        Scanner scanner = new Scanner(System.in);
        ArrayList<JoinPostDto> getClass1List = ClassOneController.findByClass1(selectNum);

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
        System.out.println("3. 게시글 수정");
        System.out.println("4. 게시글 상세 조회"); //구현 예정.
        System.out.println("9. 프로그램 종료");
        System.out.println("999. 메인 메뉴로");

        int num = scanner.nextInt();
        String boardNo = selectNum;
        if (num == 1){//게시글 작성
            insertPost(boardNo);
        }
        if (num == 2){
            deletePost(boardNo);
        }
        if(num == 3){
            editPost(boardNo);
        }
        if(num == 4){
            detailPost(boardNo);
        }
        if (num == 9){
            System.out.println("프로그램을 종료합니다.");
            System.exit(0);
        }
        if(num == 999){
            LoginMainView loginMainView = new LoginMainView();
            loginMainView.start();
        }

        scanner.close();
    }

    public void insertPost(String boardNo){ //게시글 작성
        Scanner scanner = new Scanner(System.in);
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
        scanner.close();
    }

    public void deletePost(String boardNo){ //게시글 삭제
        Scanner scanner = new Scanner(System.in);
        System.out.println("삭제할 포스트 번호를 입력해주세요.");
        String selectPost = scanner.next();
        ClassOneController.deletePost(selectPost);

        scanner.close();
    }

    private void editPost(String boardNo) { //TODO : 상세보기 후 수정하기
        Scanner scanner = new Scanner(System.in);
        System.out.println("수정할 포스트 번호를 입력해주세요.");
        String selectPost = scanner.next();
        ClassOneController.editPost(selectPost);

        scanner.close();
    }

    private void detailPost(String boardNo) {//게시글 상세 보기
        Scanner scanner = new Scanner(System.in);
        System.out.println("글 내용을 보고싶은 포스트 번호를 입력해주세요.");
        String selectPost = scanner.next();
        //Class1Controller.detailPost(selectPost);
        ArrayList<JoinPostDto> getClass1SelectPost = ClassOneController.detailPost(selectPost);


        if (getClass1SelectPost.isEmpty()) {
            System.out.println("포스트가 삭제되었거나 존재하지않습니다.");
        }
        if (!(getClass1SelectPost.isEmpty())) {
            for (JoinPostDto joinPostDto : getClass1SelectPost) {
                System.out.println(joinPostDto.findSelectDetailPostToString());
            }
        }

        scanner.close();
    }

}
