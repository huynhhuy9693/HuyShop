package com.example.demo.controller;

import com.example.demo.entity.UserTb;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/users")
    public ResponseEntity<List<UserTb>> findUsers(UserTb user)
    {
        List<UserTb> userTbList = service.getUsers();
        if(userTbList.isEmpty())
        {
            return new ResponseEntity<List<UserTb>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<UserTb>>(userTbList, HttpStatus.OK) ;
    }

    @GetMapping("/user/{id}")
    public ResponseEntity findUserById(@PathVariable("id") long id)
    {
        System.out.println("Fetching User with id " + id);

        UserTb users = service.getUserById(id);
//        System.out.println(category);
        if (users==null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>( service.getUserById(id), HttpStatus.OK);
//        return new ResponseEntity<>(service.getCateById(id), HttpStatus.OK);
//        return repository.findById(id).toString() + id;

    }

    @PostMapping("user/create")
    public ResponseEntity  createUser(@RequestBody UserTb user)
    {
//        return new ResponseEntity<>(service.createCategory(category), HttpStatus.OK);
        System.out.println("Creating User " +user.getName());

        if (service.isUserExist(user)) {
            System.out.println("A User with name " + user.getName() + " already exist");
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(ucBuilder.path("/category/{id}").buildAndExpand(category.getId()).toUri());
        return new ResponseEntity<>(service.saveUser(user), HttpStatus.CREATED);
    }

    @DeleteMapping("user/delete/{id}")
    public ResponseEntity<UserTb> deleteUser(@PathVariable("id") long id )
    {
//        service.deleteCategory(id);
        System.out.println("Fetching & Deleting User with id " + id);
//        System.out.println(service.getCateById(id));
        UserTb user = service.getUserById(id);
        if (user==null) {
            System.out.println("Unable to delete. User with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.deleteUser(id);
        return new ResponseEntity<UserTb>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("user/update/{id}")
    public ResponseEntity<UserTb>  updateUser(@PathVariable long id, @RequestBody UserTb user) {

        System.out.println("Updating User " + id);

        UserTb currentUser = service.getUserById(id);
//        System.out.println("---"+currentCategory);
        if (currentUser==null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<UserTb>(HttpStatus.NOT_FOUND);
        }

        currentUser.setName(user.getName());
        currentUser.setDob(user.getDob());
        currentUser.setAddress(user.getAddress());
        currentUser.setPhone(user.getPhone());
        currentUser.setEmail(user.getEmail());
        currentUser.setRole(user.getRole());
        currentUser.setUserName(user.getUserName());
        currentUser.setPassWord(user.getPassWord());

        return new ResponseEntity<>(service.saveUser(currentUser), HttpStatus.OK);
    }


}
