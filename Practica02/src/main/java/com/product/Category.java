package com.product;

public class Category {
    private int category_id;
    private String category;

    public Category(int category_id, String category) {
        this.category_id = category_id;
        this.category = category;
    }

    public int getCategory_id() {
        return category_id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
	public String toString() {
		return "Category [category_id=" + category_id + ", category=" + category + "]";
	}
}
