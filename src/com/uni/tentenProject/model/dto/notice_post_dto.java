package com.uni.tentenProject.model.dto;

import java.security.Timestamp;

public class notice_post_dto {

    private long boardBoardNo;
    private long userMemberNO;
    private long postID;
    private Timestamp createdAt;
    private String postTitle;
    private String postBody;

    public notice_post_dto() {
    }

    public notice_post_dto(long boardBoardNo, long userMemberNO, long postID, Timestamp createdAt, String postTitle, String postBody) {
        this.boardBoardNo = boardBoardNo;
        this.userMemberNO = userMemberNO;
        this.postID = postID;
        this.createdAt = createdAt;
        this.postTitle = postTitle;
        this.postBody = postBody;
    }

    public long getBoardBoardNo() {
        return boardBoardNo;
    }

    public void setBoardBoardNo(long boardBoardNo) {
        this.boardBoardNo = boardBoardNo;
    }

    public long getUserMemberNO() {
        return userMemberNO;
    }

    public void setUserMemberNO(long userMemberNO) {
        this.userMemberNO = userMemberNO;
    }

    public long getPostID() {
        return postID;
    }

    public void setPostID(long postID) {
        this.postID = postID;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
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
    public String toString() {
        return "notice_post_dto{" +
                "boardBoardNo=" + boardBoardNo +
                ", userMemberNO=" + userMemberNO +
                ", postID=" + postID +
                ", createdAt=" + createdAt +
                ", postTitle='" + postTitle + '\'' +
                ", postBody='" + postBody + '\'' +
                '}';
    }



}