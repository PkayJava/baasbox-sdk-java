package com.angkorteam.baasbox.sdk.java.request;

import com.angkorteam.baasbox.sdk.java.enums.ActionEnum;

import java.io.Serializable;

/**
 * Created by socheatkhauv on 1/19/16.
 */
public class FileAccessRequest implements Serializable {

    private String id;

    private ActionEnum action;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ActionEnum getAction() {
        return action;
    }

    public void setAction(ActionEnum action) {
        this.action = action;
    }
}
