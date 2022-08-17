package com.douzonetenten.tentenboardclient.utils;

public class UserInterfaceUtils {
    /**
     * 타이틀 출력 메소드입니다.
     *
     * @param message : 타이틀
     */
    public static void uiTitle(String message) {
        System.out.printf("**********************\n" + "    " + message + "    " + "\n" + "**********************\n");
    }

    public static void uiSelectMenu() {
        System.out.print("메뉴를 선택하세요\n");
    }
}
