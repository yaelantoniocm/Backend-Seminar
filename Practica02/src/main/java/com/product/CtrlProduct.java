package com.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CtrlProduct {

	public static final Category[] categories = { 	new Category(1, "Abarrotes"), new Category(2, "Categoria 02"),  
													new Category(3, "Categoria 03"), new Category(4, "Categoria 05")  
												};
	
    
    @GetMapping(value = "/category")
	public Category[] getCategories() {
		return categories;
	}

}

