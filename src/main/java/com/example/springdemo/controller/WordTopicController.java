package com.example.springdemo.controller;

import com.example.springdemo.bean.Result;
import com.example.springdemo.bean.WordTopic;
import com.example.springdemo.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(method = RequestMethod.POST)
public class WordTopicController {

    @Autowired
    BaseService baseService;

    @RequestMapping(value = "/getWordTopic")
    public Object getWordTopic(long wordId,String style){


        WordTopic m = new WordTopic();
        m.setStyle(style);
        m.setWordId(wordId);

        return Result.success(baseService.getList(m));
    }

    @RequestMapping("/updateWordTopic")
    public Object updateWordTopic(String style,long id,long wordId,String topic,String answers,String translate,String options1,String options2,String options3,String options4){


        WordTopic m = new WordTopic();
        m.setWordId(wordId);
        m.setId(id);
        m.setStyle(style);
        m.setTopic(topic);
        m.setAnswers(answers);
        m.setTranslate(translate);

        m.setOptions1(options1);
        m.setOptions2(options2);
        m.setOptions3(options3);
        m.setOptions4(options4);


        if (id > 0){
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
    @RequestMapping("/deleteWordTopic")
    public Object deleteWordTopic(long wordId,long id,String style){

        WordTopic m = new WordTopic();
        m.setStyle(style);
        m.setWordId(wordId);
        m.setId(id);
        if (baseService.deleteBase(m) == 1){
            return Result.success("success");
        }
        return Result.success("删除数据失败");

    }

}
