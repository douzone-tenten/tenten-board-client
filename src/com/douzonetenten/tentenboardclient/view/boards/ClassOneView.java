package com.douzonetenten.tentenboardclient.view.boards;

import com.douzonetenten.tentenboardclient.controller.ClassOneController;
import com.douzonetenten.tentenboardclient.dto.JoinPostDto;
import com.douzonetenten.tentenboardclient.dto.PostDto;

import java.util.ArrayList;
import java.util.Scanner;

import static com.douzonetenten.tentenboardclient.service.UserService.loginUserContext;
import static com.douzonetenten.tentenboardclient.utils.ConsoleUtils.*;
import static com.douzonetenten.tentenboardclient.utils.UserInterfaceUtils.uiSelectMenu;
import static com.douzonetenten.tentenboardclient.utils.UserInterfaceUtils.uiTitle;


public class ClassOneView {
    ClassOneController classOneController = new ClassOneController();

    /**
     * 1반 게시판 뷰입니다.
     *
     * user table의 department가 1인 회원. 즉, 소속이 1반인 회원만 이용 가능한 게시판입니다.
     * 1반 게시판의 글 목록과 글을 조회하고 게시글 작성, 수정, 삭제가 가능합니다.
     *
     * @param selectNum - 조회할 게시판의 카테고리 번호입니다.
     * @author : 정수연
     */


    /**
     * 1반 게시판의 전체 게시글 조회입니다.
     *
     * @param selectNum - 조회할 게시판의 카테고리 번호입니다.
     * @author : 정수연
     */
    public void start(String selectNum) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            //CategoriesView에서 게시판을 선택할 때 입력한 숫자를 매개변수로 받아 선택한 게시판 목록을 저장한다.
            ArrayList<JoinPostDto> getClassOneList = ClassOneController.findByClassOne(selectNum);
            clearConsole();
            uiTitle("더존 1반 게시판");
            System.out.printf("--------------------------------\n" +
                    "게시글 번호      제목        작성자      작성시간\n" +
                    "--------------------------------\n");

            //게시글 목록 조회
            if (getClassOneList.isEmpty()) {
                logInfo("조회할 포스트가 없습니다.");
            }

            if (!(getClassOneList.isEmpty())) {
                //받아온 리스트를 joinPostDto에 담아 출력한다.
                for (JoinPostDto joinPostDto : getClassOneList) {
                    System.out.println(joinPostDto.findPostToString());
                }
            }

            uiSelectMenu();
            System.out.println("b. 뒤로가기 w. 글쓰기  d: 상세조회");
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

    /**
     * 게시글을 작성하는 메소드입니다.
     *
     * @param boardNo - 조회할 게시글의 번호입니다
     * @author : 정수연
     */
    public void insertPost(String boardNo){
        clearConsole();

        Scanner scanner = new Scanner(System.in);
        clearConsole();
        PostDto postDto = new PostDto();
        System.out.println("제목을 입력하세요 : ");
        String postTitle = scanner.nextLine();
        System.out.println("글 내용을 입력하세요.");
        String postBody = scanner.nextLine();
        //입력받은 내용 postDto에 저장
        postDto.setPostTitle(postTitle);
        postDto.setPostBody(postBody);
        clearConsole();
        System.out.println(postDto.getPostTitle());
        System.out.println(postDto.getPostBody());
        System.out.println("위 내용이 맞나요?");
        System.out.println("Y : 등록하기");
        System.out.println("B : 취소하기");

        String select = scanner.next();
        //등록하기 선택시 취소
        if (select.equals("Y") || select.equals("y")) {
            classOneController.insertPost(postDto, boardNo);
        }
        if (select.equals("B")) {
            logInfo("글 작성을 취소합니다.");
        }
    }

    /**
     * 게시글 상세 보기 입니다.
     *
     * @param selectNum - 조회할 게시판의 카테고리 넘버입니다.
     * @author : 정수연
     */
    private void detailPost(String selectNum) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("상세 조회할 게시글 번호를 입력해주세요.");
        String selectPost = scanner.next();
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
                editPost(selectPost); //글 번호 매개변수로 넘겨주기
            if(selectPostEditMenu.equalsIgnoreCase("d"))
                deletePost(selectPost);
            if(!(selectPostEditMenu.equalsIgnoreCase("e")||selectPostEditMenu.equalsIgnoreCase("d")||selectPostEditMenu.equalsIgnoreCase("b")))
                logWarn("잘못입력하셨습니다.");
        }
    }
    /**
     * 게시글 수정입니다.
     *
     * 현재 로그인 되어있는 아이디와 게시글 작성자를 비교해
     * 같으면 수정 가능 틀리면 불가능입니다.
     *
     * @param boardNo - 조회할 게시글의 번호입니다.
     * @author : 정수연
     */
    private void editPost(String boardNo) {
        //현재 로그인되어있는 정보에서 username(회원 아이디)을 변수에 저장
        String username = loginUserContext.get(0).getUsername();

        JoinPostDto joinPostDto = new JoinPostDto();
        ArrayList<JoinPostDto> getClassOneSelectPost = ClassOneController.detailPost(boardNo);
        String writername = getClassOneSelectPost.get(0).getUsername();

        Scanner scanner = new Scanner(System.in);
        //현재 로그인 username 현재 게시글 username이 같다면 수정
        if(username.equals(writername)){
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
            if (select.equalsIgnoreCase("Y")) {
                classOneController.editPost(postDto, boardNo);
            }
            if (select.equalsIgnoreCase("B")) {
                logInfo("글 작성을 취소합니다.");
            }
        }
        if(!(username.equals(writername))){
            logInfo("수정은 작성자 본인만 가능합니다.");
        }
    }

    /**
     * 게시글 삭제입니다.
     *
     * 현재 로그인 되어있는 아이디와 게시글 작성자를 비교해
     * 같으면 수정 가능 틀리면 불가능입니다.
     *
     * @param boardNo - 조회할 게시글의 번호입니다.
     * @author : 정수연
     */
    public void deletePost(String boardNo){
        String username = loginUserContext.get(0).getUsername();

        JoinPostDto joinPostDto = new JoinPostDto();
        ArrayList<JoinPostDto> getClassOneSelectPost = ClassOneController.detailPost(boardNo);
        String writername = getClassOneSelectPost.get(0).getUsername();

        if(username.equalsIgnoreCase(writername)){  //현재 로그인 username 현재 게시글 username이 같다면 삭제.
            ClassOneController.deletePost(boardNo);
        }
        if(!(username.equalsIgnoreCase(writername))){
            logInfo("삭제는 작성자 본인만 가능합니다.");
        }
    }
}
