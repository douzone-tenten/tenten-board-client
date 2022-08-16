package com.uni.tentenProject.view;

import java.util.Scanner;

public class notice_MainView {

    private notice_postView notice_postwiew = new notice_postView();
    private Scanner sc = new Scanner(System.in);

    public void start() {

        while (true) {
            System.out.println("실행할 항목을 선택하세요.");
            System.out.println("1. 공지사항 전체 조회");
            System.out.println("2. 공지사항 작성");
            System.out.println("3. 공지사항 삭제");
            System.out.println("9. 프로그램 종료");
            int notice = sc.nextInt();


            if (notice == 1) {
                System.out.println("공지사항 전체 조회");
            } else if (notice == 2) {
                notice_postView.insertPost();
            } else if (notice == 3) {
                notice_postView.deletePost();
            } else {
                System.out.println("잘못 입력하셨습니다.");
            }

            if (notice == 9){
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }

    }
}

