package com.angkorteam.baasbox.sdk.java.request;

import java.io.Serializable;

/**
 * Created by socheatkhauv on 1/19/16.
 */
public class GrantPermissionsDocumentRequest implements Serializable {

    private String collection;

    private String id;

    private String action;

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

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        if (action == null || !(action.equals("read") && action.equals("update") && action.equals("delete") && action.equals("all"))) {
            throw new RuntimeException("all, read, update and delete are available in the moment");
        }
        this.action = action;
    }
}