package com.douzonetenten.tentenboardclient.dto;

import java.sql.Timestamp;

public class Notice_JoinPostDto {
    private Long post_id;
    private String post_title;
    private String post_body;
    private String username;
    private Timestamp created_at;

    /**
     * 기본 생성자를 생성
     * @author 김승혁
     */
    public Notice_JoinPostDto() {

    }

    /**
     * 매개 변수를 가지고 있는 기본 생성자를 생성
     * @author 김승혁
     */
    public Notice_JoinPostDto(Long post_id, String post_title, String username, Timestamp created_at) {
        this.post_id = post_id;
        this.post_title = post_title;
        this.username = username;
        this.created_at = created_at;
    }


    public Notice_JoinPostDto(Long post_id, String post_title, String post_body, String username, Timestamp created_at) {
        this.post_id = post_id;
        this.post_title = post_title;
        this.post_body = post_body;
        this.username = username;
        this.created_at = created_at;
    }

    /**
     * getter/setter 생성
     * @author 김승혁
     */
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


    /**
     * toString 생성, 나중에 view 클래스에서 사용할 예정
     * @author 김승혁
     */
    public String toString() {
        return  "제목 : '" + post_title + '\n' +
                " 작성자 : '" + username + '\n' +
                " 작성 시간 : " + created_at + '\n' +
                " 내용 : '" + post_body  + "\n" +
                "---------------------------------------";
    }
}