package com.angkorteam.baasbox.sdk.java.request;

/**
 * Created by socheatkhauv on 1/19/16.
 */
public class UsernamePermissionsDocumentRequest extends PermissionsDocumentRequest {

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
