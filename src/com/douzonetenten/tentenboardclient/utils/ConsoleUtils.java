package com.douzonetenten.tentenboardclient.utils;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ConsoleUtils {

    /**
     * 현재 시간을 출력하는 메소드입니다.
     *
     * @return : 현재시간
     */
    public static String getTime() {
        return LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss"));
    }

    /**
     * 메시지 템플릿
     *
     * @return
     */
    public static String messageTemplate(String message) {
        return getTime() + " : " + message + "\n";
    }


    /**
     * 에러 출력용 메소드 입니다.
     *
     * @param message : 에러메시지
     */
    public static void logError(String message) {
        System.out.println("\n[ERROR] " + messageTemplate(message));
    }

    /**
     * 경고 출력용 메소드 입니다.
     *
     * @param message : 경고메시지
     */
    public static void logWarn(String message) {
        System.out.println("\n[WARN] " + messageTemplate(message));
    }

    /**
     * 정보 출력용 메소드 입니다.
     *
     * @param message : 정보메시지
     */
    public static void logInfo(String message) {
        System.out.println("\n[INFO] " + messageTemplate(message));
    }

    /**
     * 콘솔 화면 리셋
     */
    public static void clearConsole() {
        for (int i = 0; i < 100; i++) {
            System.out.println("");
        }
    }
}
