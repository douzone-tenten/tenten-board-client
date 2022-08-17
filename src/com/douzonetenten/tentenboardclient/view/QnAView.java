package com.douzonetenten.tentenboardclient.view;

import com.douzonetenten.tentenboardclient.controller.QnAController;
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
                          "게시글 번호\t\t제목\t\t작성자\t\t작성시간\n" +
                          "-------------------------------------------\n");

        if (getPostList.isEmpty()) {
            System.out.println("조회할 포스트가 없습니다.\n");
        }
        if (!(getPostList.isEmpty())) {
            for (PostDto postDto : getPostList) {
                System.out.println(postDto.toString());
            }
        }

        System.out.println("b. 뒤로가기\t\tn. 다음페이지\t\tf. 이전페이지\t\tw.글쓰기\t\td. 게시글삭제");
        System.out.print("메뉴를 입력하세요 : ");
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
            insertQnA(selectNum);

        }

        if(selectPost.equals("d")) {
            System.out.print("삭제할 게시글 번호를 입력해주세요 : ");
            String postNo = scanner.next();
            qnAController.deleteQnA(postNo);
        }

    }











    //QnA 목록 조회
//    public void findAllByPost() {
//        System.out.println("전체 QnA의 목록을 조회합니다.");
//        this.qnAController.findAllByQnA();
//    }

    //QnA 게시글 작성
    public static void insertQnA(String selectNum) {

        Scanner scanner = new Scanner(System.in);

        MainView.clearConsole();

        PostDto postDto = new PostDto();

        System.out.print("QnA 제목을 입력하세요 : ");
        String qnaTitle = scanner.nextLine();

        System.out.print("글 내용을 입력하세요 : ");
        String qnaBody = scanner.nextLine();

        postDto.setPostTitle(qnaTitle);
        postDto.setPostBody(qnaBody);

        MainView.clearConsole();

        System.out.println(postDto.getPostTitle());
        System.out.println(postDto.getPostBody());

        System.out.println("작성한 내용이 위와 같나요?");
        System.out.println("Y : 등록하기");
        System.out.println("B : 취소하기");
        String select = scanner.next();

        if(select.equals("Y")){
            qnAController.insertQnA(new PostDto(), new UserDto(), selectNum);
        }
        if(select.equals("B")){
            System.out.println("글 작성을 취소합니다.");
        }
    }


    //QnA 게시글 삭제
    public void  deleteQnA() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("삭제할 QnA 번호를 입력해주세요 : ");
        String selectQnA = scanner.next();
        qnAController.deleteQnA(selectQnA);
        System.out.println("해당 QnA 게시글을 삭제했습니다.");
    }



}
