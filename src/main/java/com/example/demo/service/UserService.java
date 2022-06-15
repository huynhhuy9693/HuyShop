package com.example.demo.service;

import com.example.demo.entity.UserTb;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<UserTb> getUsers()
    {
        return repository.findAll();

    }


    public UserTb getUserById(@PathVariable("id") long id)
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


    public UserTb saveUser(@RequestBody UserTb user)
    {

        return repository.save(user) ;

    }

    public void deleteUser(@PathVariable("id") Long id )
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
    public boolean isUserExist(UserTb user) {
        return findByName(user.getName())!=null;
    }

}
