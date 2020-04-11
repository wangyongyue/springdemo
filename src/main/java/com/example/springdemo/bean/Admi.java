package com.example.springdemo.bean;

import net.sf.json.JSONObject;

import java.util.Map;

public class Admi extends Base{


    long id;
    String data;
    String style;

    public  String table(){
        return "Admi" + getStyle();
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

        return  getData();
    }
    @Override
    public Base setModelForJson(Map<String,Object> map){

        Admi model = new Admi();
        JSONObject json = JSONObject.fromObject(map.get("data"));
        json.put("id",Long.valueOf(String.valueOf(map.get("id"))));
        model.json = json;
        return model;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setData(String name) {
        this.data = name;
    }
    public String getData() {
        return data;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getStyle() {
        return style;
    }
}