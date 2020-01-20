package com.example.springdemo.service;

import com.example.springdemo.bean.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BaseService {

    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Base> getList(Base base){

        this.beforeSql(base);


        List<Base> a =  new ArrayList<>();
        List<Map<String,Object>> list = jdbcTemplate.queryForList(base.listSql());
        for (Map<String,Object> json : list){
            Base m = base.setModelForJson(json);
            a.add(m);
        }

        return a;
    }
    public int insertBase(Base base){

        this.beforeSql(base);

        return jdbcTemplate.update(base.insertSql());

    }
    public int deleteBase(Base base){

        this.beforeSql(base);
        return jdbcTemplate.update(base.deleteSql());

    }

    public int updateBase(Base base){
        this.beforeSql(base);

        return jdbcTemplate.update(base.updateSql());

    }

    private int beforeSql(Base base){

        return jdbcTemplate.update(base.createSql());

    }



}
