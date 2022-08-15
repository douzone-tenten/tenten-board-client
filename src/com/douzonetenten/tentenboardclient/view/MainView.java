package com.douzonetenten.tentenboardclient.view;

import com.douzonetenten.tentenboardclient.controller.UserController;
import java.util.Scanner;

import static com.douzonetenten.tentenboardclient.view.feature.Display.displayError;

public class MainView {
    private Scanner scanner = new Scanner(System.in);
    private UserView userView = new UserView();

    public void start() {
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

            if (selectNum.equals("1")){
                userView.login();
            }

            if (selectNum.equals("2")){
                userView.insertUser();
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
}
