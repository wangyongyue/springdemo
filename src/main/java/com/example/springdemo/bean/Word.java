package com.example.springdemo.bean;

import net.sf.json.JSONObject;

import java.util.Map;

public class Word extends Base{


    long id;
    String name;

    String style;

    public  String table(){
        return "word" + getStyle();
    }
    @Override
    public String createSql(){

        String table =  table();
        return "create table if not exists " + table + " (id int auto_increment primary key " +
                ",data text)";
    }

    @Override
    public String listSql(){

        String table =  table();

        if (id > 0){

            return "select id,data from " + table + " where id = " + getId();
        }
        return "select id,data from " + table;
    }
    @Override
    public String insertSql(){
        String table =  table();
        String sql = "insert into " + table + " (data) values ('" + this.setJsonForModel() + "')";
        return sql;
    }
    @Override
    public String updateSql(){

        String table =  table();
        String sql = "update " + table + " set "
                + "data = " + "'" + this.setJsonForModel()+ "' "
                + " where id = " + getId() ;
        return sql;
    }
    @Override
    public String deleteSql(){

        String table =  table();
        return "delete from " + table + " where id = " + String.valueOf(this.id);
    }
    @Override
    public String setJsonForModel(){

        JSONObject json = new JSONObject();
        json.put("name",name);
        return json.toString();
    }
    @Override
    public Base setModelForJson(Map<String,Object> map){

        Word model = new Word();
        JSONObject json = JSONObject.fromObject(map.get("data"));
        model.name =  json.getString("name");
        model.id = Long.valueOf(String.valueOf(map.get("id")));
        return model;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getStyle() {
        return style;
    }
}