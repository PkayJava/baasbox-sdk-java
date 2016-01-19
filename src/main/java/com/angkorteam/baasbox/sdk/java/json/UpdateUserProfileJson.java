package com.angkorteam.baasbox.sdk.java.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by socheatkhauv on 1/14/16.
 */
public class UpdateUserProfileJson implements Serializable {

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

    public Map<String, Object> getVisibleByTheUser() {
        return visibleByTheUser;
    }

    public void setVisibleByTheUser(Map<String, Object> visibleByTheUser) {
        this.visibleByTheUser = visibleByTheUser;
    }

    public Map<String, Object> getVisibleByFriends() {
        return visibleByFriends;
    }

    public void setVisibleByFriends(Map<String, Object> visibleByFriends) {
        this.visibleByFriends = visibleByFriends;
    }

    public Map<String, Object> getVisibleByRegisteredUsers() {
        return visibleByRegisteredUsers;
    }

    public void setVisibleByRegisteredUsers(Map<String, Object> visibleByRegisteredUsers) {
        this.visibleByRegisteredUsers = visibleByRegisteredUsers;
    }

    public Map<String, Object> getVisibleByAnonymousUsers() {
        return visibleByAnonymousUsers;
    }

    public void setVisibleByAnonymousUsers(Map<String, Object> visibleByAnonymousUsers) {
        this.visibleByAnonymousUsers = visibleByAnonymousUsers;
    }
}
