package com.pixelweb.service;

import com.pixelweb.model.Admin;
import com.pixelweb.repository.second.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminService {

    @Autowired
    private AdminRepo adminRepo;

    @Transactional("secondTranssationManager")
    public Admin saveAdmin(String name, String pass){
        Admin user = new Admin();
        user.setName(name);
        user.setPass(pass);
        user.setState("NEW");
        adminRepo.save(user);
        return user;
    }
    public Admin getAdmin(String name, String pass){
        return adminRepo.findByNameAndPass(name, pass);
    }
}
