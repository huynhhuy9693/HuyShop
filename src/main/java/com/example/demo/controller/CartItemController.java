package com.example.demo.controller;

import com.example.demo.entity.CartItem;
import com.example.demo.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartItemController {
    @Autowired
    private CartItemService service;

    @GetMapping("/cart_items")
    public ResponseEntity<List<CartItem>> findCategories(CartItem cartItem)
    {
        List<CartItem> cartItems = service.getCartItems();
        if(cartItems.isEmpty())
        {
            return new ResponseEntity<List<CartItem>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<CartItem>>(cartItems, HttpStatus.OK) ;
    }

    @GetMapping("/cart_item/{id}")
    public ResponseEntity findCartItemById(@PathVariable("id") long id)
    {
        System.out.println("Fetching Cart_Item with id " + id);

        CartItem cartItem = service.getCartItemById(id);
//        System.out.println(category);
        if (cartItem==null) {
            System.out.println("Cart_Item with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>( service.getCartItemById(id), HttpStatus.OK);
//        return new ResponseEntity<>(service.getCateById(id), HttpStatus.OK);
//        return repository.findById(id).toString() + id;

    }

    @PostMapping("cart_item/create")
    public ResponseEntity  createCartItem(@RequestBody CartItem cartItem)
    {
        return new ResponseEntity<>(service.saveCartItem(cartItem), HttpStatus.CREATED);
    }

    @DeleteMapping("cart_item/delete/{id}")
    public ResponseEntity<CartItem> deleteCartItem(@PathVariable("id") long id )
    {

        System.out.println("Fetching & Deleting Cart_Item with id " + id);
//        System.out.println(service.getCateById(id));
        CartItem cartItem = service.getCartItemById(id);
        if (cartItem==null) {
            System.out.println("Unable to delete. Cart_Item with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.deleteCartItem(id);
        return new ResponseEntity<CartItem>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("cart_item/update/{id}")
    public ResponseEntity<CartItem>  updateCartItem(@PathVariable long id, @RequestBody CartItem cartItem) {

        System.out.println("Updating Cart_Item " + id);

        CartItem currentCartItem = service.getCartItemById(id);
//        System.out.println("---"+currentCategory);
        if (currentCartItem==null) {
            System.out.println("Cart_Item with id " + id + " not found");
            return new ResponseEntity<CartItem>(HttpStatus.NOT_FOUND);
        }

        currentCartItem.setProductId(cartItem.getProductId());
        return new ResponseEntity<>(service.saveCartItem(cartItem), HttpStatus.OK);
    }
}
