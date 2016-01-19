package com.angkorteam.baasbox.sdk.java.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by socheatkhauv on 1/14/16.
 */
public class SignupRequest implements Serializable {

    private String username;

    private String password;

    private Map<String, Object> visibleByTheUser = new LinkedHashMap<String, Object>();

    private Map<String, Object> visibleByFriends = new LinkedHashMap<String, Object>();

    private Map<String, Object> visibleByRegisteredUsers = new LinkedHashMap<String, Object>();

    private Map<String, Object> visibleByAnonymousUsers = new LinkedHashMap<String, Object>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Map<String, Object> getVisibleByTheUser() {
        return visibleByTheUser;
    }

    public Map<String, Object> getVisibleByFriends() {
        return visibleByFriends;
    }

    public Map<String, Object> getVisibleByRegisteredUsers() {
        return visibleByRegisteredUsers;
    }

    public Map<String, Object> getVisibleByAnonymousUsers() {
        return visibleByAnonymousUsers;
    }
}
