//package com.example.demo.service;
//
//import com.example.demo.entity.CartItem;
//import com.example.demo.repository.CartItemRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import java.util.List;
//
//@Service
//public class CartItemService
//{
//    @Autowired
//    private CartItemRepository repository;
//
//    public List<CartItem> getCartItems()
//    {
//        return repository.findAll();
//
//    }
//
//
//    public CartItem getCartItemById(@PathVariable("id") long id)
//    {
//
//        for(CartItem  cartItem: repository.findAll())
//        {
//            if(cartItem.getId()==id)
//            {
////                System.out.println("=="+category);
//                return cartItem;
//
//            }
//        }
//        return null;
//    }
//    public boolean isIdExits(CartItem cartItem)
//    {
//        return getCartItemById(cartItem.getId())==null;
//    }
//
//
//    public CartItem saveCartItem(@RequestBody CartItem cartItem)
//    {
//
//        return repository.save(cartItem) ;
//
//    }
//
//    public void deleteCartItem(@PathVariable("id") long id )
//    {
//        repository.deleteById(id);
//    }
//}
