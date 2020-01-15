package com.example.springdemo.controller;

import com.example.springdemo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    TestService testService;

    @RequestMapping("/hello")
    public Object hello(){

        return testService.getList();
    }

}
