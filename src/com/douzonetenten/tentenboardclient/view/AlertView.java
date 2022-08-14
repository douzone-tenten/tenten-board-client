package com.douzonetenten.tentenboardclient.view;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

public class AlertView {
    private static LocalDateTime getTime = LocalDateTime.now();

    public static void displayError(String message){
        System.out.println("[ERROR]" + getTime + " : " + message);
    }
}
