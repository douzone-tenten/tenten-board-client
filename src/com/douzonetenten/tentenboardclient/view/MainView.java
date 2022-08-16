package com.douzonetenten.tentenboardclient.view;

import com.douzonetenten.tentenboardclient.controller.UserController;
import java.util.Scanner;

import static com.douzonetenten.tentenboardclient.view.AlertView.displayError;

public class MainView {
    public void start() {
        new UserController();
        Scanner scanner = new Scanner(System.in);

        String selectNum;
        do {
            System.out.println("텐텐보드");
            System.out.println("로그인 / 회원가입");
            System.out.println("1. 로그인");
            System.out.println("2. 회원가입");
            System.out.println("9. 접속종료");
            System.out.print("메뉴를 선택하세요 : ");
            selectNum = scanner.next();
            if (!selectNum.equals("9") && !selectNum.equals("1") && !selectNum.equals("2")) {
                AlertView.displayError("메뉴를 잘못 입력하셨습니다.");
            }
        } while(!selectNum.equals("9"));

        System.out.println("프로그램을 종료합니다.");
    }

    public static void clearConsole() {
        for(int i = 0; i < 100; ++i) {
            System.out.println("");
        }
    }
}
