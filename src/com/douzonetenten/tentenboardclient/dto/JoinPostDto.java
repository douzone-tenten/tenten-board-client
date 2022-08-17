package com.douzonetenten.tentenboardclient.dto;

import java.sql.Timestamp;

public class JoinPostDto {
    private Long postId;
    private String postTitle;
    private String userName;
    private Timestamp createdAt;

    public JoinPostDto() {
    }

    public JoinPostDto(Long postId, String postTitle, String username, Timestamp createdAt) {
        this.postId = postId;
        this.postTitle = postTitle;
        this.userName = username;
        this.createdAt = createdAt;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "JoinPostDto{" +
                "postId=" + postId +
                ", postTitle='" + postTitle + '\'' +
                ", username='" + userName + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    public String findPostToString() {
        return postId + "         " + postTitle + "          " +  userName + "         " + createdAt;
    }
}