package com.douzonetenten.tentenboardclient.dto;

public class notice_boardDto {

    private Long boardNo;
    private String boardName;

    public notice_boardDto() {
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

    @Override
    public String toString() {
        return "notice_boardDto{" +
                "boardNo=" + boardNo +
                ", boardName='" + boardName + '\'' +
                '}';
    }
}
