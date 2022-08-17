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
}