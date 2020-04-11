package com.example.springdemo;

import com.example.springdemo.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class NewService {

    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Map<String,Object>> getList(New base){


        List<Map<String,Object>> jsons =  new ArrayList<>();
        List<Map<String,Object>> list = jdbcTemplate.queryForList(base.listSql());
        for (Map<String,Object> json : list){
            jsons.add(base.setModelForJson(json));
        }

        return jsons;
    }
    public int insertBase(New base){


        return jdbcTemplate.update(base.insertSql());

    }
    public int deleteBase(New base){

        return jdbcTemplate.update(base.deleteSql());

    }

    public int updateBase(New base){

        return jdbcTemplate.update(base.updateSql());

    }

    private int beforeSql(New base){

        if (!base.getClass().isAssignableFrom(User.class))
        {


        }

        return jdbcTemplate.update(base.createSql());

    }



}
