package com.douzonetenten.tentenboardclient.view;

import com.douzonetenten.tentenboardclient.controller.BoardController;

import java.util.Scanner;

public class BoardView {
    private Scanner scanner = new Scanner(System.in);
    BoardController boardController = new BoardController();
    public void start(){
        while (true){
            System.out.println("게시판 목록조회하기");
            String selectNum = scanner.next();

            if (selectNum.equals("1")){
                boardController.findAllByBoard();
            }
        }
    }
}
