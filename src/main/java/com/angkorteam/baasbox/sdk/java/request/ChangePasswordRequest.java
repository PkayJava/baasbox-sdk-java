package com.angkorteam.baasbox.sdk.java.request;

import java.io.Serializable;

/**
 * Created by socheatkhauv on 1/16/16.
 */
public class ChangePasswordRequest implements Serializable {

    private String oldPassword;

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
