package com.example.springdemo.controller;

import com.example.springdemo.bean.Modular;
import com.example.springdemo.bean.Result;
import com.example.springdemo.bean.User;
import com.example.springdemo.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(method = RequestMethod.POST)
public class ModularController {

    @Autowired
    BaseService baseService;

    @RequestMapping(value = "/getModules")
    public Object getModules(String token){

        if (token == null){
            return Result.error("未登录");
        }
        User um = new User();
        Result result = um.verification(baseService,token);
        if (result != null){
            return result;
        }

        Modular m = new Modular();
        m.setToken(token);
        m.setUserId(um.getId());
        return Result.success(baseService.getList(m));
    }
    @RequestMapping(value = "/getModuleDetails")
    public Object getModuleDetails(String token,long id){

        if (token == null){
            return Result.error("未登录");
        }
        User um = new User();
        Result result = um.verification(baseService,token);
        if (result != null){
            return result;
        }
        Modular m = new Modular();
        m.setToken(token);
        m.setUserId(um.getId());
        m.setId(id);
        return Result.success(baseService.getList(m));
    }

    @RequestMapping("/updateModules")
    public Object updateModules(String token,String modular,String name,long id){

        if (token.length() == 0){
            return Result.error("未登录");
        }

        if (name.length() == 0){
            return Result.error("没有标题");
        }
        if (modular.length() == 0){
            return Result.error("没有内容");
        }
        User um = new User();
        Result result = um.verification(baseService,token);
        if (result != null){
            return result;
        }

        Modular m = new Modular();
        m.setUserId(um.getId());
        if (id > 0){
            m.setId(id);
            m.setName(name);
            m.setModule(modular);
            if (baseService.updateBase(m) == 1){
                return Result.success("success");
            }
            return Result.error("更新数据失败");

        }
        m.setName(name);
        List list = baseService.getList(m);
        if (list.size() > 0){
            return Result.error("标题重复，请重新填写");
        }

        m.setModule(modular);
        if (baseService.insertBase(m) == 1){
            return Result.success("success");
        }
        return Result.error("更新数据失败");
    }
    @RequestMapping("/deleteModules")
    public Object deleteModules(long id,String token){

        if (token == null){
            return Result.error("未登录");
        }
        User um = new User();
        Result result = um.verification(baseService,token);
        if (result != null){
            return result;
        }

        Modular m = new Modular();
        m.setToken(token);
        m.setUserId(um.getId());
        m.setId(id);
        if (baseService.deleteBase(m) == 1){
            return Result.success("success");
        }
        return Result.success("删除数据失败");
    }

}
