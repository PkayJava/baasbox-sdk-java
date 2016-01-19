package com.angkorteam.baasbox.sdk.java.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by socheatkhauv on 1/16/16.
 */
public class ChangePasswordJson implements Serializable {

    @Expose
    @SerializedName("old")
    private String oldPassword;

    @Expose
    @SerializedName("new")
    private String newPassword;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
