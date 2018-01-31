package com.pixelweb.service;

import com.pixelweb.model.User;
import com.pixelweb.repository.first.FirstRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private FirstRepo firstRepo;


    @Transactional("firstTranssationManager")
    public User saveUser(String name, String pass){
        User user = new User();
        user.setName(name);
        user.setPass(pass);
        user.setState("NEW");
        firstRepo.save(user);
        return user;
    }
    public User getUser(String name, String pass){
        return firstRepo.findByNameAndPass(name, pass);
    }
}
