package com.angkorteam.baasbox.sdk.java.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by socheatkhauv on 1/14/16.
 */
public class StringResponse extends Response {

    @Expose
    @SerializedName("data")
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
