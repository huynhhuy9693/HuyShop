package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.entity.UserTb;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;
import com.example.demo.dto.UserTbDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class UserController {

    @Autowired
    private UserService service;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private RoleService roleService;



    @GetMapping("/users")
    public String findUsers(Model model)
    {
//        List<UserTb> userTbList = service.getUsers();
//        if(userTbList.isEmpty())
//        {
//            return new ResponseEntity<List<UserTb>>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<List<UserTb>>(userTbList, HttpStatus.OK) ;
        model.addAttribute("users", service.getUsers());
        return "/admin/user_list";

    }
    @GetMapping("/create_user")
    public String showAddUser(Model model)
    {
        UserTb user= new UserTb();
        model.addAttribute("user", user);
        model.addAttribute("roles", roleService.getRoles());
        return "admin/create_user";
    }

    @GetMapping("/user/{id}")
    public ResponseEntity findUserById(@PathVariable("id") long id)
    {
        System.out.println("Fetching User with id " + id);

        UserTb users = service.getUserById(id);

        if (users==null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>( service.getUserById(id), HttpStatus.OK);


    }

    @PostMapping("user/create")
    public String  createUser(@ModelAttribute("user") UserTb userTb )
    {

        System.out.println("Creating User " +userTb.getName());

//        if (service.isUserExist(userTbDTO)) {
//            System.out.println("A User with name " + userTbDTO.getName() + " already exist");
//            return new ResponseEntity<>(HttpStatus.CONFLICT);
//        }
//
//        UserTb userTbRequest = modelMapper.map(userTbDTO, UserTb.class);
//        UserTb userTb = service.saveUser(userTbRequest);
//        // convert entity to DTO
//        UserTbDTO userTbResponse = modelMapper.map(userTb, UserTbDTO.class);
//         return new ResponseEntity<UserTbDTO>(userTbResponse, HttpStatus.CREATED);
        service.saveUser(userTb);
        return "redirect:/admin/users";

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

    @GetMapping("user/details/{id}")
    public String detailProduct(@PathVariable Long id, Model model)
    {
        System.out.println("user id " + id);
        model.addAttribute("user",service.getUserById(id));
        model.addAttribute("roles",roleService.getRoles());
        return "admin/update_user.html";
    }
    @PostMapping("user/update/{id}")
    public String  updateUser(@RequestParam long id, @ModelAttribute("user") UserTb userTb) {

        System.out.println("Updating User " + id);

//            userTb = service.getUserById(id);
//        System.out.println("---"+currentCategory);
//        if (currentUser==null) {
//            System.out.println("User with id " + id + " not found");
//            return new ResponseEntity<UserTbDTO>(HttpStatus.NOT_FOUND);
//        }
//
//        currentUser.setName(userTbDTO.getName());
//        currentUser.setDob(userTbDTO.getDob());
//        currentUser.setAddress(userTbDTO.getAddress());
//        currentUser.setPhone(userTbDTO.getPhone());
//        currentUser.setEmail(userTbDTO.getEmail());
//        currentUser.setRoleId(roleService.getRoleById(userTbDTO.getRoleDTO().getId()));
//        currentUser.setUserName(userTbDTO.getUserName());
//        currentUser.setPassWord(userTbDTO.getPassWord());
//
//        UserTb userTbRequest = modelMapper.map(userTbDTO, UserTb.class);
//        UserTb userTb = service.saveUser(userTbRequest);
//        // convert entity to DTO
//        UserTbDTO userTbResponse = modelMapper.map(userTb, UserTbDTO.class);
//        return new ResponseEntity<UserTbDTO>(userTbResponse, HttpStatus.OK);
            service.saveUser(userTb);
            return "redirect:/admin/users";

    }


}
