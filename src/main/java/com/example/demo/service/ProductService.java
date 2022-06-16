//package com.example.demo.service;
//
//import com.example.demo.entity.Product;
//import com.example.demo.repository.CategoryRepository;
//import com.example.demo.repository.ProductRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import java.util.List;
//
//@Service
//public class ProductService {
//    @Autowired
//    private ProductRepository repository;
//    @Autowired
//    private CategoryRepository categoryRepository;
//
//    public List<Product> getProducts()
//    {
//        categoryRepository.findAll();
//        return repository.findAll();
//
//    }
//
//
//    public Product getProductById(@PathVariable("id") long id)
//    {
//
//        for(Product product : repository.findAll())
//        {
//            if(product.getId()==id)
//            {
////                System.out.println("=="+category);
//                return product;
//
//            }
//        }
//        return null;
//    }
////    public boolean isIdExits(Product product)
////    {
////        return getProductById(product.getId())==null;
////    }
//
//
//    public Product saveProduct(@RequestBody Product product)
//    {
//
//        return repository.save(product) ;
//
//    }
//
//    public void deleteProduct(@PathVariable("id") long id )
//    {
//        repository.deleteById(id);
//    }
//
//
//
//
//    public Product findByName(String name) {
//        for(Product product : repository.findAll()){
//            if(product.getName().equalsIgnoreCase(name)){
//                return product;
//            }
//        }
//        return null;
//    }
//    public boolean isProductExist(Product product) {
//        return findByName(product.getName())!=null;
//    }
//
//
//}
