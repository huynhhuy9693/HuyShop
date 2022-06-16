//package com.example.demo.service;
//
//
//import com.example.demo.entity.Category;
//import com.example.demo.repository.CategoryRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import java.util.List;
//
//@Service
//public class CategoryService {
//    @Autowired
//    private CategoryRepository repository;
//
//    public List<Category> getCategories()
//    {
//
//        return repository.findAll();
//
//    }
//
//
//    public Category getCateById(@PathVariable("id") long id)
//    {
//
//        for(Category category : repository.findAll())
//        {
//            if(category.getId()==id)
//            {
////                System.out.println("=="+category);
//                return category;
//
//            }
//        }
//        return null;
//    }
//    public boolean isIdExits(Category category)
//    {
//        return getCateById(category.getId())==null;
//    }
//
//
//    public Category saveCategory(@RequestBody Category category)
//    {
//
//        return repository.save(category) ;
//
//    }
//
//    public void deleteCategory(@PathVariable("id") long id )
//    {
//        repository.deleteById(id);
//    }
//
//
//
//
//    public Category findByName(String name) {
//        for(Category category : repository.findAll()){
//            if(category.getName().equalsIgnoreCase(name)){
//                return category;
//            }
//        }
//        return null;
//    }
//    public boolean isCategoryExist(Category category) {
//        return findByName(category.getName())!=null;
//    }
//
//}
