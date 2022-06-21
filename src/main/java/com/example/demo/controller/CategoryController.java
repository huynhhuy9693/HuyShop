package com.example.demo.controller;

import com.example.demo.entity.Category;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")

public class CategoryController {

    @Autowired
    private CategoryService service;


    @GetMapping("/categories")
    public String findCategories(Model model)
    {
//        List<Category> categoryList = service.getCategories();
//        if(categoryList.isEmpty())
//        {
//            return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);
//        }
//         return new ResponseEntity<List<Category>>(categoryList, HttpStatus.OK) ;
        List<Category> categoryList = service.getCategories();
        model.addAttribute("categories",categoryList);
        System.out.println("list-category-view");
        return "admin/category_list";
    }

    @GetMapping("/create_category")
    public String showAddCategory(Model model)
    {

        Category category = new Category();
        model.addAttribute("category", category);
        return "admin/create_category";
    }

    @GetMapping("/category/{id}")
    public ResponseEntity findCategoryById(@PathVariable("id") Long id)
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
    public String  createCategory(@ModelAttribute("category") Category category)
    {

        System.out.println("create");
        System.out.println("Creating Category " +category.getName());

        service.saveCategory(category);
        return "redirect:/admin/categories";

//        if (service.isCategoryNameExist(category)) {
//            System.out.println("A Category with name " + category.getName() + " already exist");
//            return new ResponseEntity<>(HttpStatus.CONFLICT);
//        }
//        return new ResponseEntity<>(service.saveCategory(category), HttpStatus.CREATED);

    }

    @GetMapping("category/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id )
    {

        System.out.println("Fetching & Deleting Category with id " + id);
        Category category = service.getCategoryById(id);
//        if (category==null) {
//            System.out.println("Unable to delete. Category with id " + id + " not found");
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
        service.deleteCategory(id);
//        return new ResponseEntity<Category>(HttpStatus.NO_CONTENT);
        return "redirect:/admin/categories";
    }

    @GetMapping("category/details/{id}")
    public String detailCategory(@PathVariable Long id, Model model)
    {
        System.out.println("category_update " + id);
        model.addAttribute("category",service.getCategoryById(id));
        return "admin/update_category";
    }

    @PostMapping("category/update/{id}")
     public String  updateCategory(@RequestParam("id") Long id, @ModelAttribute("category") Category category) {

        System.out.println("Updating Category "  + id);

//        Category currentCategory = service.getCategoryById(id);

//        if (currentCategory==null) {
//            System.out.println("Category with id " + id + " not found");
//            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
//        }

//        currentCategory.setName(category.getName());
        service.saveCategory(category);
//        return new ResponseEntity<>(service.saveCategory(currentCategory), HttpStatus.OK);
        return "redirect:/admin/categories";
    }

}
