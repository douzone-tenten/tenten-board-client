package com.douzonetenten.tentenboardclient.view.boards;

import com.douzonetenten.tentenboardclient.controller.NoticeController;
import com.douzonetenten.tentenboardclient.controller.PostController;
import com.douzonetenten.tentenboardclient.dto.JoinPostDto;
import com.douzonetenten.tentenboardclient.dto.Notice_JoinPostDto;
import com.douzonetenten.tentenboardclient.dto.PostDto;
import com.douzonetenten.tentenboardclient.view.PostView;

import java.util.ArrayList;
import java.util.Scanner;

import static com.douzonetenten.tentenboardclient.utils.ConsoleUtils.clearConsole;

/**
 * 공지사항 게시판 클래스입니다.
 * Author : 김승혁
 */
public class NoticeView {
    private PostView postwiew = new PostView();

    /**
     * 스케너를 선언하는 메서드
     * @author 김승혁
     */
    private Scanner sc = new Scanner(System.in);


    /**
     * @param  String login_user_role= loginUserContext.get(0).getRoleNo().toString();
     *        -글쓰기 권한 제어(관리자만 글쓰기 가능)
     * @author 김승혁
     */
//    String login_user_role= loginUserContext.get(0).getRoleNo().toString();



    public void start(String selectNum) {
        Scanner sc = new Scanner(System.in);
        ArrayList<JoinPostDto> getPostList = PostController.findByPost(selectNum);

        /**
         * @param  while문 사용
         *        -break;를 만날 때 까지 무한으로 반복(System.out.println()의 내용을 반복해서 출력함)
         * @author 김승혁
         */
        while (true) {
            System.out.println("공지사항 게시판");
            System.out.printf("-----------------------------------------------\n" +
                    "게시글 번호       제목          작성자        작성시간\n" +
                    "-----------------------------------------------\n");

            /**
             * 게시글 목록 조회
             * @author 김승혁
             */
            if (getPostList.isEmpty()) {
                System.out.println("조회할 포스트가 없습니다.");
            }

            if (!(getPostList.isEmpty())) {
                for (JoinPostDto joinPostDto : getPostList) {
                    System.out.println(joinPostDto.findPostToString());
                }
            }

            /**
             * 메뉴 선택(b, s, w 중 선택하여 입력하면 그에 맞는 if문이 실행되는 알고리즘
             * ||(OR)을 사용하여 둘 중 하나라도 입력되면 if문이 실행되도록 설계
             * @author 김승혁
             */
            System.out.println("b.뒤로가기   s.공지사항 상세 조회    w.글쓰기");

            char a = sc.next().charAt(0);

            if (a == 'w' || a == 'W') {
                insertPost();
                break;
            }
            if (a == 's' || a == 'S') {
                detail(selectNum);
                break;
            }
            if (a == 'b' || a == 'B') {
                break;
            }
        }
    }




    //상세 조회 기능 구현
    public void detail(String selectNum) {
        NoticeController noticeController = new NoticeController();
        System.out.println("상세조회할 게시글 번호를 입력하세요 : ");
        int select = sc.nextInt();
        ArrayList<Notice_JoinPostDto> notice_list = noticeController.FindByAll(select);

        // ArrayList<Notice_JoinPostDto> notice = noticeController.FindByAll(select);

        for (Notice_JoinPostDto njp : notice_list) {
            System.out.println(njp.toString());
        }

        System.out.println(" b.뒤로 가기       u.게시글 수정       d.게시글 삭제 ");
        char ch = sc.next().charAt(0);
        if (ch == 'u' || ch == 'U') {
            update(select);
        }

        if (ch == 'd' || ch == 'D'){
            SubDelete(select);
        }

 /*             여러 가지 방법으로 시대(실패)
                if (answer2 == 'u' || answer2 == 'U'){

                Notice_JoinPostDto noticeJoinPostDto = new Notice_JoinPostDto();

                System.out.print("제목을 입력하세요 : ");
                String postTitle = sc.nextLine();
                sc.nextLine();
                System.out.print("글 내용을 입력하세요.");
                String postBody = sc.nextLine();
                noticeJoinPostDto.setPost_title(postTitle);
                noticeJoinPostDto.setPost_body(postBody);
                clearConsole();
                System.out.println(noticeJoinPostDto.getPost_title());
                System.out.println(noticeJoinPostDto.getPost_body());
                System.out.println("위 내용이 맞나요?");
                System.out.println("Y : 등록하기");
                System.out.println("B : 취소하기");

                char ch = sc.next().charAt(0);
                // TODO : 예외처리
                if (ch == 'Y' || ch == 'y') {

                    System.out.println("작성한 글이 등록되었습니다.");
                    noticeController.update(selectNum);
                }
                if (ch == 'B' ) {
                    System.out.println("글 작성을 취소합니다.");
                }

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


            }*/

        }

    /**
     * 스케너를 이용하여 공지사항의 제목과 내용을 입력받아 출력하고 DB에 저장하는 메서드
     * @author 김승혁
     */
        //글쓰기 기능 구현
        public void insertPost () {

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


    /**
     * 스케너를 이용하여 공지사항을 상세 조회한 게시글을 또 한번 스케너를 이용해 게시글을 삭제하는 메서드
     * @author 김승혁
     */
        public void SubDelete(int postId){
            NoticeController noticeController = new NoticeController();
            System.out.println("선택한 게시글을 삭제하겠습니까? (y/n)");
            char a = sc.next().charAt(0);

            if (a == 'y' || a == 'Y') {
                int result = noticeController.SubDelete(postId);
                if (result > 0) {
                    System.out.println("선택한 게시글 삭제가 완료 되었습니다.");

                } else {
                    System.out.println("본인이 작성한 게시글만 삭제할 수 있습니다.");
                }

            } else if (a == 'N' || a == 'n') {
                System.out.println("게시글 삭제 취소");
            }
        }


    /**
     * 스케너를 이용하여 상세 조회한 게시글을 또 한번 스캐너를 이용해 공지사항을 수정하는 메서드
     * @author 김승혁
     */
        public void update(int postId) {
            NoticeController noticeController = new NoticeController();
            String up = sc.nextLine();
            System.out.println("====================================================");
            Notice_JoinPostDto noticeJoinPostDto = new Notice_JoinPostDto();

            ArrayList<Notice_JoinPostDto> notice_joinPostDtoArrayList = new ArrayList<Notice_JoinPostDto>();

            System.out.println("제목을 수정해주세요 : ");
            String test = sc.nextLine();
            System.out.println("글 내용을 수정해주세요 : ");
            String body = sc.nextLine();

            noticeJoinPostDto.setPost_title(test);
            noticeJoinPostDto.setPost_body(body);
            int result = noticeController.update(postId,test,body);
            if (result > 0) {
                System.out.println("게시글 수정을 성공했습니다.");
            } else {
                System.out.println("본인이 작성한 게시글만 수정할 수 있습니다.");
            }


                clearConsole();
                System.out.println(noticeJoinPostDto.getPost_title());
                System.out.println(noticeJoinPostDto.getPost_body());
                System.out.println("위 내용이 맞나요?");
                System.out.println("Y : 등록하기");
                System.out.println("B : 취소하기");


                String num = sc.next();
                // TODO : 예외처리
                if (num.equals("Y") || num.equals("y")) {
                    if (result > 0) {
                        System.out.println("작성한 글이 등록되었습니다.");

                    } else {
                        System.out.println("본인이 작성한 게시글만 수정,삭제할 수 있습니다.");
                    }

                }
                if (num.equals("B")) {
                    System.out.println("글 작성을 취소합니다.");
                }

            }
        }

