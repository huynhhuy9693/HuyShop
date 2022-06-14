package com.example.demo.service;

import com.example.demo.repository.CartItemRepository;
import com.example.demo.entity.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartItemService
{
    @Autowired
    private CartItemRepository repository;

    public List<CartItem> getCartItems()
    {
        return repository.findAll();
    }

    public Optional<CartItem> getCartItemById(Long id)
    {
        return repository.findById(id);
    }

    public CartItem saveCart(CartItem cartItem)
    {
        return repository.save(cartItem);
    }

    public void deleteCartItem(Long id)
    {
        repository.deleteById(id);
    }

    public CartItem editCartItem(CartItem cartItem, Long id)
    {
        repository.findById(id);
        return repository.save(cartItem);
    }
}
