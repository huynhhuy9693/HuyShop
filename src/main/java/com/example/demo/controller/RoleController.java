package com.example.demo.controller;

import com.example.demo.entity.Role;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleController {

    @Autowired
    private RoleService service;

    @GetMapping("/roles")
    public ResponseEntity<List<Role>> findRoles(Role role)
    {
        List<Role> roleList = service.getRoles();
        if(roleList.isEmpty())
        {
            return new ResponseEntity<List<Role>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Role>>(roleList, HttpStatus.OK) ;
    }

    @GetMapping("/role/{id}")
    public ResponseEntity getRoleById(@PathVariable("id") int id)
    {
        System.out.println("Fetching Role with id " + id);

        Role role = service.getRoleById(id);
//        System.out.println(category);
        if (role==null) {
            System.out.println("Role with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>( service.getRoleById(id), HttpStatus.OK);
//        return new ResponseEntity<>(service.getCateById(id), HttpStatus.OK);
//        return repository.findById(id).toString() + id;

    }

    @PostMapping("role/create")
    public ResponseEntity  createRole(@RequestBody Role role)
    {
//        return new ResponseEntity<>(service.createCategory(category), HttpStatus.OK);
        System.out.println("Creating Role " +role.getName());

        if (service.isCategoryExist(role)) {
            System.out.println("A Role with name " + role.getName() + " already exist");
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(ucBuilder.path("/category/{id}").buildAndExpand(category.getId()).toUri());
        return new ResponseEntity<>(service.saveRole(role), HttpStatus.CREATED);
    }

    @DeleteMapping("role/delete/{id}")
    public ResponseEntity<Role> deleteRole(@PathVariable("id") int id )
    {
//        service.deleteCategory(id);
        System.out.println("Fetching & Deleting Role with id " + id);
//        System.out.println(service.getCateById(id));
        Role role = service.getRoleById(id);
        if (role==null) {
            System.out.println("Unable to delete. Role with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.deleteRole(id);
        return new ResponseEntity<Role>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("role/update/{id}")
    public ResponseEntity<Role>  updateRole(@PathVariable int id, @RequestBody Role role) {

        System.out.println("Updating Role " + id);

        Role currentRole = service.getRoleById(id);
//        System.out.println("---"+currentCategory);
        if (currentRole==null) {
            System.out.println("Role with id " + id + " not found");
            return new ResponseEntity<Role>(HttpStatus.NOT_FOUND);
        }

        currentRole.setName(role.getName());
        return new ResponseEntity<>(service.saveRole(currentRole), HttpStatus.OK);
    }
}
