package com.douzonetenten.tentenboardclient.dto;


import java.sql.Timestamp;

public class DouZoneTwoJoinDto {
    // 조인 할 때 feild 추가

    private Long board_board_no;
    private String post_title;

    private String username;

    private Timestamp created_at;

    public DouZoneTwoJoinDto() {
    }

    public DouZoneTwoJoinDto(Long board_board_no, String post_title, String username, Timestamp created_at) {
        this.board_board_no = board_board_no;
        this.post_title = post_title;
        this.username = username;
        this.created_at = created_at;
    }


    public Long getBoard_board_no() {
        return board_board_no;
    }

    public void setBoard_board_no(Long board_board_no) {
        this.board_board_no = board_board_no;
    }

    public String getPost_title() {
        return post_title;
    }

    public void setPost_title(String  post_title) {
        this.post_title = post_title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {

        return  "PostDto{" +username +
                "boardNo=" + board_board_no +
                ", memberNo=" + post_title +
                ", postId=" + created_at +
                '}';
    }
}
