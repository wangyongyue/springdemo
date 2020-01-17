package com.example.springdemo.service;

import com.example.springdemo.bean.Page;
import com.example.springdemo.bean.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageService {

    @Autowired
    JdbcTemplate jdbcTemplate;
    public Page getPage(int id){

        String sqlTest = "select  * from Page where id = " + String.valueOf(id);
        RowMapper<Page> rm = new BeanPropertyRowMapper<>(Page.class);
        List<Page> list = jdbcTemplate.query(sqlTest,rm);
        return list.get(0);

    }
    public void createTable(){

        String sql = "create table if not exists page (id int auto_increment primary key,name varchar (100)" +
                ",data text)";
        jdbcTemplate.execute(sql);

    }
    public void updateTable(){

        String sql = "drop table page";
        jdbcTemplate.execute(sql);

    }
    public void insert(){

        String sql = "insert into page (name,data) values ('abc','我的天啊')";
        jdbcTemplate.execute(sql);
    }

}
