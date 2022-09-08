package com.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
//@SpringBootApplication
public class ProductApplication {

	//@GetMapping("/product")
	@RequestMapping(value = "/category", method = RequestMethod.GET, produces = "application/json")
	public String category() {
		CtrlProduct categories = new CtrlProduct();
		categories.createCategory(1, "Abarrotes");
		categories.createCategory(2, "Electronica");
		categories.createCategory(3, "Línea Blanca");
		
		//return categories.toString();
		return categories.getCategoriesJSON().toString();
		
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}
	
}
