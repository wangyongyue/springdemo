package com.example.springdemo.bean;

import net.sf.json.JSONObject;

import java.util.Map;

public class Test {
    long id;
    String name;

    String title1;
    String title2;
    String title3;


    public String setJsonForModel(){

        JSONObject json = new JSONObject();
        json.put("title1",title1);
        json.put("title2",title2);
        json.put("title3",title3);

        return json.toString();
    }

    public static Test setModelForJson(Map<String,Object> map){

        Test model = new Test();
        JSONObject json = JSONObject.fromObject(map.get("data"));
        model.title1 =  json.getString("title1");
        model.title2 =  json.getString("title2");
        model.title3 =  json.getString("title3");
        if (json.has("name")){
            model.name =  json.getString("name");
        }
        model.id = Long.valueOf(String.valueOf(map.get("id")));

        return model;
    }

    public String getTitle1() {
        return title1;
    }

    public String getTitle2() {
        return title2;
    }

    public String getTitle3() {
        return title3;
    }

    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    public void setTitle2(String title2) {
        this.title2 = title2;
    }

    public void setTitle3(String title3) {
        this.title3 = title3;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
