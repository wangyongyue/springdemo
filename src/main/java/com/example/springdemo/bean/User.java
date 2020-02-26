package com.example.springdemo.bean;

import com.example.springdemo.service.BaseService;
import net.sf.json.JSONObject;

import java.util.List;
import java.util.Map;

public class User extends Base{


    long id;
    String name;
    String token;
    String password;


    public  String table(){
        return "user";
    }
    public Result verification(BaseService service,String token){

        this.setToken(token);
        List<Base> list = service.getList(this);
        if (list.size() != 1){
            return Result.error("用户不存在，请重新登录");
        }else{
            User user= (User) list.get(0);
            this.setId(user.getId());
            return null;
        }

    }
    @Override
    public String createSql(){

        String table = table();
        String createTable = "create table if not exists " + table;
        String keys = " (id int auto_increment primary key,name varchar (100),password varchar (100),token varchar (100)" +
                ",data text)";
        return createTable + keys;
    }

    @Override
    public String listSql(){

        String table = table();

        if (name != null){
            return "select id,data from " + table + " where name = " + "'" + this.name + "'";
        }else if (token != null){
            return "select id,data from " + table + " where token = " + "'" + this.token + "'";
        }

        return "select id,data from " + table;
    }
    @Override
    public String insertSql(){

        String table = table();
        String sql = "insert into " + table + " (data,name,password,token) values ('" + this.setJsonForModel() + "','" + this.name + "','" + this.password+ "','" + this.token + "'"+ ")";
        return sql;
    }
    @Override
    public String updateSql(){

//        return "update user set name = 'sdf' where id = 1";
        return "";
    }
    @Override
    public String deleteSql(){

        String table = table();

        return "delete from " + table + " where id = " + String.valueOf(this.id);
    }
    @Override
    public String setJsonForModel(){

        JSONObject json = new JSONObject();
        json.put("name",name);
        json.put("password",password);
        json.put("token",token);

        return json.toString();
    }
    @Override
    public Base setModelForJson(Map<String,Object> map){

        User model = new User();
        JSONObject json = JSONObject.fromObject(map.get("data"));
        model.name =  json.getString("name");
        model.password =  json.getString("password");
        model.token =  json.getString("token");
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

    public void setPassword(String password) {
        this.password = password;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPassword() {
        return password;
    }

    public String getToken() {
        return token;
    }
}
