package com.meetup.adminservice.controller;

import com.meetup.adminservice.entity.Admin;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/admin")
@RestController
public class AdminController {

    @GetMapping
    @Cacheable()
    public String createAdmin(){
        return "admin called from staff";

    }


}

