package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Setter
@Getter
@Data
public class Product {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name="img_url")
    private String img_url;

    @Column(name = "quantity")
    private int quantity;

    @ColumnDefault("true")
    @Column(name ="status")
    private boolean status;

//    @Column(name = "product_id")
//    int productId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_id" )
    private Category category;


    @PrePersist
    void onPrePersist() {
        if (status==false) {
            status=true;
        }
    }




}
