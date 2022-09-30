package com.product.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.api.entity.Category;
import com.product.api.service.SvcCategory;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/category")
public class CtrlCategory {

    @Autowired
    SvcCategory svcCategory;

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getCategories() {
        return new ResponseEntity<>(svcCategory.getCategories(), HttpStatus.OK);
    }

    // Muestra el category id que se le pasa como parámetro en la URL
    @GetMapping(path = "/{category_id}")
    public Integer readCategory(@PathVariable Integer category_id) {
        return category_id;
    }

    // Conseguir la categoria con el id especifico
    @GetMapping("/getid/{category_id}")
    public ResponseEntity<Category> getCategory(@PathVariable int category_id) {
        return new ResponseEntity<>(svcCategory.getCategory(category_id), HttpStatus.OK);
    }

    // Muestra el mensaje ’category created’ si se le pasa una categoría distinta a
    // las del inciso a, en caso contrario, muestra el mensaje ’category already
    // exist’.
    @PostMapping(path = "/create")
    public ResponseEntity<String> createCategory(@Valid @RequestBody Category category, BindingResult bindingResult) {

        String message = "";

        if (bindingResult.hasErrors()) {

            message = bindingResult.getAllErrors().get(0).getDefaultMessage();
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(svcCategory.createCategory(category), HttpStatus.OK);
    }

    // Muestra el mensaje ’category updated’ si se le pasa una categoría de las del
    // inciso a, en caso contrario, muestra el mensaje ’category does not exist’.
    @PutMapping("/update/{category_id}")
    public ResponseEntity<String> updateCategory(@PathVariable int category_id, @Valid @RequestBody Category category,
            BindingResult bindingResult) {

        String message = "";

        if (bindingResult.hasErrors()) {

            message = bindingResult.getAllErrors().get(0).getDefaultMessage();
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(svcCategory.updateCategory(category_id, category), HttpStatus.OK);
    }

    // Muestra el mensaje ’category removed’ si se le pasa un id de categor ́ıa de
    // las del inciso a, en caso contrario, muestra el mensaje ’category does not
    // exist’.
    @DeleteMapping("/delete/{category_id}")
    public ResponseEntity<String> deleteCategory(@PathVariable int category_id) {

        return new ResponseEntity<>(svcCategory.deleteRegion(category_id), HttpStatus.OK);
    }

}
