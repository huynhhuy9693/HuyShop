//package com.example.demo.controller;
//
//import com.example.demo.entity.Cart;
//import com.example.demo.service.CartService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//public class CartController {
//
//    @Autowired
//    private CartService service;
//
//    @GetMapping("/carts")
//    public ResponseEntity<List<Cart>> findCarts(Cart cart)
//    {
//        List<Cart> cartList = service.getCarts();
//        if(cartList.isEmpty())
//        {
//            return new ResponseEntity<List<Cart>>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<List<Cart>>(cartList, HttpStatus.OK) ;
//    }
//
//    @GetMapping("/cart/{id}")
//    public ResponseEntity getCartById(@PathVariable("id") long id)
//    {
//        System.out.println("Fetching Cart with id " + id);
//
//        Cart cart = service.getCartById(id);
////        System.out.println(category);
//        if (cart==null) {
//            System.out.println("Cart with id " + id + " not found");
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>( service.getCartById(id), HttpStatus.OK);
////        return new ResponseEntity<>(service.getCateById(id), HttpStatus.OK);
////        return repository.findById(id).toString() + id;
//
//    }
//
//    @PostMapping("cart/create")
//    public ResponseEntity  createCart(@RequestBody Cart cart)
//    {
//        return new ResponseEntity<>(service.saveCart(cart), HttpStatus.CREATED);
//    }
//
//    @DeleteMapping("cart/delete/{id}")
//    public ResponseEntity<Cart> deleteCart(@PathVariable("id") long id )
//    {
////        service.deleteCategory(id);
//        System.out.println("Fetching & Deleting Cart with id " + id);
////        System.out.println(service.getCateById(id));
//        Cart cart = service.getCartById(id);
//        if (cart==null) {
//            System.out.println("Unable to delete. Cart with id " + id + " not found");
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        service.deleteCart(id);
//        return new ResponseEntity<Cart>(HttpStatus.NO_CONTENT);
//    }
//
//    @PutMapping("cart/update/{id}")
//    public ResponseEntity<Cart>  updateCart(@PathVariable long id, @RequestBody Cart cart) {
//
//        System.out.println("Updating Cart " + id);
//
//        Cart currentCart = service.getCartById(id);
////        System.out.println("---"+currentCategory);
//        if (currentCart==null) {
//            System.out.println("Cart with id " + id + " not found");
//            return new ResponseEntity<Cart>(HttpStatus.NOT_FOUND);
//        }
//
//        currentCart.setStatus(cart.isStatus());
//
//        return new ResponseEntity<>(service.saveCart(currentCart), HttpStatus.OK);
//    }
//
//}
