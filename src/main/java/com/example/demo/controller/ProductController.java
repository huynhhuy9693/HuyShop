package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/products")
    public ResponseEntity getProducts()
    {
        return new ResponseEntity<>(service.getProducts(), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity getProduct(@PathVariable long id)
    {
        return new ResponseEntity<>(service.getProductById(id), HttpStatus.OK);
    }
    @DeleteMapping("/product/delete/{id}")
    public  void deleteProduct(@PathVariable long id)
    {
        service.deleteProductById(id);
    }

    @PostMapping("/product/create")
    public ResponseEntity createProducts(@RequestBody Product product )
    {
        return new ResponseEntity<>(service.saveProducts(product),HttpStatus.OK);
    }

    @PutMapping("/product/update/{id}")
    public ResponseEntity updateProducts(@RequestBody Product product , @PathVariable long id)
    {

        return new ResponseEntity<>(service.updateProduts(id,product),HttpStatus.OK);

    }
//    @GetMapping("/category/{id}/product")
//    public ResponseEntity findByCategoryId(@PathVariable int id, Product product)
//    {
//        return new ResponseEntity<>(service.findProductByCategoryId(id, product),HttpStatus.OK);
//    }
}
