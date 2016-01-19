package com.angkorteam.baasbox.sdk.java.request;

import java.io.Serializable;

/**
 * Created by socheatkhauv on 1/16/16.
 */
public class ChangeUsernameRequest implements Serializable {

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
