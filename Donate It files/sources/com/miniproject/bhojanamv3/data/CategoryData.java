package com.miniproject.bhojanamv3.data;

public class CategoryData {
    String category_id;
    String category_image;
    String category_name;
    boolean isCategorySelected;

    public boolean isCategorySelected() {
        return this.isCategorySelected;
    }

    public void setCategorySelected(boolean categorySelected) {
        this.isCategorySelected = categorySelected;
    }

    public CategoryData(String category_id2, String category_image2, String category_name2) {
        this.category_id = category_id2;
        this.category_image = category_image2;
        this.category_name = category_name2;
    }

    public CategoryData() {
    }

    public String getCategory_id() {
        return this.category_id;
    }

    public void setCategory_id(String category_id2) {
        this.category_id = category_id2;
    }

    public String getCategory_image() {
        return this.category_image;
    }

    public void setCategory_image(String category_image2) {
        this.category_image = category_image2;
    }

    public String getCategory_name() {
        return this.category_name;
    }

    public void setCategory_name(String category_name2) {
        this.category_name = category_name2;
    }
}
