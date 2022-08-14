package com.douzonetenten.tentenboardclient.dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class UserDto {
    /**
     * Wrapper Class Type
     */
    private Long userNo; // user 고유값 Auto Increment
    private String username; // ID
    private String password; // 비밀번호
    private String name; // 실명
    private String department; // 부서
    private Timestamp createdAt; // Date class 보다는 LocalDateTime class 사용 적극권장.

    public Long getUserNo() {
        return userNo;
    }

    public void setUserNo(Long userNo) {
        this.userNo = userNo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "memberNo=" + userNo +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}