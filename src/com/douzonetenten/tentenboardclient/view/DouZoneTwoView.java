package com.douzonetenten.tentenboardclient.view;

import com.douzonetenten.tentenboardclient.controller.DouZoneTwoController;
import com.douzonetenten.tentenboardclient.dto.BoardDto;
import com.douzonetenten.tentenboardclient.dto.PostDto;

import java.util.ArrayList;
import java.util.Scanner;

public class DouZoneTwoView {

    private Scanner sc = new Scanner(System.in);
    private DouZoneTwoController douZoneTwoController = new DouZoneTwoController();
    public void dztwostart(String boardNum) {
        ArrayList<PostDto> boardDtoArrayList = douZoneTwoController.douzoneFindByAll();
        for(PostDto postDto : boardDtoArrayList){
            System.out.println(postDto.toString());
        }



        System.out.println("더존 2반 게시판");
        System.out.println("------------------------------");
    }



    }

