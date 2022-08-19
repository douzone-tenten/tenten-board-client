package com.douzonetenten.tentenboardclient.view.boards;

import com.douzonetenten.tentenboardclient.controller.FreeController;
import com.douzonetenten.tentenboardclient.controller.PostController;
import com.douzonetenten.tentenboardclient.dto.JoinPostDto;
import com.douzonetenten.tentenboardclient.dto.PostDto;
import com.douzonetenten.tentenboardclient.view.PostView;

import java.util.ArrayList;
import java.util.Scanner;

import static com.douzonetenten.tentenboardclient.service.UserService.loginUserContext;
import static com.douzonetenten.tentenboardclient.utils.ConsoleUtils.*;
import static com.douzonetenten.tentenboardclient.utils.UserInterfaceUtils.uiSelectMenu;
import static com.douzonetenten.tentenboardclient.utils.UserInterfaceUtils.uiTitle;

public class FreeBoardView {
    PostController PostController = new PostController();

    public FreeController freeController=new FreeController();
    public PostController postController= new PostController();

    private PostView postView = new PostView();
    private Scanner scanner = new Scanner(System.in);
    public void start(String selectBoardNum) {
        while(true) {

            ArrayList<JoinPostDto> getPostList = PostController.findByPost(selectBoardNum);
            uiTitle("자유게시판");
            // TODO : 게시판 공통 컴포넌트
            System.out.printf("--------------------------------\n" + "게시글 번호      제목        작성자      작성시간\n" + "--------------------------------\n");

            // 게시글 목록 조회
            if (getPostList.isEmpty()) {
                logWarn("조회할 포스트가 없습니다.");
            }

            if (!(getPostList.isEmpty())) {
                for (JoinPostDto joinPostDto : getPostList) {
                    System.out.println(joinPostDto.findPostToString());
                }
            }


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
                postView.insertPost(selectBoardNum);
            }
            if (selectPostMenu1.equals("d") || selectPostMenu1.equals("D")) {
                freeDetailByView(selectBoardNum);
            }

        }

    }
    public void freeDetailByView(String selectBoardNum){

        /*로그인 회원정보에서 권한 정보를 추출
        * */
        String login_user_role= loginUserContext.get(0).getRoleNo().toString();

        while(true) {

            logInfo("자유게시글 상세조회");
            // 로그인한 객체에서 user_id 추출
            String login_user_no = loginUserContext.get(0).getUserNo().toString();


            System.out.print("조회할 게시글 번호를 입력하세요 : ");
            String selectPostNum = scanner.next();

            /*
             * 자유게시판 상세조회기능입니다
             * 자유게시판은 모든유저가 다른글 들을 상세조회가 가능합니다.
             * */
            ArrayList<JoinPostDto> getPostList3 = freeController.FindDetailByPost(selectBoardNum, selectPostNum, login_user_no);
            System.out.println(getPostList3.get(0).DetailPostToString());


            // 게시글 번호를 통해 상세조회할 게시물조회
            // 상세조회한 게시글의 user_no 추출
            ArrayList<PostDto> Id_list= postController.findIdByPost(selectBoardNum, selectPostNum);
            String user_member_no = String.valueOf(Id_list.get(0).getMemberNo());

            scanner.nextLine(); // 메뉴선택 전에 개행문자 입력 방지
            /*
            * 하단메뉴 기능입니다
            * 하단메뉴는 삭제기능,수정기능,뒤로가기 기능을 호출합니다
            * */
            System.out.println("\n u.게시글 수정  d.게시글 삭제" +
                    "\n b.뒤로 가기");
            uiSelectMenu();


            // 상세조회의 메뉴 선택
            String selectDetailMenu = scanner.nextLine();

            //예외처리
            if (!(selectDetailMenu.equals("u") || selectDetailMenu.equals("d") || selectDetailMenu.equals("b"))) {
                logError("메뉴를 잘못 입력하셨습니다.");
            }


            /*
            * 자유게시판 수정 기능입니다.
            * 수정기능은 게시글 조회자가 게시글 작성자가 일치 시 기능수햅가능
            **/
            if (selectDetailMenu.equals("u") || selectDetailMenu.equals("U")) {

                if (login_user_no.equals(user_member_no)) {

                    scanner.nextLine();  // 메뉴 선택후 개행문자가 수정할 제목으로 들어가는 것을 방지
                    System.out.println("수정하실 글 제목을 입력하세요 : ");
                    String postTitle = scanner.nextLine();
                    System.out.println("수정하실 글 내용을 입력하세요 : ");
                    String postBody = scanner.nextLine();
                    freeController.updateIdByPost(selectBoardNum, login_user_no, selectPostNum, postTitle, postBody);
                    logInfo("해당 게시글이 수정되었습니다.");
                    break;
                } else {
                    logWarn("본인이 작성한 게시글만 수정 가능합니다.");
                }
            }

            /*
             * 자유게시판 삭제 기능입니다.
             * 삭제기능은 게시글 조회자가 게시글 작성자가 일치 시 기능수햅가능
             **/
            if (selectDetailMenu.equals("d")||selectDetailMenu.equals("D")){

                if(login_user_no.equals(user_member_no)){
                    freeController.deleteIdByPost(selectBoardNum,login_user_no,selectPostNum);
                    logInfo("해당 게시글이 삭제되었습니다.");
                    break;  //java.lang.IndexOutOfBoundsException: Index: 0, Size: 0 에러 해결

                }else{
                    logWarn("본인이 작성한 게시글만 삭제 가능합니다.");
                }
            }
            if (selectDetailMenu.equals("b")||selectDetailMenu.equals("B")) {
                // 뒤로가기
                break;
            }







        }


    }

}
