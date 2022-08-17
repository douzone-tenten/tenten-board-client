package com.douzonetenten.tentenboardclient.dto;

import java.security.Timestamp;

public class notice_JoinPostDto {
    private String post_id;
    private String post_title;
    private String userName;
    private Timestamp created_at;
    public notice_JoinPostDto() {

    }

    public notice_JoinPostDto(String post_id, String post_title, String userName, Timestamp created_at) {
        this.post_id = post_id;
        this.post_title = post_title;
        this.userName = userName;
        this.created_at = created_at;
    }

    public String getPost_id() {
        return post_id;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public String getPost_title() {
        return post_title;
    }

    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "JoinPostDto{" +
                "postId=" + post_id +
                ", postTitle='" + post_title + '\'' +
                ", username='" + userName + '\'' +
                ", createdAt=" + created_at +
                '}';
    }

    public String findPostToString() {
        return post_id + "    " + post_title + "    " + "    " + userName + "    " + created_at;
    }
}
