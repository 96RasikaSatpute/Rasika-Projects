package com.miniproject.bhojanamv3.data;

public class MatchData {
    String image_link;
    String latitude;
    String longitude;
    String mobile;
    String timestamp;
    String username;

    public MatchData(String username2, String mobile2, String image_link2, String latitude2, String longitude2, String timestamp2) {
        this.username = username2;
        this.mobile = mobile2;
        this.image_link = image_link2;
        this.latitude = latitude2;
        this.longitude = longitude2;
        this.timestamp = timestamp2;
    }

    public MatchData() {
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(String timestamp2) {
        this.timestamp = timestamp2;
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
}
