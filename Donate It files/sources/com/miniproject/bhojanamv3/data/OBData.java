package com.miniproject.bhojanamv3.data;

public class OBData {
    String des;
    int image;
    String title;

    public OBData(String title2, String des2, int image2) {
        this.title = title2;
        this.des = des2;
        this.image = image2;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title2) {
        this.title = title2;
    }

    public String getDes() {
        return this.des;
    }

    public void setDes(String des2) {
        this.des = des2;
    }

    public int getImage() {
        return this.image;
    }

    public void setImage(int image2) {
        this.image = image2;
    }
}
