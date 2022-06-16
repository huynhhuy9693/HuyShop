package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Long id;
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
    @Column(name = "user_name")
    private String userName;
    @Column(name = "pass_word")
    private String passWord;
//    @Column(name = "role")
//    private int role;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role roleId;

//    @OneToOne(mappedBy = "user")
//    private Cart cart;


}
