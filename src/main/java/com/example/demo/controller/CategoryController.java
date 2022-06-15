package com.example.demo.controller;

import com.example.demo.entity.Category;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getCategories(Category category)
    {
        List<Category> categoryList = service.getCategories();
        if(categoryList.isEmpty())
        {
            return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);
        }
         return new ResponseEntity<List<Category>>(categoryList, HttpStatus.OK) ;
    }

    @GetMapping("/category/{id}")
    public ResponseEntity getCateById(@PathVariable("id") long id)
    {
        System.out.println("Fetching Category with id " + id);

        Category category = service.getCateById(id);
//        System.out.println(category);
        if (category==null) {
            System.out.println("Category with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>( service.getCateById(id), HttpStatus.OK);
//        return new ResponseEntity<>(service.getCateById(id), HttpStatus.OK);
//        return repository.findById(id).toString() + id;

    }

    @PostMapping("category/create")
    public ResponseEntity  createCategory(@RequestBody Category category)
    {
//        return new ResponseEntity<>(service.createCategory(category), HttpStatus.OK);
        System.out.println("Creating Category " +category.getName());

        if (service.isCategoryExist(category)) {
            System.out.println("A Category with name " + category.getName() + " already exist");
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(ucBuilder.path("/category/{id}").buildAndExpand(category.getId()).toUri());
        return new ResponseEntity<>(service.saveCategory(category), HttpStatus.CREATED);
    }

    @DeleteMapping("category/delete/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable("id") long id )
    {
//        service.deleteCategory(id);
        System.out.println("Fetching & Deleting Category with id " + id);
//        System.out.println(service.getCateById(id));
        Category category = service.getCateById(id);
        if (category==null) {
            System.out.println("Unable to delete. Category with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.deleteCategory(id);
        return new ResponseEntity<Category>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("category/update/{id}")
     public ResponseEntity<Category>  updateCAtegory(@PathVariable long id, @RequestBody Category category) {

        System.out.println("Updating Category " + id);

        Category currentCategory = service.getCateById(id);
//        System.out.println("---"+currentCategory);
        if (currentCategory==null) {
            System.out.println("Category with id " + id + " not found");
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }

        currentCategory.setName(category.getName());
        return new ResponseEntity<>(service.saveCategory(currentCategory), HttpStatus.OK);
    }

}
