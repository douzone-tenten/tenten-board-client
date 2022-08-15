package com.uni.tentenProject.model.dto;

public class RolesDto {

    private long roleNo;
    private String roleName;

    public RolesDto(long roleNo, String roleName) {
        this.roleNo = roleNo;
        this.roleName = roleName;
    }

    public long getRoleNo() {
        return roleNo;
    }

    public void setRoleNo(long roleNo) {
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
}
