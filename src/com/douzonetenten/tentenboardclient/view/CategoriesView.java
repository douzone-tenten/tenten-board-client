package com.douzonetenten.tentenboardclient.view;

import com.douzonetenten.tentenboardclient.controller.BoardController;
import com.douzonetenten.tentenboardclient.dto.BoardDto;

import java.util.ArrayList;
import java.util.Scanner;

import static com.douzonetenten.tentenboardclient.view.feature.Display.clearConsole;
import static com.douzonetenten.tentenboardclient.view.feature.Display.displayTitle;

public class CategoriesView {
    BoardView boardView = new BoardView();
    Class1View class1View = new Class1View();
    DouZoneTwoView douZoneTwoView = new DouZoneTwoView();
    private Scanner scanner = new Scanner(System.in);
    BoardController boardController = new BoardController();
    public void start(){
        clearConsole();
        displayTitle("전체 게시판 목록");
        ArrayList<BoardDto> boardDtoArrayList = boardController.findAllByBoard();
        for(BoardDto boardDto : boardDtoArrayList){
            System.out.println(boardDto.toStringByAll());
        }
        while (true){
            System.out.print("\n어느 게시판을 선택하시겠습니까? : ");
            String selectNum = scanner.next();

            if (selectNum.equals("1")){
                boardView.start("1");
            }

            if (selectNum.equals("2")){
                class1View.start("2");
            }
            if (selectNum.equals("3")){
                //TODO : 각자 게시판 클래스 작성해서 분기문 터서 사용할수 있도록.
            }
            if (selectNum.equals("4")){
                QnAView.start("4");
                //TODO : 각자 게시판 클래스 작성해서 분기문 터서 사용할수 있도록.
            }
            if (selectNum.equals("5")){
                //TODO : 각자 게시판 클래스 작성해서 분기문 터서 사용할수 있도록.
            }
            if (selectNum.equals("6")){
                //TODO : 각자 게시판 클래스 작성해서 분기문 터서 사용할수 있도록.
            }
            if (selectNum.equals("7")){
                douZoneTwoView.dztwostart(selectNum);
                //TODO : 각자 게시판 클래스 작성해서 분기문 터서 사용할수 있도록.
            }
        }
    }
}
