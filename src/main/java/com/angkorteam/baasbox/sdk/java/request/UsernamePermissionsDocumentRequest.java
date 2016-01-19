package com.angkorteam.baasbox.sdk.java.request;

import java.io.Serializable;

/**
 * Created by socheatkhauv on 1/19/16.
 */
public class UsernamePermissionsDocumentRequest extends GrantPermissionsDocumentRequest {

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
