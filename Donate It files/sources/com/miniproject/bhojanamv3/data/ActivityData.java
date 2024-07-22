package com.miniproject.bhojanamv3.data;

import java.util.ArrayList;

public class ActivityData {
    String activity_type;
    String description;
    String distance;
    String image_link;
    String latitude;
    String longitude;
    ArrayList<MatchData> match_data;
    String mobile;
    String skill;
    ArrayList<SubCategoryData> sub_skill_data;
    String timestamp;
    String type;
    String username;

    public ActivityData(String type2, String description2, String skill2, String timestamp2, ArrayList<SubCategoryData> sub_skill_data2, ArrayList<MatchData> match_data2, String username2, String mobile2, String latitude2, String longitude2, String image_link2, String distance2, String activity_type2) {
        this.type = type2;
        this.description = description2;
        this.skill = skill2;
        this.timestamp = timestamp2;
        this.sub_skill_data = sub_skill_data2;
        this.match_data = match_data2;
        this.username = username2;
        this.mobile = mobile2;
        this.latitude = latitude2;
        this.longitude = longitude2;
        this.image_link = image_link2;
        this.distance = distance2;
        this.activity_type = activity_type2;
    }

    public ActivityData() {
    }

    public String getActivity_type() {
        return this.activity_type;
    }

    public void setActivity_type(String activity_type2) {
        this.activity_type = activity_type2;
    }

    public String getDistance() {
        return this.distance;
    }

    public void setDistance(String distance2) {
        this.distance = distance2;
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

    public String getImage_link() {
        return this.image_link;
    }

    public void setImage_link(String image_link2) {
        this.image_link = image_link2;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type2) {
        this.type = type2;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description2) {
        this.description = description2;
    }

    public String getSkill() {
        return this.skill;
    }

    public void setSkill(String skill2) {
        this.skill = skill2;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(String timestamp2) {
        this.timestamp = timestamp2;
    }

    public ArrayList<SubCategoryData> getSub_skill_data() {
        return this.sub_skill_data;
    }

    public void setSub_skill_data(ArrayList<SubCategoryData> sub_skill_data2) {
        this.sub_skill_data = sub_skill_data2;
    }

    public ArrayList<MatchData> getMatch_data() {
        return this.match_data;
    }

    public void setMatch_data(ArrayList<MatchData> match_data2) {
        this.match_data = match_data2;
    }
}
