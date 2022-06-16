package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "status")
    private boolean status;
    @Column(name = "total_price")
    private long totalPrice;
    @Column(name = "order_number")
    private String orderNumber;

//    @ManyToOne
//    @JoinColumn(name = "customer_id")
//    private Customer customer;


    @OneToOne()
    @JoinColumn(name = "user_id")
    private UserTb user;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<CartItem> cartItems;
}
