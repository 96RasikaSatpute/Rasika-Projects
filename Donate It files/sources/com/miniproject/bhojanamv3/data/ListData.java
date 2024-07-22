package com.miniproject.bhojanamv3.data;

import java.util.ArrayList;

public class ListData {
    String catgeory;
    String description;
    String distance;
    String image_link;
    String latitude;
    String longitude;
    String mobile;
    String status;
    ArrayList<SubCategoryData> sub_catgeory_data;
    String timestamp;
    String username;

    public ListData() {
    }

    public ListData(String username2, String mobile2, String image_link2, String description2, String catgeory2, String latitude2, String longitude2, String timestamp2, String distance2, ArrayList<SubCategoryData> sub_catgeory_data2, String status2) {
        this.username = username2;
        this.mobile = mobile2;
        this.image_link = image_link2;
        this.description = description2;
        this.catgeory = catgeory2;
        this.latitude = latitude2;
        this.longitude = longitude2;
        this.timestamp = timestamp2;
        this.distance = distance2;
        this.sub_catgeory_data = sub_catgeory_data2;
        this.status = status2;
    }

    public String getCatgeory() {
        return this.catgeory;
    }

    public void setCatgeory(String catgeory2) {
        this.catgeory = catgeory2;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status2) {
        this.status = status2;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username2) {
        this.username = username2;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile2) {
        this.mobile = mobile2;
    }

    public String getImage_link() {
        return this.image_link;
    }

    public void setImage_link(String image_link2) {
        this.image_link = image_link2;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description2) {
        this.description = description2;
    }

    public String getCategory() {
        return this.catgeory;
    }

    public void setCategory(String catgeory2) {
        this.catgeory = catgeory2;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public void setLatitude(String latitude2) {
        this.latitude = latitude2;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public void setLongitude(String longitude2) {
        this.longitude = longitude2;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(String timestamp2) {
        this.timestamp = timestamp2;
    }

    public String getDistance() {
        return this.distance;
    }

    public void setDistance(String distance2) {
        this.distance = distance2;
    }

    public ArrayList<SubCategoryData> getSub_catgeory_data() {
        return this.sub_catgeory_data;
    }

    public void setSub_catgeory_data(ArrayList<SubCategoryData> sub_catgeory_data2) {
        this.sub_catgeory_data = sub_catgeory_data2;
    }

    public String toString() {
        return "ListData{username='" + this.username + '\'' + ", mobile='" + this.mobile + '\'' + ", image_link='" + this.image_link + '\'' + ", description='" + this.description + '\'' + ", catgeory='" + this.catgeory + '\'' + ", latitude='" + this.latitude + '\'' + ", longitude='" + this.longitude + '\'' + ", timestamp='" + this.timestamp + '\'' + ", distance='" + this.distance + '\'' + ", status='" + this.status + '\'' + ", sub_catgeory_data=" + this.sub_catgeory_data + '}';
    }
}
