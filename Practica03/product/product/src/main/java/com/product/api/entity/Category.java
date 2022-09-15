package com.product.api.entity;

public class Category {
    private Integer category_id;
    private String category;
    private Integer status;

    public Category(Integer category_id, String category, Integer status) {
        this.category_id = category_id;
        this.category = category;
        this.status = status;
    }

    public Integer getCategoryId() {
        return this.category_id;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategoryId(Integer category_id) {
        this.category_id = category_id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    
    @Override
    public String toString(){
        return "Category [category_id=" + category_id + ", category=" + category + ", status=" + status + "]";
    }
    
}
