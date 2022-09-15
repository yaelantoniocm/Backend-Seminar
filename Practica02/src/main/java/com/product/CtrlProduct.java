package com.product;

import java.util.ArrayList;
import org.json.*;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;


public class CtrlProduct {

    private ArrayList<Category> categories;

    public CtrlProduct() {
        categories = new ArrayList<Category>();
    }


    private boolean existe(int category_id) {
        for (Category category : this.categories) {
            if (category.getCategory_id() == category_id) {
                return true;
            }
        }
        return false;
    }

    public void createCategory(int category_id, String category) {
        if (!existe(category_id)) {
            this.categories.add(new Category(category_id, category));
        }else{
            System.out.println("Ya existe una categoria con ese ID");
        }
    }
    

    public void getCategory(int category_id) {
        for (Category c : categories) {
            if (c.getCategory_id() == category_id) {
                System.out.println(c.getCategory());
            } else {
                System.out.println("No existe una categoria con el ID ingresado");
            }
        }
    }

    public void deleteCategory(int category_id) {
        for (Category c : categories) {
            if (c.getCategory_id() == category_id) {
                this.categories.remove(c);
            } else {
                System.out.println("No existe una categoria con el ID ingresado");
            }
        }
    }
    
    
    public void getCategories() {
        if (categories.isEmpty()) {
            System.out.println("No hay categorias");
        } else {
            for (Category c : categories) {
                System.out.println(c.getCategory());
            }
        }
    }

    public JSONArray categoriesJSON(){
        JSONArray json = new JSONArray();
        if (categories.isEmpty()) {
            return json;
        }
        for (Category category : categories) {
            JSONObject categoryJSON = new JSONObject();
            categoryJSON.put("category_id", category.getCategory_id());
            categoryJSON.put("category", category.getCategory());
            json.put(categoryJSON);
        }
        return json;  
    }


}
