package com.parm.helper.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Output {

    @SerializedName("count")
    @Expose
    private int count;


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


}