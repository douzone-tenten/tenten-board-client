package com.douzonetenten.tentenboardclient.dto;

import java.sql.Timestamp;

/**
 * createdAt의 타입을 TimeStamp로 변경함.
 * 상속을 통한 userDto의 join한 값을 할당할 수 있는가?
 */

public class PostDto extends UserDto{
    private Long boardNo;
    private Long memberNo;
    private Long postId;
    private String postTitle;
    private String postBody;
    private Timestamp createdAt;

    public PostDto() {
    }

    public PostDto(Long postId, String postTitle, String postBody, Timestamp createdAt) {
        this.postId = postId;
        this.postTitle = postTitle;
        this.postBody = postBody;
        this.createdAt = createdAt;
    }

    public PostDto(Long boardNo, Long memberNo, Long postId, String postTitle, String postBody, Timestamp createdAt) {
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

    @Override
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    @Override
    public void setCreatedAt(Timestamp createdAt) {
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