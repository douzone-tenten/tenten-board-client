package com.douzonetenten.tentenboardclient.dto;

import java.sql.Timestamp;

public class Notice_JoinPostDto {
    private long post_id;
    private String post_title;
    private String post_body;
    private String username;
    private Timestamp created_at;

    public Notice_JoinPostDto() {

    }

    public Notice_JoinPostDto(long post_id, String post_title, String username, Timestamp created_at) {
        this.post_id = post_id;
        this.post_title = post_title;
        this.username = username;
        this.created_at = created_at;
    }

    public Notice_JoinPostDto(long post_id, String post_title, String post_body, String username, Timestamp created_at) {
        this.post_id = post_id;
        this.post_title = post_title;
        this.post_body = post_body;
        this.username = username;
        this.created_at = created_at;
    }

    public long getPost_id() {
        return post_id;
    }

    public void setPost_id(long post_id) {
        this.post_id = post_id;
    }

    public String getPost_title() {
        return post_title;
    }

    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }

    public String getPost_body() {
        return post_body;
    }

    public void setPost_body(String post_body) {
        this.post_body = post_body;
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


    public String toString() {
        return  "제목 : '" + post_title + '\n' +
                " 작성자 : '" + username + '\n' +
                " 작성 시간 : " + created_at + '\n' +
                " 내용 : '" + post_body  + "\n" +
                "---------------------------------------";
    }
}