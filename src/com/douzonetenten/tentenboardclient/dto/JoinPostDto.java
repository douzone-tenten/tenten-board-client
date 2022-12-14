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
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
        String createdStr = simpleDateFormat.format(createdAt);

        return String.format("%-15s", postId) + String.format("%-15s", postTitle)
                + String.format("%-15s", username) + createdStr;

    }

    //수연 게시글 상세보기 테스트 TODO : 개행이 요상하다.
    public String findSelectDetailPostToString(){
        return "게시글 번호 : " + postId + "\n" + "제         목 : " + postTitle + "\n"
                + "작   성   자 : " + name + " (" +  username + ") " + "\n"
                + "작 성 시 간 : " + createdAt + "\n\n"
                + "글    내  용 : " + postBody;
    }

    public String detailPostToString() {
        return "제목 : " + postTitle +
                "\n작성자 : " + name +
                "\n작성시간 : " + createdAt +
                "\n글 내용 : " + postBody +
                "\n----------------------------------" +
                "\ne.게시글 수정  d.게시글 삭제" +
                "\nb.뒤로 가기";
    }
    public String DetailPostToString() {
        return "제목 : " + postTitle +
                "\n작성자 : " + username +
                "\n작성시간 : " + createdAt +
                "\n글 내용 : " + postBody +
                "\n----------------------------------";

    }

    public String findAnonymousToString() {
        return postId + "         " + postTitle + "          " +  "익명"   + "         " + createdAt;
    }

}