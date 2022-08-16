//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.douzonetenten.tentenboardclient.view;

import com.douzonetenten.tentenboardclient.controller.UserController;
import com.douzonetenten.tentenboardclient.dto.UserDto;
import java.util.Scanner;

public class UserView {
    private UserController userController = new UserController();
    private Scanner scanner;

    public UserView() {
        this.scanner = new Scanner(System.in);
    }

    public void insertUser() {
        UserDto userDto = new UserDto();
        System.out.println("아이디를 입력하세요.");
        userDto.setUsername(this.scanner.nextLine());

        while(true) {
            System.out.println("비밀번호를 입력하세요.");
            String password = this.scanner.nextLine();
            System.out.println("비밀번호를 다시 입력하세요.");
            String passwordCheck = this.scanner.nextLine();
            if (password.equals(passwordCheck)) {
                userDto.setPassword(password);
                System.out.println("이름을 입력하세요.");
                userDto.setName(this.scanner.nextLine());
                System.out.println("소속을 입력하세요.");
                userDto.setDepartment(this.scanner.nextLine());
                this.userController.insertUser(userDto);
                return;
            }

            if (!password.equals(passwordCheck)) {
                System.out.println("비밀번호가 일치하지 않습니다.");
            }
        }
    }
}
