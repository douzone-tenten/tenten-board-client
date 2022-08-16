package com.douzonetenten.tentenboardclient.view;

import com.douzonetenten.tentenboardclient.controller.QnAController;
import com.douzonetenten.tentenboardclient.dto.PostDto;
import com.sun.tools.javac.Main;

import java.util.Scanner;

public class QnAView {

    private QnAController qnAController = new QnAController();
    private Scanner scanner;
    public QnAView() {this.scanner = new Scanner(System.in);}

    //QnA 목록 조회
    public void findAllByPost() {
        System.out.println("전체 QnA의 목록을 조회합니다.");
        this.qnAController.findAllByQnA();
    }

    //QnA 게시글 작성
    public void insertQnA() {
        MainView.clearConsole();

        PostDto postDto = new PostDto();

        System.out.print("QnA 제목을 입력하세요 : ");
        String qnaTitle = this.scanner.nextLine();

        System.out.print("글 내용을 입력하세요 : ");
        String qnaBody = this.scanner.nextLine();

        postDto.setPostTitle(qnaTitle);
        postDto.setPostBody(qnaBody);

        MainView.clearConsole();

        System.out.println(postDto.getPostTitle());
        System.out.println(postDto.getPostBody());

        System.out.println("작성한 내용이 위와 같나요?");
        System.out.println("Y : 등록하기");
        System.out.println("B : 취소하기");
        String select = this.scanner.next();

        if(select.equals("Y")){
            this.qnAController.insertQnA(postDto);
        }
        if(select.equals("B")){
            System.out.println("글 작성을 취소합니다.");
        }
    }


    //QnA 게시글 삭제
    public void  deleteQnA() {
        System.out.print("삭제할 QnA 번호를 입력해주세요 : ");
        String selectQnA = this.scanner.next();
        this.qnAController.deleteQnA(selectQnA);
        System.out.println("해당 QnA 게시글을 삭제했습니다.");
    }



}
