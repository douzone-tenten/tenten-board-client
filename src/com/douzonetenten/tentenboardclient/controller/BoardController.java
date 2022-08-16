package com.douzonetenten.tentenboardclient.controller;

import com.douzonetenten.tentenboardclient.dto.BoardDto;
import com.douzonetenten.tentenboardclient.service.BoardService;

import java.util.ArrayList;

public class BoardController {
    private final BoardService boardService = new BoardService();

    public ArrayList<BoardDto> findAllByBoard(){
        ArrayList<BoardDto> boardDtoArrayList = boardService.findAllByBoard();
        return boardDtoArrayList;
    }
}
