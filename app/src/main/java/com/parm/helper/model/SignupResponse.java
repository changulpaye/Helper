package com.parm.helper.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by pchangul on 7/22/2016.
 */
public class SignupResponse {
    @SerializedName("data")
    @Expose
    public AuthenticateData data;

    public AuthenticateData getData() {
        return data;
    }

    public void setData(AuthenticateData data) {
        this.data = data;
    }
}

