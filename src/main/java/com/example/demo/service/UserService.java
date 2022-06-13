package com.example.demo.service;

import com.example.demo.entity.UserTb;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<UserTb> getUsers()
    {
        return repository.findAll();
    }

    public Optional<UserTb> getUserById(int id)
    {
        return repository.findById(id);
    }

    public UserTb saveUser(UserTb user)
    {
        return repository.save(user);
    }

    public void deleteUser(int id)
    {
        repository.deleteById(id);
    }

    public UserTb updateUser(UserTb user , int id)
    {
        repository.findById(id);
        user.setName(user.getName());
        user.setDob(user.getDob());
        user.setAddress(user.getAddress());
        user.setEmail(user.getEmail());
        user.setPhone(user.getPhone());
//        user.setRole(user.getRole());
        user.setStatus(user.isStatus());
        return repository.save(user);

    }

}
