package com.douzonetenten.tentenboardclient.dto;

public class UserRolesDto {
    private Long memberNo;
    private Long roleNo;

    public Long getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(Long memberNo) {
        this.memberNo = memberNo;
    }

    public Long getRoleNo() {
        return roleNo;
    }

    public void setRoleNo(Long roleNo) {
        this.roleNo = roleNo;
    }

    @Override
    public String toString() {
        return "UserRolesDto{" +
                "memberNo=" + memberNo +
                ", roleNo=" + roleNo +
                '}';
    }

    public UserRolesDto(Long memberNo, Long roleNo) {
        this.memberNo = memberNo;
        this.roleNo = roleNo;
    }
}
