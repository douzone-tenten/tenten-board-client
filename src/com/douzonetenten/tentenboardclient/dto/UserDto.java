package com.douzonetenten.tentenboardclient.dto;

import java.sql.Timestamp;
public class UserDto {
    private Long userNo;
    private String username; // ID
    private String password; // 비밀번호
    private String name; // 실명
    private String department; // 반
    private Long roleNo; // 권한번호

    public void setRoleNo(Long roleNo) {
        this.roleNo = roleNo;
    }

    public Long getRoleNo() {
        return roleNo;
    }

    private Timestamp createdAt;

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