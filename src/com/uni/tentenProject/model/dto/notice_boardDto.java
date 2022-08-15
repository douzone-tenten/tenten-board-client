package com.uni.tentenProject.model.dto;

public class notice_boardDto {
    private long boardNo;
    private String boardName;

    public long getBoardNo() {
        return boardNo;
    }

    public void setBoardNo(long boardNo) {
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
