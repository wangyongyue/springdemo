package com.example.springdemo.bean;

import java.util.Map;

public class Base {

    String token;
    long userId;

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
}
