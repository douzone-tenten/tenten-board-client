package com.douzonetenten.tentenboardclient.dto;

public class RolesDto {
    private Long roleNo; // 권한번호
    private String roleName; // 권한이름

    public Long getRoleNo() {
        return roleNo;
    }

    public void setRoleNo(Long roleNo) {
        this.roleNo = roleNo;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "RolesDto{" +
                "roleNo=" + roleNo +
                ", roleName='" + roleName + '\'' +
                '}';
    }

    public RolesDto(Long roleNo, String roleName) {
        this.roleNo = roleNo;
        this.roleName = roleName;
    }
}
