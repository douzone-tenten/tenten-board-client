package com.douzonetenten.tentenboardclient.view.boards;

import com.douzonetenten.tentenboardclient.controller.AnonymousController;
import com.douzonetenten.tentenboardclient.controller.PostController;
import com.douzonetenten.tentenboardclient.dto.JoinPostDto;
import com.douzonetenten.tentenboardclient.dto.PostDto;
import com.douzonetenten.tentenboardclient.view.PostView;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import static com.douzonetenten.tentenboardclient.service.UserService.loginUserContext;
import static com.douzonetenten.tentenboardclient.utils.ConsoleUtils.*;
import static com.douzonetenten.tentenboardclient.utils.UserInterfaceUtils.*;

/**
 * 익명 게시판 클래스입니다.
 * Author : 김성안
 */
public class AnonymousView {
    private  AnonymousController anonymousController= new AnonymousController();
    private PostController postController = new PostController();
    private PostView postView = new PostView();
    private Scanner scanner = new Scanner(System.in);

    // IndexOutOfBoundsException 오류 발생
    //public String login_user_no = loginUserContext.get(0).getUserNo().toString();
    public void start(String selectNum) {


        while (true) {
            // 게시글 등록 후 게시글 목록 최신화를 위해 while문 안으로 이동함
            // getPostList= 익명게시글 전부 조회
            ArrayList<JoinPostDto> getPostList = postController.findByPost(selectNum);

            // 로그인한 객체에서 user_id 추출
            String login_user_no = loginUserContext.get(0).getUserNo().toString();



            // 로그인한 유저의 게시글만 보일 수 있도록 출력
            // login_user_no = 로그인 한 객체의 user_no ,  selectNum = 접속한 게시판 번호
            // getPostList2
            ArrayList<JoinPostDto> getPostList2 =postController.findSameUserByPost(login_user_no, selectNum);

            uiTitle("익명게시판");


            uiPostCatagory();

            // 게시글 목록 조회
            // 접속한 게시판번호와 일치하는 게시글이 없을 시
            if (getPostList.isEmpty()) {
                logWarn("익명게시판에 작성된 게시글이 없습니다.");
            }
            // 접속한 게시판번호와 일치하는 게시글이 있을 시
            if (!(getPostList.isEmpty())) {
                for (JoinPostDto joinPostDto : getPostList) {
                    System.out.println(joinPostDto.findAnonymousToString());
                }
            }
            System.out.println("");
            System.out.println("====================================================");


            uiPostCatagory();

            // 로그인한 객체에서 username 추출
            String login_userName = loginUserContext.get(0).getUsername().toString();

            if (getPostList2.isEmpty()) {
                logWarn(login_userName+"님이 작성한 게시글이 없습니다.");
            }
            // 접속한 게시판번호와 일치하는 게시글이 있을 시
            if (!(getPostList2.isEmpty())) {
                logInfo(login_userName+"님이 작성한 게시글 목록입니다.");
                for (JoinPostDto joinPostDto : getPostList2) {
                    System.out.println(joinPostDto.findPostToString());
                }
            }

            uiSelectMenu();

            //TODO 하단 메뉴 공통 컨포넌트화
            //postView.footerMenu(selectNum);   // => 뒤로가기 기능 다시 구상 필요 break;

            System.out.println("b. 뒤로가기  w. 글쓰기  d: 상세조회");
            String selectPostMenu1 = scanner.next();

            /**
             * 예외처리
             */
            if (!(selectPostMenu1.equals("b") || selectPostMenu1.equals("w") || selectPostMenu1.equals("d"))) {
                logError("메뉴를 잘못 입력하셨습니다.");
            }
            /**
             * 뒤로가기
             */
            if (selectPostMenu1.equals("b") || selectPostMenu1.equals("B")) {
                break;
            }
            if (selectPostMenu1.equals("w") || selectPostMenu1.equals("W")) {
                postView.insertPost(selectNum);
            }
            if (selectPostMenu1.equals("d") || selectPostMenu1.equals("D")) {
                findAnonymousByPost(selectNum, login_user_no);   //익명게시판 전용 상세조회
            }
        }
    }


    // 익명게시판의 상세조회
    public void findAnonymousByPost (String selectNum, String login_user_no) {
        System.out.println("게시글 상세조회");
        /*
         * 익명게시판은 자신이 작성한 게시글에 대해서만 상세조회가 가능
         * 우선 로그인한 회원의 user_no이 post의 user_member_no과 일치하는 글들만 조회,
         * 일치하는 글이 없으면 "~ 님이 작성하신 글은 없습니다"로 출력
         * 로그인한 객체정보와 상세조회할 게시글의 작성자 일치여부 & 권한 여부 체크
         * */

        // 관리자권한과 일반유저권한에 따른 기능접근제한 구현
        // 관리자 - 게시글 작성여부에 상관없이 상세조회, 수정, 삭제 기능 접근가능
        // 일반 유저 - 본인이 작성한 게시글에 한하여 상세조회, 수정, 삭제 접근 가능
        String login_userName= loginUserContext.get(0).getUsername().toString();
        String login_user_role= loginUserContext.get(0).getRoleNo().toString();
        String userRole=(login_user_role.equals("1"))? "일반유저" : "관리자";
        System.out.println(login_userName+"의 권한 :"+userRole);

        System.out.println("상세 조회할 게시글의 번호를 입력하세요 : ");
        String post_id = scanner.next();
        // 익명 게시판의 게시글들
        ArrayList<JoinPostDto> getArrayList =  postController.findByPost(selectNum);

        //String post_user_id= getArrayList.get(0). ;
        // 게시글 번호를 통해 상세조회할 게시물조회
        ArrayList<PostDto> Id_list= postController.findIdByPost(selectNum, post_id);
        // 상세조회한 게시글의 user_no 추출
        String user_member_no = String.valueOf(Id_list.get(0).getMemberNo());

        boolean flag =true;

        while (true) {
            //게시글 조회자가 게시글 작성자이면 상세조회가능
            if (login_user_no.equals(user_member_no)||login_user_role.equals("2")) {
                // 상세조회
                ArrayList<JoinPostDto> getPostList3 = anonymousController.findDetailByPost(selectNum, post_id, login_user_no);
                System.out.println(getPostList3.get(0).DetailPostToString());
            } else if(!(login_user_no.equals(user_member_no)&& flag))  {
                logWarn("본인이 작성한 게시글만 상세조회 가능합니다.");
                flag=!flag;   // flag 뒤집기
            }

            System.out.println("\n u.게시글 수정  d.게시글 삭제" +
                               "\n b.뒤로 가기");
            uiSelectMenu();

            String selectPostMenu2 = scanner.next();

            if (!(selectPostMenu2.equals("u")||selectPostMenu2.equals("d")||selectPostMenu2.equals("b"))){
                logError("메뉴를 잘못 입력하셨습니다.");
            }
            //게시글 조회자가 게시글 작성자이면 수정가능
            if (selectPostMenu2.equals("u")||selectPostMenu2.equals("U")){
                // 수정기능
                if((login_user_no.equals(user_member_no))||(login_user_role.equals("2"))){

                    scanner.nextLine();  // 메뉴 선택후 개행문자가 수정할 제목으로 들어가는 것을 방지
                    System.out.println("수정하실 글 제목을 입력하세요 : ");
                    String postTitle=scanner.nextLine();
                    System.out.println("수정하실 글 내용을 입력하세요 : ");
                    String postBody=scanner.nextLine();
                    postController.updateIdByPost(selectNum, login_user_no ,post_id,postTitle,postBody);
                    logInfo("해당 게시글이 수정되었습니다.");
                    break;
                }else{
                    logWarn("본인이 작성한 게시글만 수정 가능합니다.");
                }
            }
            //게시글 조회자가 게시글 작성자이면 상세조회가능
            if (selectPostMenu2.equals("d")||selectPostMenu2.equals("D")){
                // 삭제기능
                if(login_user_no.equals(user_member_no)||login_user_role.equals("2")){
                    postController.deleteIdByPost(selectNum,login_user_no,post_id);
                    logInfo("해당 게시글이 삭제되었습니다.");
                    break;  //java.lang.IndexOutOfBoundsException: Index: 0, Size: 0 에러 해결

                }else{
                    logWarn("본인이 작성한 게시글만 삭제 가능합니다.");
                }
            }
            if (selectPostMenu2.equals("b")||selectPostMenu2.equals("B")) {
                // 뒤로가기
                break;
            }
        }
    }
}