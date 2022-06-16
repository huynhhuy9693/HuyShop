package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserTbDTO implements Serializable {


    private Long id;
    private String name;
    private String phone;
    private Date dob;
    private String address;
    private String email;
    private boolean status;
    private String userName;
    private String passWord;
    private RoleDTO roleDTO;

//    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
//    public UserTbDTO() {
//    }
//
//    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
//    public UserTbDTO(Long id, String name, String phone, String address, String email, boolean status, String userName, String passWord, RoleDTO roleId) {
//        this.id = id;
//        this.name = name;
//        this.phone = phone;
//        this.address = address;
//        this.email = email;
//        this.status = status;
//        this.userName = userName;
//        this.passWord = passWord;
//        this.roleId = roleId;
//    }
}

