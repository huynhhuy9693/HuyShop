package com.example.demo.service;


import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;

    public List<Category> getCategories(Category category)
    {
        return  repository.findAll();
    }


    public Optional<Category> getCateById(@PathVariable("id") int id)
    {
//        return new ResponseEntity<>(repository.getById(id), HttpStatus.OK);
//        return repository.findById(id).toString() + id;
        Optional<Category> otp = repository.findById(id) ;
        return otp;


    }

    public Category createCategory(@RequestBody Category category)
    {

        return repository.save(category) ;

    }

    public void deleteCategory(@PathVariable("id") int id )
    {
        repository.deleteById(id);
    }


    public Category updateCAtegory(@RequestBody Category category ,@PathVariable int id)
    {
        if(category.getId()==id)
        {
            repository.findById(id);
            category.setName(category.getName());
            repository.save(category);

        }
        return repository.save(category);
    }

}
