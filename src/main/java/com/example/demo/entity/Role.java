package com.example.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@Data
public class Role {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private int id ;
        @Column(name = "name")
        private String name;

        @OneToMany(mappedBy = "role" , cascade = CascadeType.ALL)
        private List<UserTb> user;

}
