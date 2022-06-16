package com.example.demo.service;

import com.example.demo.entity.UserTb;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.dto.UserTbDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    @Autowired
    RoleRepository roleRepository;

    public List<UserTb> getUsers()
    {
        roleRepository.findAll();
        return repository.findAll();

    }


    public UserTb getUserById(long id)
    {

        for(UserTb user : repository.findAll())
        {
            if(user.getId()==id)
            {
//                System.out.println("=="+category);
                return user;

            }
        }
        return null;
    }
    public boolean isIdExits(UserTb user)
    {
        return getUserById(user.getId())==null;
    }


    public UserTb saveUser(UserTb user)
    {

        System.out.println("----");
        return repository.save(user) ;

    }

    public void deleteUser(Long id)
    {
        repository.deleteById(id);
    }




    public UserTb findByName(String name) {
        for(UserTb user : repository.findAll()){
            if(user.getName().equalsIgnoreCase(name)){
                return user;
            }
        }
        return null;
    }
    public boolean isUserExist(UserTbDTO user) {
        return findByName(user.getName())!=null;
    }

}
