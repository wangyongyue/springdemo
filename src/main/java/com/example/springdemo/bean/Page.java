package com.example.springdemo.bean;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

public class Page extends Base{


    long id;
    String name;

    String title1;
    String title2;
    String title3;

    @Override
    public String createSql(){

        return "create table if not exists page (id int auto_increment primary key,name varchar (100)" +
                ",data text)";
    }

    @Override
    public String listSql(){

        return "select id,data from page";
    }
    @Override
    public String insertSql(){

        String sql = "insert into page (data) values ('" + this.setJsonForModel() +"')";
        return sql;
    }
    @Override
    public String updateSql(){

        return "";
    }
    @Override
    public String deleteSql(){

        return "delete from page where id = " + String.valueOf(this.id);
    }
    @Override
    public String setJsonForModel(){

        JSONObject json = new JSONObject();
        json.put("title1",title1);
        json.put("title2",title2);
        json.put("title3",title3);

        return json.toString();
    }
    @Override
    public Base setModelForJson(Map<String,Object> map){

        Page model = new Page();
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

    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    public void setTitle2(String title2) {
        this.title2 = title2;
    }

    public void setTitle3(String title3) {
        this.title3 = title3;
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
}
