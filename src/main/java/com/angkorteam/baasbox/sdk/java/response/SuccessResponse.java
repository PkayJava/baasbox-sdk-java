package com.angkorteam.baasbox.sdk.java.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

/**
 * Created by socheatkhauv on 1/13/16.
 */
public class SuccessResponse extends Response {

    @Expose
    @SerializedName("data")
    private Map<String, Object> data;

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
