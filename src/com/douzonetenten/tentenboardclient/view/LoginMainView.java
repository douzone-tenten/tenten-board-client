package com.douzonetenten.tentenboardclient.view;

import com.douzonetenten.tentenboardclient.controller.UserController;

import java.util.Scanner;

import static com.douzonetenten.tentenboardclient.service.UserService.loginUserContext;
import static com.douzonetenten.tentenboardclient.utils.ConsoleUtils.logInfo;
import static com.douzonetenten.tentenboardclient.utils.ConsoleUtils.logWarn;
import static com.douzonetenten.tentenboardclient.utils.UserInterfaceUtils.uiTitle;

public class LoginMainView {
    private Scanner scanner = new Scanner(System.in);
    UserController userController = new UserController();

    CategoriesView boardView = new CategoriesView();
    public void start(){
        while (true){
            uiTitle("텐텐보드 메인");
            System.out.print("안녕하세요. " + loginUserContext.get(0).getName() + "님.\n\n");
            System.out.println("1. 게시판 목록조회");
            System.out.println("8. 로그아웃");
            System.out.println("9. 프로그램 종료");
            String selectNum = scanner.next();

            /**
             * 예외처리
             */
            if (!(selectNum.equals("1") || selectNum.equals("2") || selectNum.equals("3") || selectNum.equals("8") || selectNum.equals("9"))) {
                logWarn("메뉴를 잘못 입력하셨습니다.");
            }

            if (selectNum.equals("1")){
                boardView.start();
            }
            if (selectNum.equals("8")){
                logInfo("로그아웃이 완료되었습니다.");
                userController.logout();
                break;
            }
            if (selectNum.equals("9")){
                logInfo("프로그램을 종료합니다.");
                System.exit(0);
            }
        }
    }
}
