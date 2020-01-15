package com.example.springdemo.service;

import com.example.springdemo.bean.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestService {

    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Test> getList(){

//        String sql = "select * from position";
//        RowMapper<Test> rm = new BeanPropertyRowMapper<>(Test.class);
//        return jdbcTemplate.query(sql,rm);
//
        Test a = new Test();
        a.setName("adfb");
        Test b = new Test();
        b.setName("bbbb");

        ArrayList l = new ArrayList();
        l.add(a);
        l.add(b);
        return l;

    }
}
