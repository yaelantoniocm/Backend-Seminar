package com.product.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.api.entity.Category;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

@RestController
public class CtrlCategory {

    private Category[] categories = {
        new Category(1, "Abarrotes",1),
        new Category(2, "Electronicos",2),
        new Category(3, "Farmacia",3),
    };

    //Mostar todas las categorias.
    @GetMapping("/category")
    public List<Category> getCategories() {
        return Arrays.asList(categories);
    }

    //Muestra el category id que se le pasa como par ́ametro en la URL
    @GetMapping(path = "/{id}")
	public Integer readCategory(@PathVariable Integer id) {
		return id;
	}

    //Conseguir la categoria con el id especifico
    @GetMapping("/category/{id}")
    public ResponseEntity<Object> getCategory(@PathVariable int id) {
        for (Category i : categories) {
            if (i.getCategory_id() == id) {
                return new ResponseEntity<>(i, HttpStatus.OK);
            }
        }

        return null;
    }

    //Muestra el mensaje ’category created’ si se le pasa una categoría distinta a las del inciso a, en caso contrario, muestra el mensaje ’category already exist’.
    @PostMapping(path = "/create")
    public ResponseEntity<String> createCategory(@Valid @RequestBody Category category, BindingResult bindingResult) {

        String message = "";
        for (Category i : categories) {
            if (i.getCategory().equals(category.getCategory())) {
                message = "Category already exists";
                return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
            }
        }
        message = "Category created";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    //Muestra el mensaje ’category updated’ si se le pasa una categoría de las del inciso a, en caso contrario, muestra el mensaje ’category does not exist’.
    @PutMapping("/update/{category_id}")
    public ResponseEntity<String> updateCategory(@PathVariable int category_id, @Valid @RequestBody Category category, BindingResult bindingResult) {

        String message = "";
        for (Category i : categories) {
            if (i.getCategory_id() == category_id) {
                i.setCategory(category.getCategory());
                message = "Category updated";
                return new ResponseEntity<>(message, HttpStatus.OK);
            }
        }
        message = "Category not found";
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    //Muestra el mensaje ’category removed’ si se le pasa un id de categor ́ıa de las del inciso a, en caso contrario, muestra el mensaje ’category does not exist’.
    @DeleteMapping("/delete/{category_id}")
    public ResponseEntity<String> deleteCategory(@PathVariable int category_id) {
        String message = "";
        for (Category i : categories) {
            if (i.getCategory_id() == category_id) {
                i.setCategory("Deleted");
                message = "Category deleted";
                return new ResponseEntity<>(message, HttpStatus.OK);
            }
        }
        message = "Category not found";
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
    
}
