package com.angkorteam.baasbox.sdk.java.request;

/**
 * Created by socheatkhauv on 1/19/16.
 */
public class UsernameFileAccessRequest extends GrantPermissionsDocumentRequest {

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
