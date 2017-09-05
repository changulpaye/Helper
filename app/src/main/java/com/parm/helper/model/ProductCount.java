package com.parm.helper.model;

import android.icu.util.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

/**
 * Created by sashahan on 9/4/2017.
 */

public class ProductCount {

    @SerializedName("out")
    @Expose
    private Output output;

    @SerializedName("output")
    @Expose
    private Map<String, Integer> categoryCount;


    public Output getOutput() {
        return output;
    }

    public void setOutput(Output output) {
        this.output = output;
    }


    public Map<String, Integer> getCategoryCount() {
        return categoryCount;
    }

    public void setCategoryCount(Map<String, Integer> categoryCount) {
        this.categoryCount = categoryCount;
    }
}
