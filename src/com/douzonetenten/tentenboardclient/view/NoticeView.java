package com.douzonetenten.tentenboardclient.view;

import com.douzonetenten.tentenboardclient.controller.NoticeController;
import com.douzonetenten.tentenboardclient.controller.PostController;
import com.douzonetenten.tentenboardclient.dto.JoinPostDto;
import com.douzonetenten.tentenboardclient.dto.Notice_JoinPostDto;
import com.douzonetenten.tentenboardclient.dto.PostDto;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 공지사항 게시판 클래스입니다.
 * Author : 김승혁
 */
public class NoticeView {
    private PostView postwiew = new PostView();
    private Scanner sc = new Scanner(System.in);

    public void start(String selectNum) {
        Scanner sc = new Scanner(System.in);
        ArrayList<JoinPostDto> getPostList = PostController.findByPost(selectNum);

        while (true) {
            System.out.println("공지사항 게시판");
            System.out.printf("-----------------------------------------------\n" +
                    "게시글 번호       제목          작성자        작성시간\n" +
                    "-----------------------------------------------\n");

            // 게시글 목록 조회
            if (getPostList.isEmpty()) {
                System.out.println("조회할 포스트가 없습니다.");
            }

            if (!(getPostList.isEmpty())) {
                for (JoinPostDto joinPostDto : getPostList) {
                    System.out.println(joinPostDto.findPostToString());
                }
            }

            //메뉴 선택
            System.out.println("b.뒤로가기  n.다음 페이지  f.이전 페이지   s.공지사항 상세 조회    w.글쓰기");

            char a = sc.next().charAt(0);

            if (a == 'w' || a == 'W') {
                insertPost();
            }
            if (a == 's' || a == 'S') {
                detail();
            }
            if(a == 'b' || a == 'B'){
                break;
            }
        }
    }




    // TODO: 2022-08-17 게시글 상세 조회

        public void detail(){
            NoticeController noticeController = new NoticeController();
            System.out.println("상세조회할 게시글 번호를 입력하세요 : ");
            long select = sc.nextLong();
            ArrayList<Notice_JoinPostDto> notice_list = noticeController.FindByAll(select);

            // ArrayList<Notice_JoinPostDto> notice = noticeController.FindByAll(select);

                    for(Notice_JoinPostDto njp :  notice_list ){
                        System.out.println(njp.toString());
                    }

            System.out.println(" b.뒤로 가기       u.게시글 수정       d.게시글 삭제 ");
            char answer2 = sc.next().charAt(0);

            if (answer2 == 'u' || answer2 == 'U'){

            }

            if (answer2 == 'd' || answer2 == 'D') {
                System.out.println("정말 공지사항을 삭제하시겠습니까??");
                System.out.println("Y : 삭제하기");
                System.out.println("N : 삭제 취소하기");
                char answer3 = sc.next().charAt(0);


                if(answer3 == 'y' || answer3 == 'Y'){
                    PostController.deletePost(String.valueOf(select));
                    System.out.println("정상적으로 공지사항이 정상적으로 삭제되었습니다.");
                } else if (answer3 == 'n' || answer3 == 'N') {
                    System.out.println("공지사항 삭제하기가 취소되었습니다.");

                }else {
                    System.out.println("잘못 입력하셨습니다.");
                }


            }

        }


        //글쓰기 기능 구현
        public void insertPost() {

            PostDto postDto = new PostDto();
            System.out.println("공지사항의 제목을 입력하세요 : ");
            String postTitle = sc.nextLine();
            System.out.println("");
            System.out.println("공지사항의 내용을 입력하세요 : ");
            String postBody = sc.nextLine();
            postDto.setPostTitle(postTitle);
            postDto.setPostBody(postBody);
            System.out.println("제목 : " + postDto.getPostTitle());
            System.out.println("내용 : " + postDto.getPostBody());
            System.out.println("위 내용이 맞나요?");
            System.out.println("Y : 등록하기");
            System.out.println("N : 취소하기");
            char answer = sc.next().charAt(0);


            if (answer == 'Y' || answer == 'y') {
                PostController.insertPost(postDto, "2");
                System.out.println("공지사항이 정상적으로 등록되었습니다.");
            } else if (answer == 'N' || answer == 'n') {
                System.out.println("글 작성을 취소합니다.");
            } else {
                System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
            }

        }

}


//    String pno = sc.next();
//                PostController.deletePost(pno);