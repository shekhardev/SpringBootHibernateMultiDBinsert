package com.pixelweb.controller;

import com.pixelweb.model.Admin;
import com.pixelweb.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminService adminService;


    @RequestMapping(method = RequestMethod.GET)
    public Admin getAdmin(String name, String pass){
        return  adminService.getAdmin(name,pass);
    }
    @RequestMapping(method = RequestMethod.PUT)
    public Admin saveAdmin(String name,String pass){
        return adminService.saveAdmin(name,pass);
    }
}
