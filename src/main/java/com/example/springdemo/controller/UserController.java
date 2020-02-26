package com.example.springdemo.controller;

import com.example.springdemo.bean.Result;
import com.example.springdemo.bean.User;
import com.example.springdemo.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping(method = RequestMethod.POST)
public class UserController {

    @Autowired
    BaseService baseService;

    @RequestMapping("/getUsers")
    public Object getUsers(){

        User m = new User();
        return baseService.getList(m);
    }

    @RequestMapping("/deleteUser")
    public Object deleteUser(long id){

        User m = new User();
        m.setId(id);
        return baseService.deleteBase(m);
    }

    @RequestMapping("/login")
    public Object login(String name,String password){

        if (name == null || password == null){
            return "用户名或密码为空";
        }

        User m = new User();
        String input = name + password;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(input.getBytes());
            byte[] byteArray = md5.digest();

            BigInteger bigInt = new BigInteger(1, byteArray);
            // 参数16表示16进制
            String result = bigInt.toString(16);
            // 不足32位高位补零
            while(result.length() < 32) {
                result = "0" + result;
            }
            m.setToken(result);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        if (baseService.getList(m).size() > 0){

            return Result.success(m.getToken());
        }
        return Result.error("登录失败");

    }
    @RequestMapping("/custom/register")
    public Object register(String name,String password){

        if (name == null || password == null){
            return "用户名或密码为空";
        }

        User m = new User();
        m.setName(name);
        m.setPassword(password);

        if (baseService.getList(m).size() > 0){
            return "用户名存在，请重新填写";
        }

        String input = name + password;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(input.getBytes());
            byte[] byteArray = md5.digest();

            BigInteger bigInt = new BigInteger(1, byteArray);
            // 参数16表示16进制
            String result = bigInt.toString(16);
            // 不足32位高位补零
            while(result.length() < 32) {
                result = "0" + result;
            }
            m.setToken(result);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        if (baseService.insertBase(m) == 1){

            return "注册成功";
        }
        return "注册失败";
    }

}
