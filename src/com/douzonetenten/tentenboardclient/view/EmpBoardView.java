package com.douzonetenten.tentenboardclient.view;



import java.util.Scanner;

public class EmpBoardView {

    // EmpBoardController 객체 생성
    //EmpBoardController empBoardController = new empBoardController();

    private Scanner sc = new Scanner(System.in);

    public void readEmpBoard {

        System.out.println(" 담당자 게시판 ");
        System.out.println("-----------------------------------------------");
        System.out.println("게시글 번호  제목            작성자      작성시간 ");
        System.out.println("-----------------------------------------------");
        // 게시글 번호 제일 큰 게시물부터 5개 출력 ( post_id, post_title, username, created_at )
        // 조건 : board_board_no가 직원용 게시판이어야 한다.
//        select post_id,
//                post_title,
//                u.username,
//                created_at
//        from post p
//        left join user into p.user_member_no = u.member_no
//        order by post_id desc; 5개씩, 페이지 옮기며 다른 글이 보이게 어떻게 할까?

        // 조회할 게시글 번호 입력 시 게시글로 이동

        // b. 뒤로가기, n. 다음 페이지, f. 이전 페이지, w. 글쓰기로 이동

        // 게시글 상세조회는 공통으로 하나의 메소드로 가능하지 않을까? ( + 작성, 수정, 삭제 )
        // board_no, member_no, post_id 불러와서 매칭시킨 후 post_title과 post_body 출력!

        //PostController postController = new PostController(); // 작성, 수정, 삭제를 위한 컨트롤 객체 생성


    }
}
