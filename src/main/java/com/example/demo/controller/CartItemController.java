package com.example.demo.controller;

import com.example.demo.service.CartItemService;
import com.example.demo.entity.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartItemController {
    @Autowired
    private CartItemService service;
    @GetMapping("/cartItems")
    public ResponseEntity getCartItems()
    {
        return new ResponseEntity<>(service.getCartItems(), HttpStatus.OK);
    }

    @GetMapping("/cartItem/{id}")
    public ResponseEntity getCartItemById(@PathVariable Long id)
    {
        return new ResponseEntity<>(service.getCartItemById(id),HttpStatus.OK);
    }

    @PostMapping("/cartItem/create")
    public ResponseEntity saveCartItem(@RequestBody CartItem cartItem)
    {
        return new ResponseEntity<>(service.saveCart(cartItem),HttpStatus.OK);
    }

    @DeleteMapping("cartItem/delete/{id}")
    public void deleteCartItem(@PathVariable Long id)
    {
        service.deleteCartItem(id);
    }

    @PutMapping("/cartItem/update/{id}")
    public ResponseEntity updateCartItem(@RequestBody CartItem cartItem, @PathVariable Long id)
    {
        return new ResponseEntity<>(service.editCartItem(cartItem,id),HttpStatus.OK);
    }
}
