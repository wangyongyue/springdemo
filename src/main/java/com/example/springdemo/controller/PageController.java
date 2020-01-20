package com.example.springdemo.controller;

import com.example.springdemo.bean.Page;
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

        Page m = new Page();
        return baseService.getList(m);
    }

    @RequestMapping("/updatePage")
    public Object updatePage(){

        Page m = new Page();
        m.setTitle1("ljsdlf");
        m.setTitle2("ljsdlf");
        m.setTitle3("ljsdlf");

        return baseService.insertBase(m);
    }
    @RequestMapping("/deletePage")
    public Object deletePage(long id){

        Page m = new Page();
        m.setId(id);
        return baseService.deleteBase(m);
    }

}
