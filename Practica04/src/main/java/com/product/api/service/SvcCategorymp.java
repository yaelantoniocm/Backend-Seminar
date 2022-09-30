package com.product.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.api.entity.Category;
import com.product.api.repository.RepoCategory;

@Service
public class SvcCategorymp implements SvcCategory {

    @Autowired
    RepoCategory repoCategory;

    @Override
    public List<Category> getCategories() {
        return repoCategory.findByStatus(1);
    }

    @Override
    public Category getCategory(Integer category_id) {
        return repoCategory.findByCategoryId(category_id);
    }

    @Override
    public String createCategory(Category category) {
        Category categorySaved = (Category) repoCategory.findByCategory(category.getCategory());
        if (categorySaved != null) {
            if (categorySaved.getStatus() == 0) {
                repoCategory.activeCategory(categorySaved.getCategory_id());
            }
            return "Category already exists";
            // } else {
            // return "region already exists";
        }

        repoCategory.createCategory(category.getCategory());
        return "region created";
    }

    @Override
    public String updateCategory(Integer category_id, Category category) {
        Category categorySaved = (Category) repoCategory.findByCategoryId(category_id);

        if (categorySaved == null) {
            return "region does not exist";
        } else {
            if (categorySaved.getStatus() == 0) {
                return "region is not active";

            } else {
                categorySaved = (Category) repoCategory.findByCategory(category.getCategory());
                if (categorySaved != null) {
                    return "region already exists";
                }
                repoCategory.updateCategory(category_id, category.getCategory());
                return "region updated";
            }

        }
    }

    @Override
    public String deleteRegion(Integer category_id) {
        Category categorySaved = (Category) repoCategory.findByCategoryId(category_id);
        if (categorySaved == null) {
            return "region does not exist";
        } else {
            repoCategory.deleteById(category_id);
            return "region deleted";
        }

    }

}
