package com.example.springdemo.bean;

import net.sf.json.JSONObject;

import java.util.Map;


public class Page extends Base{


    long id;
    String page;
    String name;

    public  String table(){
        return "page" + String.valueOf(getUserId());
    }
    @Override
    public String createSql(){

        String table =  table();
        return "create table if not exists " + table + " (id int auto_increment primary key , name varchar (100)" +
                ",data text)";
    }

    @Override
    public String listSql(){

        String table =  table();

        if (id > 0){

            return "select id,data,name from " + table + " where id = " + getId();
        }else if (name != null){

            return "select id,data,name from " + table + " where name = " + "'" + name + "'" ;
        }

        return "select id,data,name from " + table;
    }
    @Override
    public String insertSql(){
        String table =  table();
        String sql = "insert into " + table + " (data,name) values ('" + this.setJsonForModel() + "','" + getName() +"')";
        return sql;
    }
    @Override
    public String updateSql(){

        String table =  table();
        String sql = "update " + table + " set "
                + "data = " + "'" + this.setJsonForModel()+ "', "
                + "name = " + "'"+ getName() + "'" + " where id = " + getId() ;
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
        json.put("page",page);
        json.put("name",name);
        return json.toString();
    }
    @Override
    public Base setModelForJson(Map<String,Object> map){

        Page model = new Page();
        JSONObject json = JSONObject.fromObject(map.get("data"));
        model.page =  json.getString("page");
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

    public void setPage(String page) {
        this.page = page;
    }

    public String getPage() {
        return page;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
