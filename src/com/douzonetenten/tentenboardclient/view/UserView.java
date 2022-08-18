package com.douzonetenten.tentenboardclient.view;

import com.douzonetenten.tentenboardclient.controller.UserController;
import com.douzonetenten.tentenboardclient.dto.UserDto;

import java.util.Scanner;

import static com.douzonetenten.tentenboardclient.service.UserService.loginUserContext;
import static com.douzonetenten.tentenboardclient.utils.ConsoleUtils.*;
import static com.douzonetenten.tentenboardclient.utils.UserInterfaceUtils.uiTitle;

public class UserView {
    private UserController userController = new UserController();
    private Scanner scanner = new Scanner(System.in);
    private UserDto userDto = new UserDto();
    private LoginMainView loginMainView = new LoginMainView();

    public void insertUser() {
        clearConsole();
        uiTitle("회원가입");

        System.out.println("아이디를 입력하세요.");
        userDto.setUsername(scanner.nextLine());

        while (true) {
            System.out.println("비밀번호를 입력하세요.");
            String password = scanner.nextLine();
            System.out.println("비밀번호를 다시 입력하세요.");
            String passwordCheck = scanner.nextLine();

            if (password.equals(passwordCheck)) {
                userDto.setPassword(password);
                break;
            }
            if (!password.equals(passwordCheck)) {
                System.out.println("비밀번호가 일치하지 않습니다.");
            }
        }

        System.out.println("이름을 입력하세요.");
        userDto.setName(scanner.nextLine());
        while (true) {
            System.out.println("반을 입력하세요. (1반이면 1, 2반이면 2)");
            String department = scanner.nextLine();
            if (!(department.equals("1") || department.equals("2"))) {
                System.out.println("1 또는 2만 입력해주세요.");
            }
            if ((department.equals("1") || department.equals("2"))) {
                userDto.setDepartment(department);
                break;
            }
        }
        int result = userController.insertUser(userDto);
        if (result == 1){
            System.out.println("회원가입에 성공했습니다.");
        }
    }

    public void login(){
        clearConsole();
        uiTitle("로그인");
        System.out.println("아이디를 입력하세요.");
        userDto.setUsername(scanner.nextLine());
        System.out.println("비밀번호를 입력하세요.");
        userDto.setPassword(scanner.nextLine());

        try {
            userController.login(userDto);
        } catch (Exception e) {
            // TODO : Exception 처리
            logError("로그인에 실패하였습니다.");
        }

        if (!loginUserContext.isEmpty() && userDto.getUsername().equals(loginUserContext.get(0).getUsername())) {
            loginMainView.start();
        } else if (loginUserContext.isEmpty()) {
            // TODO : Exception 처리
            logError("로그인에 실패하였습니다.");
        }
    }
}
