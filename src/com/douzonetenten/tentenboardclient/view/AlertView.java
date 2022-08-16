//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.douzonetenten.tentenboardclient.view;

import java.time.LocalDateTime;

public class AlertView {
    private static LocalDateTime getTime = LocalDateTime.now();

    public AlertView() {
    }

    public static void displayError(String message) {
        System.out.println("[ERROR]" + getTime + " : " + message);
    }
}
