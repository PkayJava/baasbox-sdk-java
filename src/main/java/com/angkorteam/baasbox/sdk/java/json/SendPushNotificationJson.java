package com.angkorteam.baasbox.sdk.java.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by socheatkhauv on 1/18/16.
 */
public class SendPushNotificationJson implements Serializable {

    @Expose
    @SerializedName("message")
    private String message;

    @Expose
    @SerializedName("users")
    private List<String> users;

    @Expose
    @SerializedName("profiles")
    private List<Integer> profiles;

    @Expose
    @SerializedName("sound")
    private String sound;

    @Expose
    @SerializedName("badge")
    private Integer badge;

    @Expose
    @SerializedName("actionLocalizedKey")
    private String actionLocalizedKey;

    @Expose
    @SerializedName("localizedKey")
    private String localizedKey;

    @Expose
    @SerializedName("localizedArguments")
    private List<String> localizedArguments;

    @Expose
    @SerializedName("collapse_key")
    private String collapseKey;

    @Expose
    @SerializedName("custom")
    private Map<String, Object> custom;

    @Expose
    @SerializedName("time_to_live")
    private Long timeToLive;

    @Expose
    @SerializedName("content-available")
    private Integer contentAvailable;

    @Expose
    @SerializedName("category")
    private String category;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }

    public List<Integer> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Integer> profiles) {
        this.profiles = profiles;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public Integer getBadge() {
        return badge;
    }

    public void setBadge(Integer badge) {
        this.badge = badge;
    }

    public String getActionLocalizedKey() {
        return actionLocalizedKey;
    }

    public void setActionLocalizedKey(String actionLocalizedKey) {
        this.actionLocalizedKey = actionLocalizedKey;
    }

    public String getLocalizedKey() {
        return localizedKey;
    }

    public void setLocalizedKey(String localizedKey) {
        this.localizedKey = localizedKey;
    }

    public List<String> getLocalizedArguments() {
        return localizedArguments;
    }

    public void setLocalizedArguments(List<String> localizedArguments) {
        this.localizedArguments = localizedArguments;
    }

    public String getCollapseKey() {
        return collapseKey;
    }

    public void setCollapseKey(String collapseKey) {
        this.collapseKey = collapseKey;
    }

    public Map<String, Object> getCustom() {
        return custom;
    }

    public void setCustom(Map<String, Object> custom) {
        this.custom = custom;
    }

    public Long getTimeToLive() {
        return timeToLive;
    }

    public void setTimeToLive(Long timeToLive) {
        this.timeToLive = timeToLive;
    }

    public Integer getContentAvailable() {
        return contentAvailable;
    }

    public void setContentAvailable(Integer contentAvailable) {
        this.contentAvailable = contentAvailable;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
