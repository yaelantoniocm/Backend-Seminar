package com.product.api.service;

import java.util.List;

import com.product.api.entity.Category;

public interface SvcCategory {

    List<Category> getCategories();

    Category getCategory(Integer category_id);

    String createCategory(Category category);

    String updateCategory(Integer category_id, Category category);

    String deleteRegion(Integer category_id);

}
