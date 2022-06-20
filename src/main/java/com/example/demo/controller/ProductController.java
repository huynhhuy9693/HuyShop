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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService service;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CategoryService categoryService;



    @GetMapping("/products")
    public ResponseEntity<List<Product>> findProducts(Product product)
    {
        List<Product> productList = service.getProducts();
        if(productList.isEmpty())
        {
            return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Product>>(productList, HttpStatus.OK) ;
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
    public ResponseEntity  createProduct(@RequestBody ProductDTO productDTO )
    {

        System.out.println("Creating Product " +productDTO.getName());

        if (service.isProductExist(productDTO)) {
            System.out.println("A Product with name " + productDTO.getName() + " already exist");
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        Product productRequest = modelMapper.map(productDTO, Product.class);
        Product product = service.saveProduct(productRequest);
        // convert entity to DTO
        ProductDTO productResponse = modelMapper.map(product, ProductDTO.class);
        return new ResponseEntity<ProductDTO>(productResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("product/delete/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") long id )
    {
        System.out.println("Fetching & Deleting Products with id " + id);
        Product product = service.getProductById(id);
        if (product==null) {
            System.out.println("Unable to delete. Product with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.deleteProduct(id);
        return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("product/update/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable long id, @RequestBody ProductDTO productDTO) {

        System.out.println("Updating Product " + id);

        Product currentProduct = service.getProductById(id);
        if (currentProduct==null) {
            System.out.println("Product with id " + id + " not found");
            return new ResponseEntity<ProductDTO>(HttpStatus.NOT_FOUND);
        }

        currentProduct.setName(productDTO.getName());
        currentProduct.setPrice(productDTO.getPrice());
        currentProduct.setQuantity(productDTO.getQuantity());
        currentProduct.setStatus(productDTO.isStatus());
        currentProduct.setImg_url(productDTO.getImg_url());
        currentProduct.setCategory(categoryService.getCategoryById(productDTO.getId()));


        Product productRequest = modelMapper.map(productDTO, Product.class);
        Product product = service.saveProduct(productRequest);
        // convert entity to DTO
        ProductDTO productResponse = modelMapper.map(product, ProductDTO.class);
        return new ResponseEntity<ProductDTO>(productResponse,HttpStatus.OK);
    }
}
