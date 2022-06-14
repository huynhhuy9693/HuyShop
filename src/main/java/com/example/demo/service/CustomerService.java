package com.example.demo.service;


import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public List<Customer> getCustomers()
    {
        return repository.findAll();
    }

    public Optional<Customer> getCustomerById(long id)
    {
        return repository.findById(id);
    }

    public Customer saveCustomer(Customer customer)
    {
        return repository.save(customer);
    }

    public void deleteCustomer(long id)
    {
         repository.deleteById(id);
    }

    public Customer editCustomer(Customer customer, long id)
    {
        repository.findById(id);
        customer.setName(customer.getName());
        customer.setDob(customer.getDob());
        customer.setPhone(customer.getPhone());
        customer.setEmail(customer.getEmail());
        customer.setAddress(customer.getAddress());
        return repository.save(customer);
    }
}
