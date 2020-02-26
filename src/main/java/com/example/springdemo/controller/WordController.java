package com.example.springdemo.controller;

import com.example.springdemo.bean.Result;
import com.example.springdemo.bean.Word;
import com.example.springdemo.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(method = RequestMethod.POST)
public class WordController {

    @Autowired
    BaseService baseService;

    @RequestMapping(value = "/getWord")
    public Object getWord(String style){

        Word m = new Word();
        m.setStyle(style);
        return Result.success(baseService.getList(m));
    }

    @RequestMapping("/updateWord")
    public Object updateWord(String name,long id,String style){

        Word m = new Word();
        m.setStyle(style);
        m.setName(name);
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
    @RequestMapping("/deleteWord")
    public Object deleteWord(long id,String style){

        Word m = new Word();
        m.setStyle(style);
         m.setId(id);
        if (baseService.deleteBase(m) == 1){
            return Result.success("success");
        }
        return Result.success("删除数据失败");
    }

}
