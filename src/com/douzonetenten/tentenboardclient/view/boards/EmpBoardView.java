package com.douzonetenten.tentenboardclient.view.boards;

import com.douzonetenten.tentenboardclient.controller.PostController;
import com.douzonetenten.tentenboardclient.dto.BoardDto;
import com.douzonetenten.tentenboardclient.dto.JoinPostDto;
import com.douzonetenten.tentenboardclient.dto.PostDto;
import com.douzonetenten.tentenboardclient.dto.UserDto;
import com.douzonetenten.tentenboardclient.view.CategoriesView;

import java.util.ArrayList;
import java.util.Scanner;

import static com.douzonetenten.tentenboardclient.service.UserService.loginUserContext;
import static com.douzonetenten.tentenboardclient.utils.ConsoleUtils.clearConsole;
import static com.douzonetenten.tentenboardclient.utils.ConsoleUtils.logInfo;
import static com.douzonetenten.tentenboardclient.utils.UserInterfaceUtils.uiSelectMenu;
import static com.douzonetenten.tentenboardclient.utils.UserInterfaceUtils.uiTitle;
import static com.douzonetenten.tentenboardclient.view.boards.QnAView.qnAController;

public class EmpBoardView {
    static PostController postController = new PostController();
    PostDto postDto = new PostDto();
    UserDto userDto = new UserDto();
    BoardDto boardDto = new BoardDto();
    static CategoriesView categoriesView = new CategoriesView();

    public static void start(String selectNum) {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            ArrayList<JoinPostDto> getPostList = postController.findByPost(selectNum);
            clearConsole();
            uiTitle("직원용 게시판");
            System.out.printf("--------------------------------\n"
                    + "게시글 번호      제목        작성자      작성시간\n"
                    + "--------------------------------\n");

            /*게시글 목록 조회*/
            if (getPostList.isEmpty()) {
                System.out.println("조회할 포스트가 없습니다.");
            }


            if (!(getPostList.isEmpty())) {
                for (JoinPostDto joinPostDto : getPostList) {
                    System.out.println(joinPostDto.findPostToString());
                }
            }

            System.out.println("b.뒤로가기\t\tw.글쓰기\t\td.상세보기");
            uiSelectMenu();
            String selectPost = scanner.next();
            //뒤로가기
            if (selectPost.equals("b") || selectPost.equals("B")) {
                logInfo("뒤로 이동합니다.");
                categoriesView.start(); // 게시판 목록으로 돌아가기 (성필)
                //break;
            }
            //글쓰기
            if (selectPost.equals("w") || selectPost.equals("W")) {
                insertQnA(selectNum);
                clearConsole();
            }
            //상세보기
            if (selectPost.equals("d") || selectPost.equals("D")) {

                System.out.print("상세보기할 게시판의 번호를 입력해주세요. : ");
                String selectDetailNum = scanner.next();

                /**
                 * 로그인 한 객체가 작성한 게시글만 수정 및 삭제 가능하도록 상세조회에 나와있는 사용자 이름을 변수(ComLoginId)에 저장
                 * */
                String loginID = loginUserContext.get(0).getUsername();
                String ComLoginId = qnAController.detailQnA(selectDetailNum).get(0).getUsername();
                System.out.println(loginID);
                System.out.println(ComLoginId);

                clearConsole();
                detailQnA(selectDetailNum);
                while (true) {
                    System.out.println("b. 뒤로가기\t\tu. 수정하기\t\te. 삭제하기");
                    System.out.print("해당 게시글에 대한 메뉴를 선택하세요 : ");
                    String selectUENum = scanner.next();

                    if (selectUENum.equals("u") || selectUENum.equals("U")) {
                        if (loginID.equals(ComLoginId)) {
                            updateQnA(selectDetailNum);
                            clearConsole();
                            logInfo("해당 게시글을 수정했습니다.\n");
                            detailQnA(selectDetailNum);
                            continue;
                        } else {
                            clearConsole();
                            logInfo("게시글 작성자만 수정가능합니다.\n");
                            detailQnA(selectDetailNum);
                            continue;
                        }
                    }


                    if (selectUENum.equals("e") || selectUENum.equals("E")) {
                        if (loginID.equals(ComLoginId)) {
                            deleteQnA(selectDetailNum);
                            clearConsole();
                            logInfo("해당 게시글을 삭제했습니다.\n");
                            break;
                        } else {
                            clearConsole();
                            logInfo("게시글 작성자만 삭제가능합니다.\n");
                            detailQnA(selectDetailNum);
                            continue;
                        }
                    }

                    if (selectUENum.equals("b") || selectUENum.equals("B")) {
                        clearConsole();
                        start("7"); // 게시글 목록 보기로 돌아가기(성필)
                        //break;
                    }

                }
            }


        }
    }

    public static void insertQnA(String selectNum) {
        Scanner scanner = new Scanner(System.in);
        clearConsole();

        PostDto postDto = new PostDto();
        System.out.print("게시글 제목을 입력하세요 : ");
        String Title = scanner.nextLine();

        System.out.print("글 내용을 입력하세요 : ");
        String Body = scanner.nextLine();

        postDto.setPostTitle(Title);
        postDto.setPostBody(Body);

        clearConsole();

        System.out.println(postDto.getPostTitle());
        System.out.println(postDto.getPostBody());

        System.out.println("작성한 내용이 위와 같나요?");
        System.out.println("Y : 등록하기");
        System.out.println("B : 취소하기");
        String select = scanner.next();
        Long userId = loginUserContext.get(0).getUserNo();

        if (select.equals("Y") || select.equals("y")) {
            qnAController.insertQnA(postDto, userId, selectNum);
        }
        if (select.equals("B") || select.equals("b")) {
            logInfo("글 작성을 취소합니다.");
        }
    }

    //글제목 작성자 작성시간 글내용
    //게시글 상세조회
    public static void detailQnA(String selectDetailNum) {
        System.out.printf("--------------------------------------------------------------------------\n" +
                "[제\t\t목]\t" + qnAController.detailQnA(selectDetailNum).get(0).getPostTitle() + "\n" +
                "[작\t\t성\t\t자]\t" + qnAController.detailQnA(selectDetailNum).get(0).getUsername() + "\n" +
                "[작\t성\t시\t간]\t" + qnAController.detailQnA(selectDetailNum).get(0).getCreatedAt() + "\n" +
                "[내\t\t\t용]\n" + qnAController.detailQnA(selectDetailNum).get(0).getPostBody() + "\n" +
                "----------------------------------------------------------------------------\n\n");
    }


    //게시글 삭제
    public static void deleteQnA(String selectDetailNum) { // 한번 더 물어보기 추가
        Scanner scanner = new Scanner(System.in);
        System.out.println("정말로 삭제하시겠습니까? (Y/N)");
        String answer = scanner.next();

        if (answer.equals("Y") || answer.equals("y")) {
            qnAController.deleteQnA(selectDetailNum);
            clearConsole();
            logInfo("해당 게시글을 삭제했습니다.\n\n"); // 보이지않는 문제
        }
//        else if (answer.equals("N") || answer.equals("n")){
//            clearConsole();
//            logInfo("삭제가 취소되었습니다.\n\n");
//        } else {
//            System.out.println("잘못 입력하셨습니다."); // 그냥 목록으로 돌아감
//        }


    }


    //게시글 수정
    public static void updateQnA(String selectDetailNum) {
        Scanner scanner = new Scanner(System.in);
        clearConsole();

        PostDto postDto = new PostDto();
        System.out.print("수정할 제목을 입력하세요 : ");
        String qnaTitleUpdate = scanner.nextLine();

        System.out.print("수정할 글 내용을 입력하세요 : ");
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

        if (select.equals("Y") || select.equals("y")) {
            qnAController.updateQnA(postDto, selectDetailNum);
        }
        if (select.equals("B") || select.equals("b")) {
            logInfo("글 작성을 취소합니다.");
        }

        clearConsole();
        logInfo("해당 게시글을 수정하였습니다.\n\n");
    }
}

//        /* 게시글 삭제 (DELETE) */
//        if ( move == "d" ) {
//            System.out.println("정말 게시물을 삭제하시겠습니까? (Y/N)");
//            char ans = scanner.next().charAt(0);
//            if ( ans == 'y' || ans == 'Y') {
//                postController.deletePost(selectPost); // selectPost 변수 재활용
//            } else if ( ans == 'n' || ans == 'N' ) {
//                System.out.println("게시물이 삭제되지 않았습니다.");
//            } else {
//                System.out.println("유효하지 않은 입력입니다. 다시 입력해주세요."); // 반복문으로 수정해야 질문으로 돌아갈 듯
//            }
//        }
//
//        // 메소드 선언 및 호출에서 모르겠음
//        public static void insertPost() { /* 글쓰기 메소드 */
//            Display.clearConsole();
//            Display.displayTitle("글쓰기");
//
//            postDto.setUserNo(userDto.getUserNo()); // 로그인한 회원의 넘버 가져옴
//            postDto.setBoardNo(boardDto.getBoardNo()); // 직원용 게시판 넘버 강제 셋팅
//
//            System.out.println("글 제목을 입력하세요.");
//            postDto.setPostTitle(scanner.nextLine());
//            System.out.println("글 내용을 입력하세요.");
//            postDto.setPostBody(scanner.nextLine());
//
//            int result = postController.insertPost(postDto, ); // 매개변수....뭐지
//
//            if (result == 1) {
//                System.out.println("게시글이 작성되었습니다.");
//            }
//        }
//         b. 뒤로가기, e. 게시글 수정, d. 게시글 삭제
//            String move = scanner.next();
//            if (move == "b") {
//                start("6"); // 뒤로가기 ( start 메소드 실행 )
//        // 6번 게시글 조회를 어떻게 할것인가? 입력받은 숫자 == post_id
//        /* 게시글 상세조회 (READ) */
//        for (JoinPostDto joinPostDto : getPostList) {
//        if (Long.parseLong(selectPost) == joinPostDto.getPostId()) {
//        Display.clearConsole();
//        Display.displayTitle("게시글 상세조회");
//        System.out.println(joinPostDto.detailPostToString());
//        } else {
//        System.out.println("선택하신 번호의 게시글은 없습니다. 다시 선택해주세요.");
//        }
//        }