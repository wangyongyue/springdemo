package com.example.springdemo;

import com.example.springdemo.bean.Result;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(method = RequestMethod.POST)
public class NewController {

    @Autowired
    NewService newService;


    public New getonfigureObject(String table){

        New m = new New();
        try {
            Class className = Class.forName("com.example.springdemo.warehouse." + table);
            m = (New)className.newInstance();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return m;
    }

    @RequestMapping(value = "/getNew")
    public Object getNew(String params,String table){

        JSONObject obj = JSONObject.fromObject(params);
        New m = getonfigureObject(table);
        m.setParams(obj);
        return Result.success(newService.getList(m));
    }

    @RequestMapping("/updateNew")
    public Object updateNew(String params,String table){

        JSONObject obj = JSONObject.fromObject(params);
        New m = getonfigureObject(table);
        m.setParams(obj);
        if ((long)obj.get("id") > 0){

            if (newService.updateBase(m) == 1){
                return Result.success("success");
            }
            return Result.error("更新数据失败");
        }

        if (newService.insertBase(m) == 1){
            return Result.success("success");
        }
        return Result.error("更新数据失败");

    }

    @RequestMapping("/deleteNew")
    public Object deleteNew(String params,String table){

        JSONObject obj = JSONObject.fromObject(params);
        New m = getonfigureObject(table);
        m.setParams(obj);
        if (newService.deleteBase(m) == 1){
            return Result.success("success");
        }
        return Result.success("删除数据失败");
    }

}
