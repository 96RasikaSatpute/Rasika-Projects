package com.miniproject.bhojanamv3.data;

import com.miniproject.bhojanamv3.utils.AESUtils;
import java.util.HashMap;

public class UserData {
    String address;
    String distance;
    String first_login;
    String image_link;
    String latitude;
    String longitude;
    String mobile;
    String password;
    HashMap<String, CategoryData> skillData;
    String username;

    public UserData() {
    }

    public String getDistance() {
        try {
            return AESUtils.decrypt(this.distance);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public void setDistance(String distance2) {
        try {
            this.distance = AESUtils.encrypt(distance2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getFirst_login() {
        try {
            return AESUtils.decrypt(this.first_login);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public void setFirst_login(String first_login2) {
        try {
            this.first_login = AESUtils.encrypt(first_login2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public HashMap<String, CategoryData> getSkillData() {
        return this.skillData;
    }

    public void setSkillData(HashMap<String, CategoryData> skillData2) {
        this.skillData = skillData2;
    }

    public String getMobile() {
        try {
            return AESUtils.decrypt(this.mobile);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public void setMobile(String mobile2) {
        try {
            this.mobile = AESUtils.encrypt(mobile2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        try {
            return AESUtils.decrypt(this.username);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public void setUsername(String username2) {
        try {
            this.username = AESUtils.encrypt(username2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getPassword() {
        try {
            return AESUtils.decrypt(this.password);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public void setPassword(String password2) {
        try {
            this.password = AESUtils.encrypt(password2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getImage_link() {
        try {
            return AESUtils.decrypt(this.image_link);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public void setImage_link(String image_link2) {
        try {
            this.image_link = AESUtils.encrypt(image_link2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getLatitude() {
        try {
            return AESUtils.decrypt(this.latitude);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public void setLatitude(String latitude2) {
        try {
            this.latitude = AESUtils.encrypt(latitude2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getLongitude() {
        try {
            return AESUtils.decrypt(this.longitude);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public void setLongitude(String longitude2) {
        try {
            this.longitude = AESUtils.encrypt(longitude2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getAddress() {
        try {
            return AESUtils.decrypt(this.address);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public void setAddress(String address2) {
        try {
            this.address = AESUtils.encrypt(address2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public UserData(String username2, String mobile2, String password2, String image_link2, String first_login2, HashMap<String, CategoryData> skillData2, String latitude2, String longitude2, String address2, String distance2) {
        try {
            this.username = AESUtils.encrypt(username2);
            this.mobile = AESUtils.encrypt(mobile2);
            this.image_link = AESUtils.encrypt(image_link2);
            this.password = AESUtils.encrypt(password2);
            this.first_login = AESUtils.encrypt(first_login2);
            this.skillData = skillData2;
            this.latitude = AESUtils.encrypt(latitude2);
            this.longitude = AESUtils.encrypt(longitude2);
            this.address = AESUtils.encrypt(address2);
            this.distance = AESUtils.encrypt(distance2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
