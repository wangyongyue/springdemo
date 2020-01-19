package com.example.springdemo.controller;

import com.example.springdemo.bean.Test;
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

        Test test = new Test();

        return testService.getList(test);
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

        Test m = new Test();
        m.setTitle1("setTitle1");
        m.setTitle2("setTitle2");
        m.setTitle3("setTitle3");

        return testService.insertBase(m);
    }

}
