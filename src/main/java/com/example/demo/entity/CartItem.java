//package com.example.demo.entity;
//
//import lombok.Data;
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.math.BigDecimal;
//
//@Entity
//@Getter
//@Setter
//@Data
//public class CartItem {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Long id;
//    @Column(name = "price")
//    private BigDecimal price;
//    @Column(name = "img_url")
//    private String img_url;
//    @Column(name = "product_id")
//    private Long productId;
//
//    @ManyToOne
//    @JoinColumn(name = "cart_id")
//    private Cart cart;
//
//
//}
