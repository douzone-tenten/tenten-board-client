package com.douzonetenten.tentenboardclient.dto;

import java.time.LocalDateTime;

public class PostDto {
    private Long boardNo;
    private Long memberNo;
    private Long postId;
    private String postTitle;
    private String postBody;
    private LocalDateTime createdAt;

    public PostDto() {
    }

    public PostDto(Long postId, String postTitle, String postBody, LocalDateTime createdAt) {
        this.postId = postId;
        this.postTitle = postTitle;
        this.postBody = postBody;
        this.createdAt = createdAt;
    }

    public PostDto(Long boardNo, Long memberNo, Long postId, String postTitle, String postBody, LocalDateTime createdAt) {
        this.boardNo = boardNo;
        this.memberNo = memberNo;
        this.postId = postId;
        this.postTitle = postTitle;
        this.postBody = postBody;
        this.createdAt = createdAt;
    }

    public Long getBoardNo() {
        return boardNo;
    }

    public void setBoardNo(Long boardNo) {
        this.boardNo = boardNo;
    }

    public Long getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(Long memberNo) {
        this.memberNo = memberNo;
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

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "PostDto{" +
                "boardNo=" + boardNo +
                ", memberNo=" + memberNo +
                ", postId=" + postId +
                ", postTitle='" + postTitle + '\'' +
                ", postBody='" + postBody + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}