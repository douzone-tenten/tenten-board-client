package com.douzonetenten.tentenboardclient.view;

import com.douzonetenten.tentenboardclient.controller.BoardController;
import com.douzonetenten.tentenboardclient.dto.BoardDto;
import com.douzonetenten.tentenboardclient.view.boards.*;

import java.util.ArrayList;
import java.util.Scanner;


import static com.douzonetenten.tentenboardclient.utils.ConsoleUtils.clearConsole;
import static com.douzonetenten.tentenboardclient.utils.ConsoleUtils.logInfo;
import static com.douzonetenten.tentenboardclient.utils.UserInterfaceUtils.uiTitle;

public class CategoriesView {
    FreeBoardView boardView = new FreeBoardView();
    ClassOneVIew classOneVIew = new ClassOneVIew();
    ClassTwoView douZoneTwoView = new ClassTwoView();
    AnonymousView anonymousView = new AnonymousView();
    BoardController boardController = new BoardController();

    public void start() {
        Scanner scanner = new Scanner(System.in);
        clearConsole();
        uiTitle("전체 게시판 목록");
        ArrayList<BoardDto> boardDtoArrayList = boardController.findAllByBoard();
        for (BoardDto boardDto : boardDtoArrayList) {
            System.out.println(boardDto.toStringByAll());
        }
        while (true) {
            System.out.print("\n어느 게시판을 선택하시겠습니까? : (뒤로가기 : 9)");
            String selectNum = scanner.next();
            if (selectNum.equals("1")) {
                boardView.start("1");
            }
            if (selectNum.equals("2")) {

            }
            if (selectNum.equals("3")) {
                NoticeView nmv = new NoticeView();
                nmv.start("3");
            }
            if (selectNum.equals("4")) { //1반 게시판
                classOneVIew.start("4");
            }
            if (selectNum.equals("5")) {
                douZoneTwoView.dztwostart(selectNum);

            }
            if (selectNum.equals("6")) {
                // FIXME
                boardView.start("6");
            }
            if (selectNum.equals("7")) {
                // empboard
            }
            if (selectNum.equals("9")) {
                logInfo("이전 메뉴로 돌아갑니다.");
                break;
            }
        }
    }
}
