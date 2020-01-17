package com.example.springdemo.controller;

import com.example.springdemo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PageController {

    @Autowired
    TestService testService;

    @RequestMapping("/getPage")
    public Object hello(){

        return testService.getList();
    }


}
