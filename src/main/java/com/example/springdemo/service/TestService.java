package com.example.springdemo.service;

import com.example.springdemo.bean.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestService {

    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Test> getList(){



        String sql = "CREATE TABLE test (user_id integer, name varchar(100)))";

        RowMapper<Test> rm = new BeanPropertyRowMapper<>(Test.class);
        jdbcTemplate.execute(sql);

        Test a = new Test();
        a.setName(String.valueOf(123));
        Test b = new Test();
        b.setName("bbbb");

        ArrayList l = new ArrayList();
        l.add(a);
        l.add(b);
        return l;

    }
}
