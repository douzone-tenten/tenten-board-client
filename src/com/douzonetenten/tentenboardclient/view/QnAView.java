package com.douzonetenten.tentenboardclient.view;

import com.douzonetenten.tentenboardclient.controller.QnAController;
import com.douzonetenten.tentenboardclient.dto.JoinPostDto;
import com.douzonetenten.tentenboardclient.dto.PostDto;
import com.douzonetenten.tentenboardclient.dto.UserDto;

import java.util.ArrayList;
import java.util.Scanner;

public class QnAView {

    static QnAController qnAController = new QnAController();

    public static void start(String selectNum) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<PostDto> getPostList = qnAController.findAllByQnA(selectNum);

        System.out.println("QnA 게시판");
        System.out.printf("-------------------------------------------\n" +
                          "게시글 번호\t제목\t작성자\t작성시간\n" +
                          "-------------------------------------------\n");

        if (getPostList.isEmpty()) {
            System.out.println("조회할 포스트가 없습니다.");
        }
        if (!(getPostList.isEmpty())) {
            for (PostDto postDto : getPostList) {
                System.out.println(postDto.toString());
            }
        }

        System.out.print("조회할 게시글 번호를 입력하세요 : ");
        System.out.println("b. 뒤로가기\tn. 다음페이지\tf. 이전페이지\tw.글쓰기\td. 게시글삭제");
        String selectPost = scanner.next();

        //뒤로가기
        if(selectPost.equals("b")) {

        }

        //다음페이지
        if(selectPost.equals("b")) {

        }

        //이전페이지
        if(selectPost.equals("b")) {

        }

        //글쓰기
        if(selectPost.equals("w")) {
            qnAController.insertQnA(new PostDto(), new UserDto(), selectNum);
        }

        if(selectPost.equals("d")) {
            System.out.print("삭제할 게시글 번호를 입력해주세요 : ");
            String postNo = scanner.next();
            qnAController.deleteQnA(postNo);
        }

    }















    //    private Scanner scanner;
//    public QnAView() {this.scanner = new Scanner(System.in);}
//
//    //QnA 목록 조회
//    public void findAllByPost() {
//        System.out.println("전체 QnA의 목록을 조회합니다.");
//        this.qnAController.findAllByQnA();
//    }
//
//    //QnA 게시글 작성
//    public void insertQnA() {
//        MainView.clearConsole();
//
//        PostDto postDto = new PostDto();
//
//        System.out.print("QnA 제목을 입력하세요 : ");
//        String qnaTitle = this.scanner.nextLine();
//
//        System.out.print("글 내용을 입력하세요 : ");
//        String qnaBody = this.scanner.nextLine();
//
//        postDto.setPostTitle(qnaTitle);
//        postDto.setPostBody(qnaBody);
//
//        MainView.clearConsole();
//
//        System.out.println(postDto.getPostTitle());
//        System.out.println(postDto.getPostBody());
//
//        System.out.println("작성한 내용이 위와 같나요?");
//        System.out.println("Y : 등록하기");
//        System.out.println("B : 취소하기");
//        String select = this.scanner.next();
//
//        if(select.equals("Y")){
//            this.qnAController.insertQnA(postDto);
//        }
//        if(select.equals("B")){
//            System.out.println("글 작성을 취소합니다.");
//        }
//    }
//
//
//    //QnA 게시글 삭제
//    public void  deleteQnA() {
//        System.out.print("삭제할 QnA 번호를 입력해주세요 : ");
//        String selectQnA = this.scanner.next();
//        this.qnAController.deleteQnA(selectQnA);
//        System.out.println("해당 QnA 게시글을 삭제했습니다.");
//    }



}