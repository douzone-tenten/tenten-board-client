package com.douzonetenten.tentenboardclient.view.boards;

import com.douzonetenten.tentenboardclient.controller.QnAController;
import com.douzonetenten.tentenboardclient.dto.JoinPostDto;
import com.douzonetenten.tentenboardclient.dto.PostDto;

import java.util.ArrayList;
import java.util.Scanner;

import static com.douzonetenten.tentenboardclient.service.UserService.loginUserContext;
import static com.douzonetenten.tentenboardclient.utils.ConsoleUtils.clearConsole;
import static com.douzonetenten.tentenboardclient.utils.ConsoleUtils.logInfo;

public class QnAView {


    static QnAController qnAController = new QnAController();

    public static void start(String selectNum) {
        Scanner scanner = new Scanner(System.in);


        while(true) {
            ArrayList<JoinPostDto> getPostList = qnAController.findAllByQnA(selectNum);

            System.out.println("QnA 게시판");
            System.out.printf("-------------------------------------------\n" +
                              "게시글 번호\t\t제목\t\t작성자\t\t작성시간\n" +
                              "-------------------------------------------\n");

            if (getPostList.isEmpty()) {
                logInfo("조회할 포스트가 없습니다.\n");
            }
            if (!(getPostList.isEmpty())) {
                for (JoinPostDto joinPostDto : getPostList) {
                    System.out.println(joinPostDto.findPostToString());
                }
            }

            System.out.println("b. 뒤로가기\t\tw. 글쓰기\t\td. 상세보기");
            System.out.print("메뉴를 입력하세요 : ");
            String selectPost = scanner.next();


            //뒤로가기
            if (selectPost.equals("b") || selectPost.equals("B")) {
                logInfo("뒤로 이동합니다.");
                break;
            }


            //글쓰기
            if (selectPost.equals("w") || selectPost.equals("W")) {
                insertQnA(selectNum);
                clearConsole();
            }


            //상세보기
            if(selectPost.equals("d") || selectPost.equals("D")){
                System.out.print("상세보기할 게시판의 번호를 입력해주세요. : ");
                String selectDetailNum = scanner.next();
                detailQnA(selectDetailNum);
                while(true) {
                    System.out.println("b. 뒤로가기\t\tu. 수정하기\t\te. 삭제하기");
                    System.out.print("해당 게시글에 대한 메뉴를 선택하세요 : ");
                    String selectUENum = scanner.next();

                    if(selectUENum.equals("u") || selectUENum.equals("U")) {
                        updateQnA();
                        break;
                    }
                    if(selectUENum.equals("e") || selectUENum.equals("E")) {
                        deleteQnA(selectDetailNum);
                        break;
                    }

                    if(selectUENum.equals("b") || selectUENum.equals("B")) {
                        clearConsole();
                        break;
                    }

                }
            }
        }
    }


    //QnA 게시글 작성
    public static void insertQnA(String selectNum) {
        Scanner scanner = new Scanner(System.in);
        clearConsole();

        PostDto postDto = new PostDto();
        System.out.print("QnA 제목을 입력하세요 : ");
        String qnaTitle = scanner.nextLine();

        System.out.print("글 내용을 입력하세요 : ");
        String qnaBody = scanner.nextLine();

        postDto.setPostTitle(qnaTitle);
        postDto.setPostBody(qnaBody);

        clearConsole();

        System.out.println(postDto.getPostTitle());
        System.out.println(postDto.getPostBody());

        System.out.println("작성한 내용이 위와 같나요?");
        System.out.println("Y : 등록하기");
        System.out.println("B : 취소하기");
        String select = scanner.next();
        Long userId = loginUserContext.get(0).getUserNo();

        if(select.equals("Y")){
            qnAController.insertQnA(postDto, userId, selectNum);
        }
        if(select.equals("B")){
            System.out.println("글 작성을 취소합니다.");
        }
    }

    //글제목 작성자 작성시간 글내용
    //QnA 게시글 상세조회
    public static void detailQnA(String selectDetailNum) {
        clearConsole();
        System.out.printf("--------------------------------------------------------------------------\n" +
                        "[제\t\t목]\t" + qnAController.detailQnA(selectDetailNum).get(0).getPostTitle() + "\n" +
                        "[작\t성\t자]\t" + qnAController.detailQnA(selectDetailNum).get(0).getUsername() + "\n" +
                        //"[작성시간]\t" + qnAController.detailQnA(selectDetailNum).get(0).getCreatedAt() + "\n" +
                        "[내\t\t용]\n" + qnAController.detailQnA(selectDetailNum).get(0).getPostBody() + "\n" +
                        "----------------------------------------------------------------------------\n\n");
    }


    //QnA 게시글 삭제
    public static void deleteQnA(String selectDetailNum) {
        qnAController.deleteQnA(selectDetailNum);
        clearConsole();
        System.out.println("해당 QnA 게시글을 삭제했습니다.\n\n");
    }


    //QnA 게시글 수정
    public static void updateQnA() {
    }
}
