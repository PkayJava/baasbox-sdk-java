package com.angkorteam.baasbox.sdk.java.request;

/**
 * Created by socheatkhauv on 1/19/16.
 */
public class RoleNameFileAccessRequest extends FileAccessRequest {

    private String rolename;

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
