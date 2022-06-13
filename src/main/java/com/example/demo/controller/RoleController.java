package com.example.demo.controller;

import com.example.demo.entity.Role;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RoleController {

    @Autowired
    private RoleService service;

    @GetMapping("/roles")
    public ResponseEntity getRoles() {
        return new ResponseEntity<>(service.getRoles(), HttpStatus.OK);
    }

    @GetMapping("/role/{id}")
    public ResponseEntity getRoleById(@PathVariable int id)
    {
        return new ResponseEntity<>(service.getRoleById(id),HttpStatus.OK);
    }

    @PostMapping("/role/create")
    public ResponseEntity saveRole(@RequestBody Role role)
    {
        return new ResponseEntity<>(service.saveRole(role),HttpStatus.OK);
    }

    @DeleteMapping("/role/delete/{id}")
    public void deleteRole(@PathVariable int id)
    {
        service.deteleRole(id);
    }

    @PutMapping("/role/update/{id}")
    public ResponseEntity updateRole(@RequestBody Role role , @PathVariable int id)
    {
        return  new ResponseEntity<>( service.updateRole(role,id),HttpStatus.OK);
    }
}
