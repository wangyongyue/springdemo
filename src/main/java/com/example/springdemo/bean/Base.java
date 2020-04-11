package com.example.springdemo.bean;

import net.sf.json.JSONObject;

import java.util.Map;

public class Base {

    String token;
    long userId;
    JSONObject json;


    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getUserId() {
        return userId;
    }

    public String createSql(){

        return "";
    }
    public String listSql(){

        return "";
    }
    public String insertSql(){

        return "";
    }
    public String updateSql(){

        return "";
    }
    public String deleteSql(){

        return "";
    }

    public String setJsonForModel(){

        return "";
    }

    public Base setModelForJson(Map<String,Object> map){

       Base model = new Base();

        return model;
    }

    public void setJson(JSONObject json) {
        this.json = json;
    }

    public JSONObject getJson() {
        return json;
    }
}
