package com.example.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@Setter
@Data
public class UserTb {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    String name;
    @Column(name = "dob")
    Date dob;
    @Column(name = "phone")
    String phone;
    @Column(name = "email")
    String email;
    @Column(name = "address")
    String address;
    @Column(name = "status")
    boolean status;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

}
