package com.example.demo.controller;

import com.example.demo.entity.Category;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping("/categories")
    public ResponseEntity getCategories(Category category)
    {
         return new ResponseEntity<>(service.getCategories(category), HttpStatus.OK) ;
    }

    @GetMapping("/category/{id}")
    public ResponseEntity getCateById(@PathVariable("id") int id)
    {
        return new ResponseEntity<>(service.getCateById(id), HttpStatus.OK);
//        return repository.findById(id).toString() + id;

    }

    @PostMapping("category/create")
    public ResponseEntity  createCategory(@RequestBody Category category)
    {
        return new ResponseEntity<>(service.createCategory(category), HttpStatus.OK);
    }

    @DeleteMapping("category/delete/{id}")
    public void deleteCategory(@PathVariable("id") int id )
    {
        service.deleteCategory(id);
    }

    @PutMapping("category/update/{id}")
     public ResponseEntity  updateCAtegory(@RequestBody Category category ,@PathVariable int id)
    {
        if(category.getId()==id)
        {
                return new ResponseEntity<>(service.updateCAtegory(category,id),HttpStatus.OK);
        }

                return new ResponseEntity<>(service.createCategory(category),HttpStatus.OK);
    }


}
