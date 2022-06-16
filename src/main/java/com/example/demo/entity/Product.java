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
//@Setter
//@Getter
//@Data
//public class Product {
//
//
//    //    id varchar NOT NULL PRIMARY KEY,
////    name varchar NOT NULL,
////    price bigint,
////    image varchar,
////    category_id varchar,
////    description varchar,
////    quantity integer,
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private long id;
//    @Column(name = "name")
//    private String name;
//    @Column(name = "price")
//    private BigDecimal price;
//    @Column(name="img_url")
//    private String img_url;
////    @Column(name = "description")
////    private String description;
//    @Column(name = "quantity")
//    private int quantity;
//    @Column(name ="status")
//    private boolean status;
//    @Column(name = "product_id")
//    int productId;
//
//    @ManyToOne
//    @JoinColumn(name = "category_id" )
//    private Category category;
//
//
//
//
//
//
//
//}
