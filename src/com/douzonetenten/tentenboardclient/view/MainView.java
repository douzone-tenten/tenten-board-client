package com.douzonetenten.tentenboardclient.view;

import com.douzonetenten.tentenboardclient.controller.UserController;
import java.util.Scanner;

import static com.douzonetenten.tentenboardclient.view.AlertView.displayError;

public class MainView {
    public void start() {
        UserController userController = new UserController();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("텐텐보드");
            System.out.println("로그인 / 회원가입");
            System.out.println("1. 로그인");
            System.out.println("2. 회원가입");
            System.out.println("9. 접속종료");
            System.out.print("메뉴를 선택하세요 : ");
            String selectNum = scanner.next();


            /**
             * 예외처리
             */
            if (!(selectNum.equals("9") || selectNum.equals("1") || selectNum.equals("2"))) {
                displayError("메뉴를 잘못 입력하셨습니다.");
            }

            /**
             * 프로그램 종료
             */
            if (selectNum.equals("9")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }

    public static void clearConsole(){
        for (int i = 0; i < 100; i++) {
            System.out.println("");
        }
    }
}
