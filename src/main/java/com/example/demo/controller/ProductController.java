package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import com.example.demo.dto.ProductDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class ProductController {
    @Autowired
    private ProductService service;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CategoryService categoryService;



    @GetMapping("/products")
    public String findProducts(Model model)
    {

//        List<Product> productList = service.getProducts();
//        if(productList.isEmpty())
//        {
//            return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<List<Product>>(productList, HttpStatus.OK) ;
        System.out.println("product_list");
        model.addAttribute("products", service.getProducts());
        return "admin/product_list";
    }

    @GetMapping("/create_product")
    public String showAddProduct(Model model)
    {
        Product product = new Product();
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.getCategories());
        return "admin/create_product";
    }

    @GetMapping("/product/{id}")
    public ResponseEntity findProductById(@PathVariable("id") long id)
    {
        System.out.println("Fetching Product with id " + id);

        Product product = service.getProductById(id);

        if (product==null) {
            System.out.println("Product with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>( service.getProductById(id), HttpStatus.OK);


    }

    @PostMapping("product/create")
    public String  createProduct( @ModelAttribute("product") Product product )
    {

        System.out.println("Creating Product " +product.getName());

//        if (service.isProductExist(productDTO)) {
//            System.out.println("A Product with name " + productDTO.getName() + " already exist");
//            return new ResponseEntity<>(HttpStatus.CONFLICT);
//        }
//        Product productRequest = modelMapper.map(productDTO, Product.class);
//        Product product = service.saveProduct(productRequest);
//        // convert entity to DTO
//        ProductDTO productResponse = modelMapper.map(product, ProductDTO.class);
//        return new ResponseEntity<ProductDTO>(productResponse, HttpStatus.CREATED);
//        model.addAttribute("categories", categoryService.getCategories());
            service.saveProduct(product);
            return "redirect:/admin/products";
    }

    @GetMapping ("product/delete/{id}")
    public String deleteProduct(@PathVariable("id") long id )
    {
        System.out.println("Fetching & Deleting Products with id " + id);
        Product product = service.getProductById(id);
//        if (product==null) {
//            System.out.println("Unable to delete. Product with id " + id + " not found");
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
        service.deleteProduct(id);
//        return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
        return "redirect:/admin/products";
    }
    @GetMapping("product/details/{id}")
    public String detailProduct(@PathVariable Long id, Model model)
    {
        System.out.println("product id " + id);
        model.addAttribute("product",service.getProductById(id));
        model.addAttribute("categories",categoryService.getCategories());
        return "admin/update_product.html";
    }

    @PostMapping("product/update/{id}")
    public String updateProduct(@RequestParam ("id") long id, @ModelAttribute("product") Product product) {

        System.out.println("Updating Product " + id);

//        Product currentProduct = service.getProductById(id);
//        if (currentProduct==null) {
//            System.out.println("Product with id " + id + " not found");
//            return new ResponseEntity<ProductDTO>(HttpStatus.NOT_FOUND);
//        }

//        currentProduct.setName(productDTO.getName());
//        currentProduct.setPrice(productDTO.getPrice());
//        currentProduct.setQuantity(productDTO.getQuantity());
//        currentProduct.setStatus(productDTO.isStatus());
//        currentProduct.setImg_url(productDTO.getImg_url());
//        currentProduct.setCategory(categoryService.getCategoryById(productDTO.getId()));
//        Product productRequest = modelMapper.map(productDTO, Product.class);
//        Product product = service.saveProduct(productRequest);
//        // convert entity to DTO
//        ProductDTO productResponse = modelMapper.map(product, ProductDTO.class);
//        return new ResponseEntity<ProductDTO>(productResponse,HttpStatus.OK);
        service.saveProduct(product);
        return "redirect:/admin/products";
    }
}
