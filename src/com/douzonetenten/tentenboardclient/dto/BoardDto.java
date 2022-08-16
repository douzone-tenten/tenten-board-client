package com.douzonetenten.tentenboardclient.dto;

public class BoardDto {
    private Long boardNo;
    private String boardName;

    public BoardDto() {

    }

    public Long getBoardNo() {
        return boardNo;
    }

    public void setBoardNo(Long boardNo) {
        this.boardNo = boardNo;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public BoardDto(String boardName) {
        this.boardName = boardName;
    }

    @Override
    public String toString() {
        return "BoardDto{" +
                "boardNo=" + boardNo +
                ", boardName='" + boardName + '\'' +
                '}';
    }
}
