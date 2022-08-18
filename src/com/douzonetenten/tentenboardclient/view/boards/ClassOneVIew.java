package com.douzonetenten.tentenboardclient.view.boards;

import com.douzonetenten.tentenboardclient.controller.ClassOneController;
import com.douzonetenten.tentenboardclient.dao.UserDao;
import com.douzonetenten.tentenboardclient.dto.JoinPostDto;
import com.douzonetenten.tentenboardclient.dto.PostDto;
import com.douzonetenten.tentenboardclient.dto.UserDto;
import com.douzonetenten.tentenboardclient.service.UserService;
import com.douzonetenten.tentenboardclient.view.LoginMainView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.douzonetenten.tentenboardclient.service.UserService.loginUserContext;
import static com.douzonetenten.tentenboardclient.utils.ConsoleUtils.*;
import static com.douzonetenten.tentenboardclient.utils.UserInterfaceUtils.uiSelectMenu;
import static com.douzonetenten.tentenboardclient.utils.UserInterfaceUtils.uiTitle;
/**
 * 1반 게시판 클래스
 * Author : 정수연
 */
public class ClassOneVIew {
    ClassOneController classOneController = new ClassOneController();
    public void start(String selectNum) { //목록 조회
        Scanner scanner = new Scanner(System.in);
        while (true){
            ArrayList<JoinPostDto> getClassOneList = ClassOneController.findByClassOne(selectNum);

            uiTitle("더존 1반 게시판");
            System.out.printf("--------------------------------\n" +
                    "게시글 번호      제목        작성자      작성시간\n" +
                    "--------------------------------\n");

            //게시글 목록 조회
            if (getClassOneList.isEmpty()) {
                logInfo("조회할 포스트가 없습니다.");
            }
            if (!(getClassOneList.isEmpty())) {
                for (JoinPostDto joinPostDto : getClassOneList) {
                    System.out.println(joinPostDto.findPostToString());
                }
            }

            uiSelectMenu();
            // TODO : 메뉴 선택 공통컴포넌트
            System.out.println("b. 뒤로가기  n. 다음페이지   f. 이전 페이지   w. 글쓰기  d: 상세조회");
            String selectPost = scanner.next();

            //예외처리
            if (!(selectPost.equalsIgnoreCase("b") || selectPost.equalsIgnoreCase("n") || selectPost.equalsIgnoreCase("f") || selectPost.equalsIgnoreCase("w") || selectPost.equalsIgnoreCase("d"))) {
                logError("메뉴를 잘못 입력하셨습니다.");
            }

            //뒤로가기
            if (selectPost.equalsIgnoreCase("b")) {
                break;
            }

            //글쓰기
            if (selectPost.equalsIgnoreCase("w")) {
                insertPost(selectNum);
            }

            //상세조회
            if (selectPost.equalsIgnoreCase("d")) {
                detailPost(selectNum);
            }

        }
    }

    public void insertPost(String boardNo){ //게시글 작성
        clearConsole();

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
            classOneController.insertPost(postDto, boardNo);
        }
        if (select.equals("B")) {
            System.out.println("글 작성을 취소합니다.");
        }
    }

    private void detailPost(String boardNo) {//게시글 상세 보기
        Scanner scanner = new Scanner(System.in);
        System.out.println("글 내용을 보고싶은 포스트 번호를 입력해주세요.");
        String selectPost = scanner.next();
        //Class1Controller.detailPost(selectPost);
        ArrayList<JoinPostDto> getClassOneSelectPost = ClassOneController.detailPost(selectPost);


        if (getClassOneSelectPost.isEmpty()) {
            logInfo("포스트가 삭제되었거나 존재하지않습니다.");
        }
        if (!(getClassOneSelectPost.isEmpty())) {
            for (JoinPostDto joinPostDto : getClassOneSelectPost) {
                System.out.println(joinPostDto.findSelectDetailPostToString());
            }
            System.out.println();
            System.out.println("e. 게시글 수정   d. 게시글 삭제   b. 뒤로 가기");
            String selectPostEditMenu = scanner.next();
            if (selectPostEditMenu.equalsIgnoreCase("e"))
                editPost(selectPost); //포스트 번호 넘겨주기
            if(selectPostEditMenu.equalsIgnoreCase("d"))
                deletePost(selectPost); //포스트 번호 넘겨주기
//            if(selectPostEditMenu.equalsIgnoreCase("b"))
//                //어케하지..while..음.. //TODO : 수연 뒤로 가기..어케..while을 어디에...
            if(!(selectPostEditMenu.equalsIgnoreCase("e")||selectPostEditMenu.equalsIgnoreCase("d")||selectPostEditMenu.equalsIgnoreCase("b")))
                logWarn("잘못입력하셨습니다.");

        }
    }
    private void editPost(String boardNo) {
        String username = loginUserContext.get(0).getUsername();

        JoinPostDto joinPostDto = new JoinPostDto();
        ArrayList<JoinPostDto> getClassOneSelectPost = ClassOneController.detailPost(boardNo);
        String writername = getClassOneSelectPost.get(0).getUsername();

        Scanner scanner = new Scanner(System.in);

        if(username.equals(writername)){  //현재 로그인 username 현재 게시글 username이 같다면 수정
            
            /*작성중*/
            PostDto postDto = new PostDto();
            System.out.println("수정할 제목을 입력하세요 : ");
            String postTitle = scanner.nextLine();
            System.out.println("수정할 내용을 입력하세요.");
            String postBody = scanner.nextLine();
            postDto.setPostTitle(postTitle);
            postDto.setPostBody(postBody);
            System.out.println(postDto.getPostTitle());
            System.out.println(postDto.getPostBody());
            System.out.println("위 내용이 맞나요?");
            System.out.println("Y : 수정하기");
            System.out.println("B : 취소하기");

            String select = scanner.next();
            // TODO : 예외처리
            if (select.equalsIgnoreCase("Y")) {
                classOneController.editPost(postDto, boardNo);
            }
            if (select.equalsIgnoreCase("B")) {
                System.out.println("글 작성을 취소합니다.");
            }
            /*작성중*/
        }
        if(!(username.equals(writername))){
            logInfo("수정은 작성자 본인만 가능합니다.");
        }
    }

    public void deletePost(String boardNo){ //게시글 삭제
        String username = loginUserContext.get(0).getUsername();

        JoinPostDto joinPostDto = new JoinPostDto();
        ArrayList<JoinPostDto> getClassOneSelectPost = ClassOneController.detailPost(boardNo);
        String writername = getClassOneSelectPost.get(0).getUsername();

        System.out.println("작성자 이름" + writername);
        if(username.equalsIgnoreCase(writername)){  //현재 로그인 username 현재 게시글 username이 같다면 삭제.
            ClassOneController.deletePost(boardNo);
        }
        if(!(username.equalsIgnoreCase(writername))){
            logInfo("삭제는 작성자 본인만 가능합니다.");
        }
    }
}
