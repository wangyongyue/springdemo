package com.example.springdemo;

import net.sf.json.JSONObject;

import java.util.Map;

public class New {


    long id;
    JSONObject params;

    public String getTable() {
        return "word_w";
    }
    public String createSql(){

        return "create table if not exists " + getTable() + " (id int auto_increment primary key " +
                ",data text)";
    }

    public String checkParams(String params) {


        return null;
    }

    public String listSql(){

        if (id > 0){

            return "select id,data from " + getTable() + " where id = " + getId();
        }
        return "select id,data from " + getTable();
    }

    public String insertSql(){

        String sql = "insert into " + getTable() + " (data) values ('" + this.setJsonForModel() + "')";
        return sql;
    }

    public String updateSql(){

        String sql = "update " + getTable() + " set "
                + "data = " + "'" + this.setJsonForModel()+ "' "
                + " where id = " + getId() ;
        return sql;
    }

    public String deleteSql(){

        return "delete from " + getTable() + " where id = " + String.valueOf(this.id);
    }

    public String setJsonForModel(){

        JSONObject json = getParams();
        json.remove("id");
        return json.toString();
    }

    public JSONObject setModelForJson(Map<String,Object> map){

        JSONObject json = JSONObject.fromObject(map.get("data"));
        json.put("id",map.get("id"));
        return json;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public void setParams(JSONObject params) {
        this.params = params;
        if (params.get("id") != null){
            this.setId((long)params.get("id"));
        }
    }

    public JSONObject getParams() {
        return params;
    }
}