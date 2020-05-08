package com.evan.login.result;

public class RoleResult {
    private int roleId;

    public RoleResult(int roleId) {
        this.roleId = roleId;
    }

    public int getCode() {
        return roleId;
    }

    public void setCode(int code) {
        this.roleId = roleId;
    }
}
