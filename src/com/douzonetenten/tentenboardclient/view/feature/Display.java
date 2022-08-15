package com.douzonetenten.tentenboardclient.view.feature;

public class Display {
    public static void displayError(String message){
        System.out.println("[ERROR] " + message);
    }

    public static void clearConsole(){
        for (int i = 0; i < 100; i++) {
            System.out.println("");
        }
    }

    public static void displayTitle(String message){
        System.out.printf("**********************\n" +
                "    "+ message + "    "+ "\n" +
                "**********************\n");
    }
}
