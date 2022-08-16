package com.douzonetenten.tentenboardclient.view;

import com.douzonetenten.tentenboardclient.controller.DouZoneTwoController;
import com.douzonetenten.tentenboardclient.controller.PostController;
import com.douzonetenten.tentenboardclient.dto.BoardDto;
import com.douzonetenten.tentenboardclient.dto.DouZoneTwoJoinDto;
import com.douzonetenten.tentenboardclient.dto.JoinPostDto;
import com.douzonetenten.tentenboardclient.dto.PostDto;

import java.util.ArrayList;
import java.util.Scanner;

import static com.douzonetenten.tentenboardclient.view.feature.Display.clearConsole;

public class DouZoneTwoView {

    private Scanner sc = new Scanner(System.in);
    private DouZoneTwoController douZoneTwoController = new DouZoneTwoController();
    private PostController postController = new PostController();
    private DouZoneTwoJoinDto douZoneTwoJoinDto = new DouZoneTwoJoinDto();

    public void dztwostart(String selectNum) {

        System.out.println("더존 2반 게시판");
//        System.out.println("------------------------------");
        System.out.printf("--------------------------------------------\n" +
                "게시글 번호      제목        작성자      작성시간\n" +
                "--------------------------------------------\n");

        ArrayList<DouZoneTwoJoinDto> boardDtoArrayList = douZoneTwoController.douzoneFindByAll(selectNum);

        if (boardDtoArrayList.isEmpty()) {
            System.out.println("조회할 포스트가 없습니다.");
        }

        if (!(boardDtoArrayList.isEmpty())) {
            for (DouZoneTwoJoinDto douZoneTwoJoinDto : boardDtoArrayList) {
                System.out.println(douZoneTwoJoinDto.toString());

//        }
            }


            System.out.println("원하는 메뉴를 선택하세요");
            System.out.println("b. 뒤로 가기    n. 다음 페이지     f. 이전 페이지      w. 글쓰기");
            dztwoinsert();
        }
    }


    public void dztwoinsert() {

        char answer = sc.nextLine().charAt(0);
        PostDto postDto = new PostDto();
        if (answer == 'w' || answer == 'W') {

            System.out.print("제목을 입력하세요 : ");
            String douzone_postTitle = sc.nextLine();
            System.out.print("글 내용을 입력하세요.");
            String douzone_postBody = sc.nextLine();
            postDto.setPostTitle(douzone_postTitle);
            postDto.setPostBody(douzone_postBody);
            clearConsole();
            System.out.println(postDto.getPostTitle());
            System.out.println(postDto.getPostBody());
            System.out.println("위 내용이 맞나요?");
            System.out.println("Y : 등록하기");
            System.out.println("B : 취소하기");

        }

        String select = sc.next();
        // TODO : 예외처리
        if (select.equals("Y") || select.equals("y")) {
            // TODO : 게시판 번호 조회를 어떻게 할 것인가?
            System.out.println("작성한 글이 등록되었습니다.");
            douZoneTwoController.dozoneTwoInsert(postDto, "7");
        }
        if (select.equals("B")) {
            System.out.println("글 작성을 취소합니다.");
        }


    }
}



