package com.douzonetenten.tentenboardclient.service;

import com.douzonetenten.tentenboardclient.dao.BoardDao;
import com.douzonetenten.tentenboardclient.dto.BoardDto;

import java.sql.Connection;
import java.util.ArrayList;

import static com.douzonetenten.tentenboardclient.common.DBConnector.getConnection;

public class BoardService {
    private final BoardDao boardDao = new BoardDao();

    public ArrayList<BoardDto> findAllByBoard(){
        Connection connection = getConnection();
        ArrayList<BoardDto> boardDtoArrayList = boardDao.findAllByBoard(connection);
        return boardDtoArrayList;
    }
}
