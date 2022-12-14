package com.douzonetenten.tentenboardclient.dto;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;


public class JoinPostDto {
    private Long postId;
    private Long boardNo;
    private String postTitle;
    private String postBody;
    private String username;
    private String name;
    private Timestamp createdAt;

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getBoardNo() {
        return boardNo;
    }

    public void setBoardNo(Long boardNo) {
        this.boardNo = boardNo;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public JoinPostDto(Long postId, Long boardNo, String postTitle, String postBody, String username, String name, Timestamp createdAt) {
        this.postId = postId;
        this.boardNo = boardNo;
        this.postTitle = postTitle;
        this.postBody = postBody;
        this.username = username;
        this.name = name;
        this.createdAt = createdAt;
    }

    public JoinPostDto() {
    }

    @Override
    public String toString() {
        return "JoinPostDto{" +
                "postId=" + postId +
                ", boardNo=" + boardNo +
                ", postTitle='" + postTitle + '\'' +
                ", postBody='" + postBody + '\'' +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    public String findPostToString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy??? MM??? dd??? hh??? mm??? ss???");
        String createdStr = simpleDateFormat.format(createdAt);

        return String.format("%-15s", postId) + String.format("%-15s", postTitle)
                + String.format("%-15s", username) + createdStr;

    }

    //?????? ????????? ???????????? ????????? TODO : ????????? ????????????.
    public String findSelectDetailPostToString(){
        return "????????? ?????? : " + postId + "\n" + "???         ??? : " + postTitle + "\n"
                + "???   ???   ??? : " + name + " (" +  username + ") " + "\n"
                + "??? ??? ??? ??? : " + createdAt + "\n\n"
                + "???    ???  ??? : " + postBody;
    }

    public String detailPostToString() {
        return "?????? : " + postTitle +
                "\n????????? : " + name +
                "\n???????????? : " + createdAt +
                "\n??? ?????? : " + postBody +
                "\n----------------------------------" +
                "\ne.????????? ??????  d.????????? ??????" +
                "\nb.?????? ??????";
    }
    public String DetailPostToString() {
        return "?????? : " + postTitle +
                "\n????????? : " + username +
                "\n???????????? : " + createdAt +
                "\n??? ?????? : " + postBody +
                "\n----------------------------------";

    }

    public String findAnonymousToString() {
        return postId + "         " + postTitle + "          " +  "??????"   + "         " + createdAt;
    }

}