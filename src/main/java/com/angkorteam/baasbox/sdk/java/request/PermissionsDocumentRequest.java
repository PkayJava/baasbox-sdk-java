package com.angkorteam.baasbox.sdk.java.request;

import com.angkorteam.baasbox.sdk.java.enums.ActionEnum;

import java.io.Serializable;

/**
 * Created by socheatkhauv on 1/19/16.
 */
public class PermissionsDocumentRequest implements Serializable {

    private String collection;

    private String id;

    private ActionEnum action;

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

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
