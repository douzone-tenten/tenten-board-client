package com.douzonetenten.tentenboardclient.view.boards;

import com.douzonetenten.tentenboardclient.controller.ClassTwoController;
import com.douzonetenten.tentenboardclient.controller.PostController;
import com.douzonetenten.tentenboardclient.dto.ClassTwoJoinDto;
import com.douzonetenten.tentenboardclient.dto.JoinPostDto;
import com.douzonetenten.tentenboardclient.dto.PostDto;
import com.douzonetenten.tentenboardclient.dto.UserDto;

import java.util.ArrayList;
import java.util.Scanner;

import static com.douzonetenten.tentenboardclient.service.UserService.loginUserContext;
import static com.douzonetenten.tentenboardclient.utils.ConsoleUtils.*;
import static com.douzonetenten.tentenboardclient.utils.UserInterfaceUtils.uiTitle;

public class ClassTwoView {
    private Scanner sc = new Scanner(System.in);
    private ClassTwoController douZoneTwoController = new ClassTwoController();
    private PostController postController = new PostController();
    private ClassTwoJoinDto douZoneTwoJoinDto = new ClassTwoJoinDto();

    /**
     * 더존 2반 게시판
     * @author 황명수
     */

    /**
     * dztwostart() = ClassTwoView 호출하는 메소드
     * @param selectNum - 조회할 게시판의 카테고리 넘버
     * @author 황명수
     */

    public void dztwostart(String selectNum) {
        while (true) {
            /**
             * !loginUserContext.get(0).getDepartment().equals("2") = login 한 사람의 소속이 2반이 아니면 접근 제한
             * @author 황명수
             */
            if (!(loginUserContext.get(0).getDepartment().equals("2"))) {
                logWarn("접근 권한이 없습니다");
                break;
            }
            clearConsole();
            uiTitle("더존 2반 게시판");
            System.out.printf("--------------------------------------------\n" +
                    "게시글 번호      제목        작성자      작성시간\n" +
                    "--------------------------------------------\n");

            /**
             * douzoneFindByAll() = 선택한 게시판의 게시글 전체를 조회하는 메소드
             * @param selectNum - 게시판 번호
             * @author 황명수
             */
            ArrayList<ClassTwoJoinDto> boardDtoArrayList = douZoneTwoController.douzoneFindByAll(selectNum);

            /**
             * boardDtoArrayList.isEmpty() = 조회하고자 하는 게시판의 게시글이 있는지 확인
             * @author 황명수
             */
            if (boardDtoArrayList.isEmpty()) {
                logInfo("조회할 포스트가 없습니다.");
            }

            if (!(boardDtoArrayList.isEmpty())) {
                for (ClassTwoJoinDto douZoneTwoJoinDto : boardDtoArrayList)
                    System.out.println(douZoneTwoJoinDto.toString());
            }

            logInfo("원하는 메뉴를 선택하세요");
            logInfo("b. 뒤로 가기   r.상세조회   w. 글쓰기");
            String answer = sc.nextLine();

            /**
             * answer.equals("w") || answer.equals("W") = 입력받은 Scanner가 w,W 이면 글쓰기
             * dztwoinsert() = 글을 작성할 수 있는 메소드
             * @author 황명수
             */

            if (answer.equals("w") || answer.equals("W")) {
                dztwoinsert();
            }

            /**
             * answer.equals("b") || answer.equals("B") = 입력받은 Scanner가 b,B 이면 뒤로가기
             * @author 황명수
             */

            if (answer.equals("b") || answer.equals("B")) {
                break;
            }

            /**
             * answer.equals("r") || answer.equals("R") = 입력받은 Scanner가 r,R 이면 글쓰기
             * dztwodetailselect() = 선택한 게시글을 상세조회할 수 있는 메소드
             * @author 황명수
             */

            if (answer.equals("r") || answer.equals("R")) {
//                clearConsole();
                logInfo("상세조회할 게시글 번호를 입력하세요 : ");
                int detail = sc.nextInt();
                dztwodetailselect(detail);
//                sc.nextLine();
                break;
            }

        }
    }


    public void dztwodetailselect(int postId) {
        /**
         * dztwodetailselect() = 사용자가 선택한 더존 2반 게시판에 게시글을 상세조회할 수 있는 메소드
         * detailPostToString() = joinPostDto 에 있는 값 출력 메소드
         * @param post_id - 게시글 번호
         * @author 황명수
         */
        ArrayList<JoinPostDto> boardDtoArrayList = douZoneTwoController.douzoneTwoDetailSelect(postId);
        for (JoinPostDto joinPostDto : boardDtoArrayList) {
            System.out.println(joinPostDto.detailPostToString());
        }

        while (true) {
//            ArrayList<JoinPostDto> boardDtoArrayList = douZoneTwoController.douzoneTwoDetailSelect(postId);
//            for (JoinPostDto joinPostDto : boardDtoArrayList) {
//                System.out.println(joinPostDto.detailPostToString());
//            }


            String answer = sc.nextLine();
            if (answer.equals("e") || answer.equals("E")) {
                /**
                 * dztwoUpdate() = 사용자가 상세보기한 더존 2반 게시판에 게시글을 수정할 수 있는 메소드
                 * (단, 본인이 작성한 것만 가능하다)
                 * port_id = 작성한 게시글 번호
                 * @author 황명수
                 */
                dztwoUpdate(postId);
                break;
            }
            if (answer.equals("d") || answer.equals("D")) {
                /**
                 * dzTwoDelete() = 사용자가 상세보기한 더존 2반 게시판에 게시글을 삭제할 수 있는 메소드
                 * (단, 본인이 작성한 것만 가능하다)
                 * @param port_id - 게시글 번호
                 * @author 황명수
                 */
                dzTwoDelete(postId);
                break;
            }
            if (answer.equals("b")|| answer.equals("B")){
                /**
                 * clearConsole() = 콘솔 창 정리하는 메소드
                 * @author 황명수
                 */
//                clearConsole();
                break;
            }

        }
    }
    public void dztwoUpdate(int postId) {

        /**
         * dztwoUpdate() = 사용자가 상세보기한 더존 2반 게시판에 게시글을 수정할 수 있는 메소드
         * (단, 본인이 작성한 것만 가능하다)
         * @param port_id - 게시글 번호
         * @author 황명수
         */
//        String a = sc.nextLine();
        System.out.println("======================================");

        JoinPostDto joinPostDto = new JoinPostDto();
        logInfo("제목을 수정해주세요 : ");
        String test = sc.nextLine();
        logInfo("글 내용을 수정해주세요 : ");
        String body = sc.nextLine();

         int result =  douZoneTwoController.douzoneTwoUpdate(postId, test,body);
         if (result > 0){
             joinPostDto.setPostTitle(test);
             joinPostDto.setPostBody(body);
             System.out.println(joinPostDto.getPostTitle());
             System.out.println(joinPostDto.getPostBody());
             logInfo("위 내용이 맞나요?");
             logInfo("Y : 등록하기");
             logInfo("B : 취소하기");

             String select = sc.next();
             if (select.equals("Y") || select.equals("y")) {

                 logInfo("작성한 글이 등록되었습니다.");
             }
             if (select.equals("B")) {
                 logInfo("글 작성을 취소합니다.");
             }
             logInfo("게시글 수정을 성공했습니다.");
         }else {
             logWarn("본인이 작성한 게시글만 수정할 수 있습니다.");
         }



    }
    public void dztwoinsert() {
        /**
         * dztwoinsert() = 사용자가 더존 2반 게시판에 글을 작성할 수 있는 메소드
         * @author 황명수
         */
        sc.nextLine();
        PostDto postDto = new PostDto();
        logInfo("제목을 입력하세요 : ");
        String douzone_postTitle = sc.nextLine();
        logInfo("글 내용을 입력하세요.");
        String douzone_postBody = sc.nextLine();
        postDto.setPostTitle(douzone_postTitle);
        postDto.setPostBody(douzone_postBody);
        System.out.println(postDto.getPostTitle());
        System.out.println(postDto.getPostBody());
        logInfo("위 내용이 맞나요?");
        logInfo("Y : 등록하기");
        logInfo("B : 취소하기");

        String select = sc.nextLine();
        if (select.equals("Y") || select.equals("y")) {
            logInfo("작성한 글이 등록되었습니다.");
            douZoneTwoController.dozoneTwoInsert(postDto, "5");
        }
        if (select.equals("B")) {
            logInfo("글 작성을 취소합니다.");
        }
    }
    public void dzTwoDelete(int postId){
        /**
         * dzTwoDelete() = 사용자가 상세보기한 더존 2반 게시판 게시글을 삭제할 수 있는 메소드(단, 본인이 작성한 것만 가능하다)
         * logInfo() = 사용자에게 정보를 전달하는 메소드
         * logWarn() = 사용자에게 경고를 전달하는 메소드
         * port_id = 사용자가 작성한 게시글 번호
         * @author 황명수
         */
       logInfo("선택한 게시글을 삭제하겠습니까? (y/n)");
        String a = sc.nextLine();
        if ( a.equals("y") || a.equals("Y") ){
            int result = douZoneTwoController.douzoneTwoDelete(postId);
            if (result > 0){
                logInfo("선택한 게시글 삭제가 완료 되었습니다.");

            }else{
                logWarn("본인이 작성한 게시글만 삭제할 수 있습니다.");
            }

        } else if (a.equals("N") || a.equals("n")) {
            logInfo("게시글 삭제 취소");
        }
    }
}
