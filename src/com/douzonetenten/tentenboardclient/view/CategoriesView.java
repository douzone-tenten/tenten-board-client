package com.douzonetenten.tentenboardclient.view;

import com.douzonetenten.tentenboardclient.controller.BoardController;
import com.douzonetenten.tentenboardclient.dto.BoardDto;

import java.util.ArrayList;
import java.util.Scanner;

import static com.douzonetenten.tentenboardclient.view.feature.Display.clearConsole;
import static com.douzonetenten.tentenboardclient.view.feature.Display.displayTitle;

public class CategoriesView {
    BoardView boardView = new BoardView();
    AnonymousView anonymousView = new AnonymousView();

    private Scanner scanner = new Scanner(System.in);
    BoardController boardController = new BoardController();
    public void start(){
        clearConsole();
        displayTitle("전체 게시판 목록");
        ArrayList< BoardDto> boardDtoArrayList = boardController.findAllByBoard();
        for(BoardDto boardDto : boardDtoArrayList){
            System.out.println(boardDto.toStringByAll());
        } //각 게시판 접근 후 뒤로가기로 CategoriesView의 start()를 호출시키면 stackoverflow 발생
        while (true){
            System.out.print("\n어느 게시판을 선택하시겠습니까? : ");
            String selectNum = scanner.next();

            if (selectNum.equals("1")){
                boardView.start("1");
            }

            if (selectNum.equals("2")){
                //TODO : 각자 게시판 클래스 작성해서 분기문 터서 사용할수 있도록.
            }
            if (selectNum.equals("3")){
                //TODO : 각자 게시판 클래스 작성해서 분기문 터서 사용할수 있도록.
            }
            if (selectNum.equals("4")){
                //TODO : 각자 게시판 클래스 작성해서 분기문 터서 사용할수 있도록.
            }
            if (selectNum.equals("5")){
                //TODO : 각자 게시판 클래스 작성해서 분기문 터서 사용할수 있도록.
                anonymousView.start(selectNum);
            }
            if (selectNum.equals("6")){
                //TODO : 각자 게시판 클래스 작성해서 분기문 터서 사용할수 있도록.
            }
            if (selectNum.equals("9")){
                //TODO : 각자 게시판 클래스 작성해서 분기문 터서 사용할수 있도록.
            }
        }
    }
}
