package com.parm.helper.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by PARAM on 7/22/2016.
 */
public class AuthenticateData {
    @SerializedName("message")
    @Expose
    public String message;
    @SerializedName("body")
    @Expose
    public AuthenticateBody body;
    @SerializedName("code")
    @Expose
    public Integer code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AuthenticateBody getBody() {
        return body;
    }

    public void setBody(AuthenticateBody body) {
        this.body = body;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
