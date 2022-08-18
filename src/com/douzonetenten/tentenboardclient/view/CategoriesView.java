package com.douzonetenten.tentenboardclient.view;

import com.douzonetenten.tentenboardclient.controller.BoardController;
import com.douzonetenten.tentenboardclient.dto.BoardDto;
import com.douzonetenten.tentenboardclient.view.boards.*;

import java.util.ArrayList;
import java.util.Scanner;

import static com.douzonetenten.tentenboardclient.service.UserService.loginUserContext;
import static com.douzonetenten.tentenboardclient.utils.ConsoleUtils.*;
import static com.douzonetenten.tentenboardclient.utils.UserInterfaceUtils.uiTitle;
import static com.douzonetenten.tentenboardclient.view.boards.QnAView.qnaViewStart;


public class CategoriesView {
    FreeBoardView boardView = new FreeBoardView();
    ClassOneView classOneView = new ClassOneView();
    ClassTwoView douZoneTwoView = new ClassTwoView();
    AnonymousView anonymousView = new AnonymousView();
    EmpBoardView empBoardView = new EmpBoardView();
    BoardController boardController = new BoardController();
                NoticeView nmv = new NoticeView();

    public void start() {
        Scanner scanner = new Scanner(System.in);

        ArrayList<BoardDto> boardDtoArrayList = boardController.findAllByBoard();
        while (true) {
            clearConsole();
            uiTitle("전체 게시판 목록");
        for (BoardDto boardDto : boardDtoArrayList) {
            System.out.println(boardDto.toStringByAll());
        }

            System.out.print("\n어느 게시판을 선택하시겠습니까? : (뒤로가기 : 9)");
            String selectNum = scanner.next();
            if (selectNum.equals("1")) {
                boardView.start("1");
            }
            if (selectNum.equals("2")) {
                nmv.start("2");
            }
            if (selectNum.equals("3")) {
                qnaViewStart(selectNum);
            }
            if (selectNum.equals("4")) { //1반 게시판
                String userdept = loginUserContext.get(0).getDepartment();
                if(userdept.equals("1")){
                    classOneView.start("4");
                }
                if(!(userdept.equals("1"))){
                    logInfo("\n" +
                            "┌───────────────┐\n" +
                            "    1반 친구만!    \n" +
                            "└───────────────┘\n" +
                            "　　ᕱ ᕱ ||\n" +
                            "　 ( ･ω･ ||\n" +
                            "　 /　つΦ");
                }
            }
            if (selectNum.equals("5")) {
                douZoneTwoView.dztwostart(selectNum);
            }
            if (selectNum.equals("6")) {
                anonymousView.start(selectNum);
            }
            if (selectNum.equals("7")) {
                empBoardView.start("7");
            }
            if (selectNum.equals("9")) {
                logInfo("이전 메뉴로 돌아갑니다.");
                break;
            }
        }
    }
}
