package com.douzonetenten.tentenboardclient.view;

import com.douzonetenten.tentenboardclient.controller.UserController;
import java.util.Scanner;

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
                System.out.println("번호를 잘못 입력했습니다. 다시 입력해주세요.");
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
