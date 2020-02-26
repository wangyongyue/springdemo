package com.example.springdemo.bean;

public class Result {

    int code;
    String message;
    Object data;

    public Result( int acode,String msg,Object adata){

        code = acode;
        message = msg;
        data = adata;

    }
    public static Result error(String msg){

        return new Result(1001,msg,null);
    }
    public static Result success(Object data){

        return new Result(1000,null,data);
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public Object getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }
}
