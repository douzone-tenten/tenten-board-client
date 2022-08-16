package com.douzonetenten.tentenboardclient.view;

import com.douzonetenten.tentenboardclient.controller.QnAController;

public class QnAView {

    private QnAController qnAController = new QnAController();

    public void findAllByPost() {

        System.out.println("전체 포스트를 조회합니다.");
        this.qnAController.findAllByQnA();
    }
}
