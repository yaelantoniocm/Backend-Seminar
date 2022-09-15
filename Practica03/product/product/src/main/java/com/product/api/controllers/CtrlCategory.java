package com.product.api.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.product.api.entity.Category;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class CtrlCategory {
    private Category[] categories = {
            new Category(1, "Nada",1),
            new Category(2, "Nada",2),
            new Category(3, "Nada",3),
    };

    //Mostar todas las categorias.
    @GetMapping("/category")
    public List<Category> getCategories() {
        return Arrays.asList(categories);
    }

    //Conseguir la categoria con el id especifico
    @GetMapping("/category/{id}")
    public ResponseEntity<Object> getCategory(@PathVariable int id) {
        for (Category i : categories) {
            if (i.getCategoryId() == id) {
                return new ResponseEntity<>(i, HttpStatus.OK);
            }
        }

        return null;
    }
    
    //Crear la categoria
    @PostMapping("/create")
    public ResponseEntity<Object> createCategory(@RequestBody Category category) {
        String message = "";
        for (Category i : categories) {
            if (i.getCategoryId() == category.getCategoryId()) {
                message = "Category already exists";
                return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
            }
        }
        message = "Category created";
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
    
    //Actualizar la categoria
    @PutMapping
    public ResponseEntity<Object> updateCategory(@PathVariable int id, @RequestBody Category category) {
        String message = "";
        for (Category i : categories) {
            if (i.getCategoryId() == id) {
                i.setCategory(category.getCategory());
                message = "Category updated";
                return new ResponseEntity<>(i, HttpStatus.OK);
            }
        }
        message = "Category not found";
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Object> deleteCategory(@PathVariable int id) {
        String message = "";
        for (Category i : categories) {
            if (i.getCategoryId() == id) {
                i.setCategory("Deleted");
                message = "Category deleted";
                return new ResponseEntity<>(i, HttpStatus.OK);
            }
        }
        message = "Category not found";
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

}
