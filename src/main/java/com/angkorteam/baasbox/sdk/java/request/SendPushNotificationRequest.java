package com.angkorteam.baasbox.sdk.java.request;

import java.io.Serializable;
import java.util.*;

/**
 * Created by socheatkhauv on 1/18/16.
 */
public class SendPushNotificationRequest implements Serializable {

    private String message;

    private List<String> users = new LinkedList<String>();

    private List<Integer> profiles = new LinkedList<Integer>();

    private String sound;

    private Integer badge;

    private String actionLocalizedKey;

    private String localizedKey;

    private List<String> localizedArguments = new LinkedList<String>();

    private String collapseKey;

    private Map<String, Object> custom = new LinkedHashMap<String, Object>();

    private Long timeToLive;

    private Integer contentAvailable;

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

    public List<Integer> getProfiles() {
        return profiles;
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

    public String getCollapseKey() {
        return collapseKey;
    }

    public void setCollapseKey(String collapseKey) {
        this.collapseKey = collapseKey;
    }

    public Map<String, Object> getCustom() {
        return custom;
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
