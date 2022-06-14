package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
     private ProductRepository repository;
    @Autowired
    private CategoryRepository repositoryCategory;

    public List<Product> getProducts()
    {
        return  repository.findAll();
    }

    public Optional<Product> getProductById(long id)
    {
        return repository.findById(id);
    }

    public void deleteProductById(long id)
    {
        repository.deleteById(id);
    }

    public Product saveProducts(Product product)
    {
        repositoryCategory.findAll();
        return repository.save(product);
    }

    public Product updateProduts(long id, Product product)
    {
        repository.findById(id);
        product.setName(product.getName());
        product.setPrice(product.getPrice());
        product.setQuantity(product.getQuantity());
        product.setImg_url(product.getImg_url());
        product.setStatus(product.isStatus());
        product.setCategory(product.getCategory());
        return repository.save(product);
    }


}
