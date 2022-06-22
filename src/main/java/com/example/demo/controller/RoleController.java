package com.example.demo.controller;

import com.example.demo.entity.Category;
import com.example.demo.entity.Role;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class RoleController {

    @Autowired
    private RoleService service;

    @GetMapping("/roles")
    public String findRoles(Model model)
    {
        model.addAttribute("roles", service.getRoles());
//        if(roleList.isEmpty())
//        {
//            return new ResponseEntity<List<Role>>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<List<Role>>(roleList, HttpStatus.OK) ;
        return "/admin/role_list";
    }

    @GetMapping("/create_role")
    public String showAddRole(Model model)
    {

        Role role = new Role();
        model.addAttribute("role", role);
        return "admin/create_role";
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
    public String  createRole(@ModelAttribute("role") Role role)
    {
//        return new ResponseEntity<>(service.createCategory(category), HttpStatus.OK);
        System.out.println("Creating Role " +role.getName());
//        if (service.isCategoryExist(role)) {
//            System.out.println("A Role with name " + role.getName() + " already exist");
//            return new ResponseEntity<>(HttpStatus.CONFLICT);
//        }
        service.saveRole(role);
        return "redirect:/admin/roles";
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
    @GetMapping("role/details/{id}")
    public String detailCategory(@PathVariable int id, Model model)
    {
        System.out.println("role_update " + id);
        model.addAttribute("role",service.getRoleById(id));
        return "admin/update_role";
    }

    @PostMapping("role/update/{id}")
    public String  updateRole(@RequestParam("id") int id, @ModelAttribute("role") Role role) {

        System.out.println("Updating Role " + id);

//        Role currentRole = service.getRoleById(id);
//        if (currentRole==null) {
//            System.out.println("Role with id " + id + " not found");
//            return new ResponseEntity<Role>(HttpStatus.NOT_FOUND);
//        }

        service.saveRole(role);
//        return new ResponseEntity<>(service.saveRole(currentRole), HttpStatus.OK);
        return "redirect:/admin/roles"; 

    }
}
