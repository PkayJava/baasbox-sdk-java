package com.angkorteam.baasbox.sdk.java.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by socheatkhauv on 1/14/16.
 */
public class SignupJson implements Serializable {

    @Expose
    @SerializedName("username")
    private String username;

    @Expose
    @SerializedName("password")
    private String password;

    @Expose
    @SerializedName("visibleByTheUser")
    private Map<String, Object> visibleByTheUser;

    @Expose
    @SerializedName("visibleByFriends")
    private Map<String, Object> visibleByFriends;

    @Expose
    @SerializedName("visibleByRegisteredUsers")
    private Map<String, Object> visibleByRegisteredUsers;

    @Expose
    @SerializedName("visibleByAnonymousUsers")
    private Map<String, Object> visibleByAnonymousUsers;

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

    public void setVisibleByTheUser(Map<String, Object> visibleByTheUser) {
        this.visibleByTheUser = visibleByTheUser;
    }

    public void setVisibleByFriends(Map<String, Object> visibleByFriends) {
        this.visibleByFriends = visibleByFriends;
    }

    public void setVisibleByRegisteredUsers(Map<String, Object> visibleByRegisteredUsers) {
        this.visibleByRegisteredUsers = visibleByRegisteredUsers;
    }

    public void setVisibleByAnonymousUsers(Map<String, Object> visibleByAnonymousUsers) {
        this.visibleByAnonymousUsers = visibleByAnonymousUsers;
    }
}
