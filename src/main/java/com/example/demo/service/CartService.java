package com.example.demo.service;

import com.example.demo.repository.CartRepository;
import com.example.demo.entity.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository repository;

    public List<Cart> getCarts()
    {
        return repository.findAll();
    }

    public Optional<Cart> getCartById(Long id)
    {
        return repository.findById(id);
    }

    public Cart saveCart(Cart cart)
    {
        return repository.save(cart);
    }

    public void deleteCart(Long id)
    {
        repository.deleteById(id);
    }

    public Cart editCart(Cart cart, Long id)
    {
        repository.findById(id);
        cart.setStatus(cart.isStatus());
        return repository.save(cart);
    }
}
