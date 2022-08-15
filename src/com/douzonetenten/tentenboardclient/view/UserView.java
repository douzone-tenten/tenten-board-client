package com.douzonetenten.tentenboardclient.view;

import com.douzonetenten.tentenboardclient.controller.UserController;
import com.douzonetenten.tentenboardclient.dto.UserDto;

import java.util.Scanner;

import static com.douzonetenten.tentenboardclient.service.UserService.loginUserContext;

public class UserView {
    private UserController userController = new UserController();
    private Scanner scanner = new Scanner(System.in);
    public void insertUser(){
        UserDto userDto = new UserDto();
        System.out.println("아이디를 입력하세요.");
        userDto.setUsername(scanner.nextLine());
        while (true){
            System.out.println("비밀번호를 입력하세요.");
            String password = scanner.nextLine();
            System.out.println("비밀번호를 다시 입력하세요.");
            String passwordCheck = scanner.nextLine();

            if (password.equals(passwordCheck)){
                userDto.setPassword(password);
                break;
            }
            if (!password.equals(passwordCheck)){
                System.out.println("비밀번호가 일치하지 않습니다.");
            }
        }
        System.out.println("이름을 입력하세요.");
        userDto.setName(scanner.nextLine());
        System.out.println("소속을 입력하세요.");
        userDto.setDepartment(scanner.nextLine());
        userController.insertUser(userDto);
    }

    public void login(){
        UserDto userDto = new UserDto();
        System.out.println("아이디를 입력하세요.");
        userDto.setUsername(scanner.nextLine());
        System.out.println("비밀번호를 입력하세요.");
        userDto.setPassword(scanner.nextLine());
        userController.login(userDto);
        System.out.println("안녕하세요. : " + loginUserContext.get(0).getName());
        System.out.println(loginUserContext.get(0).getUsername());
        System.out.println(loginUserContext.get(0).getDepartment());
    }
}
