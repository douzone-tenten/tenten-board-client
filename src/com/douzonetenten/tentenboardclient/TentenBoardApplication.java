package com.douzonetenten.tentenboardclient;

import com.douzonetenten.tentenboardclient.view.MainView;
import com.douzonetenten.tentenboardclient.view.PostView;
import com.douzonetenten.tentenboardclient.view.UserView;

public class TentenBoardApplication {
    public static void main(String[] args) {
        MainView mainView = new MainView();
//        PostView postView = new PostView();
//        postView.insertPost();
//        postView.deletePost();
//        postView.findAllByPost();
        UserView userView =new UserView();
        userView.insertUser();

//        mainView.start();
    }
}
