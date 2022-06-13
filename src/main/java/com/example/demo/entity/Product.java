package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Data
public class Product {


    //    id varchar NOT NULL PRIMARY KEY,
//    name varchar NOT NULL,
//    price bigint,
//    image varchar,
//    category_id varchar,
//    description varchar,
//    quantity integer,
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private long price;
    @Column(name="img_url")
    private String img_url;
//    @Column(name = "description")
//    private String description;
    @Column(name = "quantity")
    private int quantity;
    @Column(name ="status")
    private boolean status;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_id" )
    private Category category;





}
