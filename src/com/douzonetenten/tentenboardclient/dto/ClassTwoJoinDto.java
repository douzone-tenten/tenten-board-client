package com.douzonetenten.tentenboardclient.dto;


import java.sql.Timestamp;

public class ClassTwoJoinDto {
    // 조인 할 때 feild 추가

    private Long post_id;
    private String post_title;
    private String post_body;

    private String name;
    private String username;

    private Timestamp created_at;


    public ClassTwoJoinDto() {
    }

    public ClassTwoJoinDto(Long post_id, String post_title, String username, Timestamp created_at) {
        this.post_id = post_id;
        this.post_title = post_title;
        this.username = username;
        this.created_at = created_at;
    }



    public ClassTwoJoinDto(Long post_id, String post_title, String post_body, String name, Timestamp created_at) {
        this.post_id = post_id;
        this.post_title = post_title;
        this.post_body = post_body;
        this.username = name;
        this.created_at = created_at;
    }



    public String getPost_body() {
        return post_body;
    }

    public void setPost_body(String post_body) {
        this.post_body = post_body;
    }

    public Long getpost_id() {
        return post_id;
    }

    public void setpost_id(Long post_id) {
        this.post_id = post_id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {

        return  " " + post_id + "    " + post_title +"    "+ username +"    "+ created_at;

    }



}
