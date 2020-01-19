package com.example.springdemo.controller;

import com.example.springdemo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModularController {

    @Autowired
    TestService testService;

    @RequestMapping("/getModlar")
    public Object hello(){

        return "/getPage";
    }


}
