package com.example.demo.controller;

import com.example.demo.entity.Category;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")

public class CategoryController {

    @Autowired
    private CategoryService service;


    @GetMapping("/categories")
    public ResponseEntity<List<Category>> findCategories(Category category)
    {
        List<Category> categoryList = service.getCategories();
        if(categoryList.isEmpty())
        {
            return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);
        }
         return new ResponseEntity<List<Category>>(categoryList, HttpStatus.OK) ;
    }

    @GetMapping("/category/{id}")
    public ResponseEntity findCategoryById(@PathVariable("id") long id)
    {
        System.out.println("Fetching Category with id " + id);

        Category category = service.getCategoryById(id);
//        System.out.println(category);
        if (category==null) {
            System.out.println("Category with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>( service.getCategoryById(id), HttpStatus.OK);

    }

    @PostMapping("category/create")
    public ResponseEntity  createCategory(@RequestBody Category category)
    {

        System.out.println("Creating Category " +category.getName());

        if (service.isCategoryNameExist(category)) {
            System.out.println("A Category with name " + category.getName() + " already exist");
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(service.saveCategory(category), HttpStatus.CREATED);
    }

    @DeleteMapping("category/delete/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable("id") long id )
    {

        System.out.println("Fetching & Deleting Category with id " + id);
        Category category = service.getCategoryById(id);
        if (category==null) {
            System.out.println("Unable to delete. Category with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.deleteCategory(id);
        return new ResponseEntity<Category>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("category/update/{id}")
     public ResponseEntity<Category>  updateCategory(@PathVariable long id, @RequestBody Category category) {

        System.out.println("Updating Category " + id);

        Category currentCategory = service.getCategoryById(id);

        if (currentCategory==null) {
            System.out.println("Category with id " + id + " not found");
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }

        currentCategory.setName(category.getName());
        return new ResponseEntity<>(service.saveCategory(currentCategory), HttpStatus.OK);
    }

}
