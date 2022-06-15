//package com.example.demo.controller;
//
//import com.example.demo.entity.Customer;
//import com.example.demo.service.CustomerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RequestMapping
//public class CustomerController {
//
//    @Autowired
//    private CustomerService service;
//
//    @GetMapping("/customers")
//    public ResponseEntity getCustomers()
//    {
//        return  new ResponseEntity<>(service.getCustomers(), HttpStatus.OK);
//    }
//
//    @GetMapping("/customer/{id}")
//    public ResponseEntity getCustomerById(@PathVariable long id)
//    {
//        return new ResponseEntity<>( service.getCustomerById(id),HttpStatus.OK);
//    }
//
//    @PostMapping("/customer/create")
//    public ResponseEntity saveCustomer(@RequestBody Customer customer)
//    {
//        return new ResponseEntity<>(service.saveCustomer(customer),HttpStatus.OK);
//    }
//
//    @DeleteMapping("/customer/delete/{id}")
//    public void deleteCustomer(@PathVariable long id)
//    {
//        service.deleteCustomer(id);
//    }
//
//    @PutMapping("/customer/update/{id}")
//    public ResponseEntity updateCustomer(@RequestBody Customer customer, @PathVariable long id)
//    {
//        return new ResponseEntity<>(service.editCustomer(customer, id),HttpStatus.OK);
//    }
//}
