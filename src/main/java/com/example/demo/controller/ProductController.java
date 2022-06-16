//package com.example.demo.controller;
//
//import com.example.demo.entity.Product;
//import com.example.demo.service.ProductService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//public class ProductController {
//    @Autowired
//    private ProductService service;
//
//    @GetMapping("/products")
//    public ResponseEntity<List<Product>> findProducts(Product product)
//    {
//        List<Product> productList = service.getProducts();
//        if(productList.isEmpty())
//        {
//            return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<List<Product>>(productList, HttpStatus.OK) ;
//    }
//
//    @GetMapping("/product/{id}")
//    public ResponseEntity findProductById(@PathVariable("id") long id)
//    {
//        System.out.println("Fetching Product with id " + id);
//
//        Product product = service.getProductById(id);
////        System.out.println(category);
//        if (product==null) {
//            System.out.println("Product with id " + id + " not found");
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>( service.getProductById(id), HttpStatus.OK);
////        return new ResponseEntity<>(service.getCateById(id), HttpStatus.OK);
////        return repository.findById(id).toString() + id;
//
//    }
//
//    @PostMapping("product/create")
//    public ResponseEntity  saveCategory(@RequestBody Product product)
//    {
////       return new ResponseEntity<>(service.createCategory(category), HttpStatus.OK);
//        System.out.println("Creating Product " +product.getName());
//
//        if (service.isProductExist(product)) {
//            System.out.println("A Product with name " + product.getName() + " already exist");
//            return new ResponseEntity<>(HttpStatus.CONFLICT);
//        }
////        HttpHeaders headers = new HttpHeaders();
////        headers.setLocation(ucBuilder.path("/category/{id}").buildAndExpand(category.getId()).toUri());
//        return new ResponseEntity<>(service.saveProduct(product), HttpStatus.CREATED);
//    }
//
//    @DeleteMapping("product/delete/{id}")
//    public ResponseEntity<Product> deleteCategory(@PathVariable("id") long id )
//    {
////        service.deleteCategory(id);
//        System.out.println("Fetching & Deleting Product with id " + id);
////        System.out.println(service.getCateById(id));
//        Product product = service.getProductById(id);
//        if (product==null) {
//            System.out.println("Unable to delete. Products with id " + id + " not found");
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        service.deleteProduct(id);
//        return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
//    }
//
//    @PutMapping("product/update/{id}")
//    public ResponseEntity<Product>  updateProduct(@PathVariable long id, @RequestBody Product product) {
//
//        System.out.println("Updating Product " + id);
//
//        Product currentProduct = service.getProductById(id);
////        System.out.println("---"+currentCategory);
//        if (currentProduct==null) {
//            System.out.println("Product with id " + id + " not found");
//            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
//        }
//
//        currentProduct.setName(product.getName());
//        currentProduct.setPrice(product.getPrice());
//        currentProduct.setQuantity(product.getQuantity());
//        currentProduct.setStatus(product.isStatus());
//        currentProduct.setImg_url(product.getImg_url());
//        currentProduct.setProductId(product.getProductId());
//
//        return new ResponseEntity<>(service.saveProduct(currentProduct), HttpStatus.OK);
//    }
//
//}
