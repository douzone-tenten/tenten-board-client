package com.douzonetenten.tentenboardclient.controller;

import com.douzonetenten.tentenboardclient.dto.BoardDto;
import com.douzonetenten.tentenboardclient.service.BoardService;

import java.util.ArrayList;

public class BoardController {
    private final BoardService boardService = new BoardService();

    public void findAllByBoard(){
        ArrayList<BoardDto> boardDtoArrayList = boardService.findAllByBoard();

        if (boardDtoArrayList.isEmpty()){
            System.out.println("조회할 게시판이 없습니다.");
        }
        if (!boardDtoArrayList.isEmpty()){
            for(BoardDto boardDto : boardDtoArrayList){
                System.out.println(boardDto.toString());
            }
        }
    }
}
