package com.example.demo.controller;

import com.example.demo.entity.UserTb;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/users")
    public ResponseEntity getUsers()
    {
        return  new ResponseEntity<>(service.getUsers(), HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity getUserById(@PathVariable long id)
    {
        return new ResponseEntity<>(service.getUserById(id),HttpStatus.OK);
    }

    @PostMapping("/user/create")
    public ResponseEntity saveUser(@RequestBody UserTb user)
    {
        return new ResponseEntity<>(service.saveUser(user),HttpStatus.OK);
    }

    @DeleteMapping("/user/delete/{id}")
    public void deleteUser(@PathVariable long id)
    {
        service.deleteUser(id);
    }

    @PutMapping("/user/update/{id}")
    public ResponseEntity updateUser(@RequestBody UserTb user , @PathVariable long id)
    {
        return new ResponseEntity<>(service.updateUser(user, id),HttpStatus.OK);
    }


}
