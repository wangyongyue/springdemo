package com.example.springdemo.service;

import com.example.springdemo.bean.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModularService {

    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Test> getList(){


        String sqlTest = "select  * from test";
        RowMapper<Test> rm = new BeanPropertyRowMapper<>(Test.class);
        return jdbcTemplate.query(sqlTest,rm);

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

        String sql = "insert into test (name,data) values ('abc','我的天啊')";
        jdbcTemplate.execute(sql);
    }

}
