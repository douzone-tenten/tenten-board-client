package com.uni.tentenProject.model.dto;

public class userRolesDto {

    private long userMemberNO;
    private long rolesRoleNo;

    public userRolesDto(long userMemberNO, long rolesRoleNo) {
        this.userMemberNO = userMemberNO;
        this.rolesRoleNo = rolesRoleNo;
    }

    public long getUserMemberNO() {
        return userMemberNO;
    }

    public void setUserMemberNO(long userMemberNO) {
        this.userMemberNO = userMemberNO;
    }

    public long getRolesRoleNo() {
        return rolesRoleNo;
    }

    public void setRolesRoleNo(long rolesRoleNo) {
        this.rolesRoleNo = rolesRoleNo;
    }

    @Override
    public String toString() {
        return "userRolesDto{" +
                "userMemberNO=" + userMemberNO +
                ", rolesRoleNo=" + rolesRoleNo +
                '}';
    }
}
