package com.douzonetenten.tentenboardclient;

import com.douzonetenten.tentenboardclient.view.MainView;
import com.douzonetenten.tentenboardclient.view.PostView;
import com.douzonetenten.tentenboardclient.view.QnAView;
import com.douzonetenten.tentenboardclient.view.UserView;

public class TentenBoardApplication {
    public static void main(String[] args) {
        MainView mainView = new MainView();
        //mainView.start();

        QnAView qnAView = new QnAView();
        //qnAView.findAllByPost();
        //qnAView.insertPost();
        qnAView.deleteQnA();
    }
}
