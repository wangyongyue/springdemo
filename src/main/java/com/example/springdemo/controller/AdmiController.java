package com.example.springdemo.controller;

import com.example.springdemo.bean.Admi;
import com.example.springdemo.bean.Base;
import com.example.springdemo.bean.Result;
import com.example.springdemo.service.BaseService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(method = RequestMethod.POST)
public class AdmiController {

    @Autowired
    BaseService baseService;
    @RequestMapping(value = "/getData")
    public Object getData(String style){

        Admi m = new Admi();
        m.setStyle(style);

        List<JSONObject> list =  new ArrayList<>();
        for (Base obj : baseService.getList(m)){
            list.add(obj.getJson());
        }
        return Result.success(list);
    }
    @RequestMapping(value = "/getDataDetails")
    public Object getDataDetails(String style,long id){

        Admi m = new Admi();
        m.setStyle(style);
        m.setId(id);

        List<JSONObject> list =  new ArrayList<>();
        for (Base obj : baseService.getList(m)){
            list.add(obj.getJson());
        }
        return Result.success(list.get(0));
    }
    @RequestMapping("/updateData")
    public Object updateData(long id,String style,String data){

        Admi m = new Admi();
        m.setStyle(style);
        m.setData(data);
        if (id > 0){
            m.setId(id);
            if (baseService.updateBase(m) == 1){
                return Result.success("success");
            }
            return Result.error("更新数据失败");
        }

        if (baseService.insertBase(m) == 1){
            return Result.success("success");
        }
        return Result.error("更新数据失败");

    }
    @RequestMapping("/deleteData")
    public Object deleteData(long id,String style){

        Admi m=new Admi();
        m.setStyle(style);
        m.setId(id);
        if (baseService.deleteBase(m) == 1){
            return Result.success("success");
        }
        return Result.success("删除数据失败");

    }

}
