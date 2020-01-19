package com.example.springdemo.controller;

import com.example.springdemo.bean.Test;
import com.example.springdemo.service.BaseService;
import com.example.springdemo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PageController {

    @Autowired
    BaseService baseService;

    @RequestMapping("/getPages")
    public Object getPages(){

        Test m = new Test();
        return baseService.getList(m);
    }

    @RequestMapping("/updatePage")
    public Object updatePage(){

        Test m = new Test();
        m.setTitle1("ljsdlf");
        m.setTitle2("ljsdlf");
        m.setTitle3("ljsdlf");

        return baseService.insertBase(m);
    }
    @RequestMapping("/deletePage")
    public Object deletePage(long id){

        Test m = new Test();
        m.setId(id);
        return baseService.deleteBase(m);
    }

}
