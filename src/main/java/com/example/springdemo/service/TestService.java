package com.example.springdemo.service;

import com.example.springdemo.bean.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TestService {

    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Test> getList(){

        List<Test> a =  new ArrayList<>();
        String sqlTest = "select id,data from test";
        List<Map<String,Object>> list = jdbcTemplate.queryForList(sqlTest);
        for (Map<String,Object> json : list){
            Test m = Test.setModelForJson(json);
            a.add(m);
        }

        return a;
    }
    public Test geTest(long id){

        String sqlTest = "select * from test where id = " + String.valueOf(id);
        Map<String,Object> json = jdbcTemplate.queryForMap(sqlTest);
        Test m = Test.setModelForJson(json);
        return m;
    }

    public void createTable(){

        String sql = "create table if not exists test (id int auto_increment primary key,name varchar (100)" +
                ",data text)";
        jdbcTemplate.execute(sql);
    }
    public void updateTable(){

        String sql = "drop table test";
        jdbcTemplate.execute(sql);

    }
    public void insert(){
        Test m = new Test();
        m.setTitle1("setTitle1");
        m.setTitle2("setTitle2");
        m.setTitle3("setTitle3");

        String sql = "insert into test (name,data) values ('abc','" + m.setJsonForModel() +"')";
        jdbcTemplate.execute(sql);
    }

}
