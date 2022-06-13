package com.example.demo.service;

import com.example.demo.entity.Role;
import com.example.demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository repository;

    public List<Role> getRoles()
    {
        return  repository.findAll();
    }

    public Optional<Role> getRoleById(int id )
    {
        return  repository.findById(id);
    }

    public Role saveRole(Role role)
    {
        return repository.save(role);
    }

    public void deteleRole(int id)
    {
         repository.deleteById(id);
    }

    public Role updateRole(Role role , int id)
    {
        repository.findById(id);
        role.setName(role.getName());
         return repository.save(role);
    }
}
