package com.parm.helper.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by PARAM on 7/22/2016.
 */
public class SignUpRequest {
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String password;
}
