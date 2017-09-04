package com.parm.helper.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class ProductResponse {

    @SerializedName("endDate")
    @Expose
    private Date endDate;
    @SerializedName("startDate")
    @Expose
    private Date startDate;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("name")
    @Expose
    private String name;

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}