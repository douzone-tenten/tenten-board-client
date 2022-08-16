package com.douzonetenten.tentenboardclient.dao;

import com.douzonetenten.tentenboardclient.dto.BoardDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDao {
    /**
     * 게시판 목록 조회
     */
    public ArrayList<BoardDto> findAllByBoard(Connection connection) {
        ArrayList<BoardDto> boardDtoArrayList = null;
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM post WHERE board_board_no = ?");
            preparedStatement.setString(1,"2");
            boardDtoArrayList = new ArrayList<>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                BoardDto boardDto = new BoardDto();
                boardDto.setBoardNo(resultSet.getLong("board_board_no"));
                boardDtoArrayList.add(boardDto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return boardDtoArrayList;
    }
}
