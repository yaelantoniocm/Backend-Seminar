package com.product.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.product.api.dto.ApiResponse;
import com.product.api.entity.Category;
import com.product.api.repository.RepoCategory;
import com.product.exception.ApiException;

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
        Category category = repoCategory.findByCategoryId(category_id);
        if (category == null) {
            throw new ApiException(HttpStatus.NOT_FOUND, "Category does not exist");
        } else {
            return category;
        }
    }

    @Override
    public ApiResponse createCategory(Category category) {
        Category categorySaved = (Category) repoCategory.findByCategory(category.getCategory());
        if (categorySaved != null) {
            if (categorySaved.getStatus() == 0) {
                repoCategory.activeCategory(categorySaved.getCategory_id());
                return new ApiResponse("Category activated");
            } else {
                throw new ApiException(HttpStatus.BAD_REQUEST, "Category already exist");
            }
        }
        repoCategory.createCategory(category.getCategory());
        return new ApiResponse("Category created");
    }

    @Override
    public ApiResponse updateCategory(Integer category_id, Category category) {
        Category categorySaved = (Category) repoCategory.findByCategoryId(category_id);

        if (categorySaved == null) {
            throw new ApiException(HttpStatus.NOT_FOUND, "Category does not exist");
        } else {
            if (categorySaved.getStatus() == 0) {
                throw new ApiException(HttpStatus.BAD_REQUEST, "Category is not active");

            } else {
                categorySaved = (Category) repoCategory.findByCategory(category.getCategory());
                if (categorySaved != null) {
                    throw new ApiException(HttpStatus.BAD_REQUEST, "Category already exist");
                }
                repoCategory.updateCategory(category_id, category.getCategory());
                return new ApiResponse("Category updated");
            }

        }
    }

    @Override
    public ApiResponse deleteRegion(Integer category_id) {
        Category categorySaved = (Category) repoCategory.findByCategoryId(category_id);
        if (categorySaved == null) {
            throw new ApiException(HttpStatus.NOT_FOUND, "Category does not exist");
        } else {
            repoCategory.deleteById(category_id);
            return new ApiResponse("Category deleted");
        }

    }

}
