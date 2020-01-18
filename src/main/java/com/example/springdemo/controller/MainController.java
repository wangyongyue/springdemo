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
    @RequestMapping("/d")
    public Object getTest(long id){

        System.out.println(id);
        return testService.geTest(id);
    }
    @RequestMapping("/c")
    public Object createTable(){

        testService.createTable();
        return true;
    }
    @RequestMapping("/u")
    public Object updateTable(){

        testService.updateTable();
        return true;
    }
    @RequestMapping("/i")
    public Object insert(){

        testService.insert();
        return true;
    }

}
