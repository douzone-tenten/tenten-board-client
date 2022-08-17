package com.douzonetenten.tentenboardclient.view.boards;

import com.douzonetenten.tentenboardclient.controller.ClassTwoController;
import com.douzonetenten.tentenboardclient.controller.PostController;
import com.douzonetenten.tentenboardclient.dto.ClassTwoJoinDto;
import com.douzonetenten.tentenboardclient.dto.JoinPostDto;
import com.douzonetenten.tentenboardclient.dto.PostDto;

import java.util.ArrayList;
import java.util.Scanner;

import static com.douzonetenten.tentenboardclient.utils.ConsoleUtils.clearConsole;

public class ClassTwoView {

    private Scanner sc = new Scanner(System.in);
    private ClassTwoController douZoneTwoController = new ClassTwoController();
    private PostController postController = new PostController();
    private ClassTwoJoinDto douZoneTwoJoinDto = new ClassTwoJoinDto();

    public void dztwostart(String selectNum) {

        System.out.println("더존 2반 게시판");
//        System.out.println("------------------------------");
        System.out.printf("--------------------------------------------\n" +
                "게시글 번호      제목        작성자      작성시간\n" +
                "--------------------------------------------\n");

        ArrayList<ClassTwoJoinDto> boardDtoArrayList = douZoneTwoController.douzoneFindByAll(selectNum);

        if (boardDtoArrayList.isEmpty()) {
            System.out.println("조회할 포스트가 없습니다.");
        }

        if (!(boardDtoArrayList.isEmpty())) {
            for (ClassTwoJoinDto douZoneTwoJoinDto : boardDtoArrayList)
                System.out.println(douZoneTwoJoinDto.toString());

//        }

        }

            System.out.println("원하는 메뉴를 선택하세요");
            System.out.print("b. 뒤로 가기    n. 다음 페이지     f. 이전 페이지   r.상세조회   w. 글쓰기");
            String answer = sc.nextLine();
            if (answer.equals("w") || answer.equals("W")) {
                dztwoinsert();
            }
            if (answer.equals("r")  || answer.equals("R")){
                System.out.println("상세조회할 게시글 번호를 입력하세요 : ");
                int detail = sc.nextInt();
                dztwodetailselect(detail);
            }


        }


    public void dztwodetailselect(int port_id){

        ArrayList<JoinPostDto> boardDtoArrayList = douZoneTwoController.douzoneTwoDetailSelect(port_id);
        for (JoinPostDto joinPostDto : boardDtoArrayList){
            System.out.println(joinPostDto.detailPostToString());
        }

    }






    public void dztwoinsert() {

//        char answer = sc.nextLine().charAt(0);
        PostDto postDto = new PostDto();
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



        String select = sc.next();
        // TODO : 예외처리
        if (select.equals("Y") || select.equals("y")) {
            // TODO : 게시판 번호 조회를 어떻게 할 것인가?
            System.out.println("작성한 글이 등록되었습니다.");
            douZoneTwoController.dozoneTwoInsert(postDto, "5");
        }
        if (select.equals("B")) {
            System.out.println("글 작성을 취소합니다.");
        }


    }
}



