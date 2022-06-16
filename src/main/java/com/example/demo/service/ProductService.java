package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;
    @Autowired
    CategoryRepository categoryRepository;

    public List<Product> getProducts()
    {
        categoryRepository.findAll();
        return repository.findAll();

    }


    public Product getProductById(long id)
    {

        for(Product product : repository.findAll())
        {
            if(product.getId()==id)
            {
                return product;
            }
        }
        return null;
    }
    public boolean isIdExits(Product product)
    {
        return getProductById(product.getId())==null;
    }


    public Product saveProduct(Product product)
    {
        return repository.save(product) ;
    }

    public void deleteProduct(Long id)
    {
        repository.deleteById(id);
    }


    public Product findByName(String name) {
        for(Product product : repository.findAll()){
            if(product.getName().equalsIgnoreCase(name)){
                return product;
            }
        }
        return null;
    }
    public boolean isProductExist(ProductDTO productDTO) {
        return findByName(productDTO.getName())!=null;
    }


}
