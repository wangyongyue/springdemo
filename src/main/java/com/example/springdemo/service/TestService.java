package com.example.springdemo.service;

import com.example.springdemo.bean.Base;
import com.example.springdemo.bean.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TestService {

    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Base> getList(Base base){

        List<Base> a =  new ArrayList<>();
        List<Map<String,Object>> list = jdbcTemplate.queryForList(base.listSql());
        for (Map<String,Object> json : list){
            Base m = base.setModelForJson(json);
            a.add(m);
        }

        return a;
    }
    public int insertBase(Base base){

        return jdbcTemplate.update(base.insertSql());

    }
    public void updateTable(){

        String sql = "drop table test";
        jdbcTemplate.execute(sql);

    }

    public void createTable(){

        String sql = "create table if not exists test (id int auto_increment primary key,name varchar (100)" +
                ",data text)";
        jdbcTemplate.execute(sql);
    }


}
