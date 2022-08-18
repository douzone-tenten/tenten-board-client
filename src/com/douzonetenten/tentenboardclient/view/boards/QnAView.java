package com.douzonetenten.tentenboardclient.view.boards;

import com.douzonetenten.tentenboardclient.controller.QnAController;
import com.douzonetenten.tentenboardclient.dto.JoinPostDto;
import com.douzonetenten.tentenboardclient.dto.PostDto;

import java.util.ArrayList;
import java.util.Scanner;

import static com.douzonetenten.tentenboardclient.service.UserService.loginUserContext;
import static com.douzonetenten.tentenboardclient.utils.ConsoleUtils.*;
import static com.douzonetenten.tentenboardclient.utils.UserInterfaceUtils.uiSelectMenu;
import static com.douzonetenten.tentenboardclient.utils.UserInterfaceUtils.uiTitle;

public class QnAView {


    static QnAController qnAController = new QnAController();

    /**
     * QnA Controller 호출하여 게시글 작성, 수정, 삭제, 상세조회 기능을 실행합니다.
     *
     * @param selectNum - 조회할 게시판의 카테고리 넘버입니다.
     * @author 강도영
     */
    public static void start(String selectNum) {
        Scanner scanner = new Scanner(System.in);


        while(true) {

            ArrayList<JoinPostDto> getPostList = qnAController.findAllByQnA(selectNum);
            clearConsole();
            uiTitle("  QnA 게시판");
            System.out.printf("--------------------------------------------------------------------------------------\n" +
                              "게시글 번호\t\t제목\t\t\t\t작성자\t\t\t\t작성시간\n" +
                              "--------------------------------------------------------------------------------------\n");

            //해당 게시글에 조회할 포스터의 유무를 확인 후 출력하기
            if (getPostList.isEmpty()) {
                logInfo("조회할 포스트가 없습니다.\n");
            }
            if (!(getPostList.isEmpty())) {
                for (JoinPostDto joinPostDto : getPostList) {
                    System.out.println(joinPostDto.findPostToString());
                }
            }

            System.out.println("\nB. 뒤로가기\t\tW. 글쓰기\t\tD. 상세보기");
            uiSelectMenu();
            String selectPost = scanner.next();

            //메뉴에 해당하지 않는 선택을 하였을 때 에러메세지 출력
            if(!selectPost.equals("w") || !selectPost.equals("W") || !selectPost.equals("d") || !selectPost.equals("D") ||
                    !selectPost.equals("b") || !selectPost.equals("B")) {
                logError("해당하는 메뉴가 없습니다. 다시 입력해주세요.");
            }


            //뒤로가기
            if (selectPost.equals("b") || selectPost.equals("B")) {
                clearConsole();
                logInfo("뒤로 이동합니다.");
                break;
            }


            //게시글 작성하기
            if (selectPost.equals("w") || selectPost.equals("W")) {
                insertQnA(selectNum);
                clearConsole();
            }


            //게시글 상세보기
            if(selectPost.equals("d") || selectPost.equals("D")){

                System.out.print("상세보기할 게시판의 번호를 입력해주세요. : ");
                String selectDetailNum = scanner.next();

                String loginID = loginUserContext.get(0).getUsername();
                String ComLoginId = qnAController.detailQnA(selectDetailNum).get(0).getUsername();
                System.out.println(loginID);
                System.out.println(ComLoginId);

                clearConsole();
                detailQnA(selectDetailNum);
                while(true) {
                    System.out.println("B. 뒤로가기\t\tU. 수정하기\t\tE. 삭제하기");
                    System.out.print("해당 게시글에 대한 메뉴를 선택하세요 : ");
                    String selectUENum = scanner.next();

                    //메뉴에 해당하지 않는 선택을 하였을 때 에러메세지 출력
                    if(!selectUENum.equals("u") || !selectUENum.equals("U") || !selectUENum.equals("e") || !selectUENum.equals("E") ||
                            !selectUENum.equals("b") || !selectUENum.equals("B")) {
                        logError("해당하는 메뉴가 없습니다. 다시 입력해주세요.");
                    }

                    
                    //게시글 수정하기
                    if(selectUENum.equals("u") || selectUENum.equals("U")) {
                        if(loginID.equals(ComLoginId)) {
                            updateQnA(selectDetailNum);
                            clearConsole();
                            logInfo("해당 QnA 게시글을 수정했습니다.\n");
                            detailQnA(selectDetailNum);
                            continue;
                        }
                        else {
                            clearConsole();
                            logInfo("게시글 작성자만 수정가능합니다.\n");
                            detailQnA(selectDetailNum);
                            continue;
                        }
                    }

                    
                    //게시글 삭제하기
                    if(selectUENum.equals("e") || selectUENum.equals("E")) {
                        if(loginID.equals(ComLoginId)) {
                            deleteQnA(selectDetailNum);
                            clearConsole();
                            logInfo("해당 QnA 게시글을 삭제했습니다.\n");
                            break;
                        }
                        else {
                            clearConsole();
                            logInfo("게시글 작성자만 삭제가능합니다.\n");
                            detailQnA(selectDetailNum);
                            continue;
                        }
                    }

                    
                    //뒤로가기
                    if(selectUENum.equals("b") || selectUENum.equals("B")) {
                        clearConsole();
                        break;
                    }

                }
            }
        }
    }


    /**
     * QnA 게시판에 게시글 작성하는 insertQnA 메소드
     *
     * @param selectNum - 조회할 게시판의 카테고리 넘버입니다.
     * @author 강도영
     */
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
            logInfo("글 작성을 취소합니다.");
        }
    }


    /**
     * QnA 게시판에 조회된 게시글을 상세조회하는 detailQnA 메소드
     *
     * @param selectDetailNum - 상세조회할 게시글의 넘버입니다.
     * @author 강도영
     */
    //QnA 게시글 상세조회하는 메소드
    public static void detailQnA(String selectDetailNum) {
        System.out.printf("--------------------------------------------------------------------------\n" +
                        "[제   목]\t" + qnAController.detailQnA(selectDetailNum).get(0).getPostTitle() + "\n" +
                        "[작 성 자]\t" + qnAController.detailQnA(selectDetailNum).get(0).getUsername() + "\n" +
                        "[작성시간]\t" + qnAController.detailQnA(selectDetailNum).get(0).getCreatedAt() + "\n" +
                        "[내   용]\t" + qnAController.detailQnA(selectDetailNum).get(0).getPostBody() + "\n" +
                        "----------------------------------------------------------------------------\n\n");
    }


    /**
     * QnA 게시판에 조회된 게시글을 삭제하는 deleteQnA 메소드
     *
     * @param selectDetailNum - 상세조회할 게시글의 넘버입니다.
     * @author 강도영
     */
    public static void deleteQnA(String selectDetailNum) {
        qnAController.deleteQnA(selectDetailNum);
        clearConsole();
        logInfo("해당 QnA 게시글을 삭제했습니다.\n\n");
    }


    /**
     * QnA 게시판에 조회된 게시글을 수정하는 updateQnA 메소드
     *
     * @param selectDetailNum - 상세조회할 게시글의 넘버입니다.
     * @author 강도영
     */
    public static void updateQnA(String selectDetailNum) {
        Scanner scanner = new Scanner(System.in);
        clearConsole();

        PostDto postDto = new PostDto();
        System.out.print("수정할 QnA 제목을 입력하세요 : ");
        String qnaTitleUpdate = scanner.nextLine();

        System.out.print("수정할 QnA 글 내용을 입력하세요 : ");
        String qnaBodyUpdate = scanner.nextLine();

        postDto.setPostTitle(qnaTitleUpdate);
        postDto.setPostBody(qnaBodyUpdate);

        clearConsole();

        System.out.println(postDto.getPostTitle());
        System.out.println(postDto.getPostBody());

        System.out.println("작성한 내용이 위와 같나요?");
        System.out.println("Y : 등록하기");
        System.out.println("B : 취소하기");
        String select = scanner.next();

        Long userId = loginUserContext.get(0).getUserNo();

        if(select.equals("Y")){
            qnAController.updateQnA(postDto, selectDetailNum);
        }
        if(select.equals("B")){
            logInfo("글 작성을 취소합니다.");
        }

        clearConsole();
        logInfo("해당 QnA 게시글을 수정하였습니다.\n\n");
    }
}
