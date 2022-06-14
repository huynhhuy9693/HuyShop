package com.example.demo.controller;

import com.example.demo.service.CartService;
import com.example.demo.entity.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {

    @Autowired
    private CartService service;
    @GetMapping("/carts")
    public ResponseEntity getCarts()
    {
        return new ResponseEntity<>(service.getCarts(), HttpStatus.OK);
    }

    @GetMapping("/cart/{id}")
    public ResponseEntity getCartById(@PathVariable Long id)
    {
        return new ResponseEntity<>(service.getCartById(id),HttpStatus.OK);
    }

    @PostMapping("/cart/create")
    public ResponseEntity saveCart(@RequestBody Cart cart)
    {
        return new ResponseEntity<>(service.saveCart(cart),HttpStatus.OK);
    }

    @DeleteMapping("cart/delete/{id}")
    public void deleteCart(@PathVariable Long id)
    {
        service.deleteCart(id);
    }

    @PutMapping("/cart/update/{id}")
    public ResponseEntity updateCart(@RequestBody Cart cart, @PathVariable Long id)
    {
        return new ResponseEntity<>(service.editCart(cart,id),HttpStatus.OK);
    }
}
