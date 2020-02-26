package com.example.springdemo.bean;

import net.sf.json.JSONObject;

import java.util.Map;

public class WordTopic extends Base{


    long id;
    String topic;
    String answers;
    String translate;
    String options1;
    String options2;
    String options3;
    String options4;


    long wordId;
    String style;

    public  String table(){
        return "wordTopic" + getStyle() + String.valueOf(getWordId());
    }
    @Override
    public String createSql(){

        String table =  table();
        return "create table if not exists " + table + " (id int auto_increment primary key " +
                ",data text)";
    }

    @Override
    public String listSql(){

        String table =  table();

        if (id > 0){

            return "select id,data from " + table + " where id = " + getId();
        }
        return "select id,data from " + table;
    }
    @Override
    public String insertSql(){
        String table =  table();
        String sql = "insert into " + table + " (data) values ('" + this.setJsonForModel() + "')";
        return sql;
    }
    @Override
    public String updateSql(){

        String table =  table();
        String sql = "update " + table + " set "
                + "data = " + "'" + this.setJsonForModel()+ "' "
                + " where id = " + getId() ;
        return sql;
    }
    @Override
    public String deleteSql(){

        String table =  table();
        return "delete from " + table + " where id = " + String.valueOf(this.id);
    }
    @Override
    public String setJsonForModel(){

        JSONObject json = new JSONObject();
        json.put("topic",topic);
        json.put("answers",answers);
        json.put("translate",translate);
        json.put("options1",options1);
        json.put("options2",options2);
        json.put("options3",options3);
        json.put("options4",options4);

        return json.toString();
    }
    @Override
    public Base setModelForJson(Map<String,Object> map){

        WordTopic model = new WordTopic();
        JSONObject json = JSONObject.fromObject(map.get("data"));
        model.topic =  json.getString("topic");
        model.answers =  json.getString("answers");
        model.translate =  json.getString("translate");
        model.options1 =  json.getString("options1");
        model.options2 =  json.getString("options2");
        model.options3 =  json.getString("options3");
        model.options4 =  json.getString("options4");


        model.id = Long.valueOf(String.valueOf(map.get("id")));
        return model;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }


    public String getTopic() {
        return topic;
    }

    public String getAnswers() {
        return answers;
    }


    public void setWordId(long wordId) {
        this.wordId = wordId;
    }

    public long getWordId() {
        return wordId;
    }

    public void setTranslate(String translate) {
        this.translate = translate;
    }
    public String getTranslate() {
        return translate;
    }

    public void setOptions1(String options1) {
        this.options1 = options1;
    }

    public void setOptions2(String options2) {
        this.options2 = options2;
    }

    public void setOptions3(String options3) {
        this.options3 = options3;
    }

    public void setOptions4(String options4) {
        this.options4 = options4;
    }

    public String getOptions1() {
        return options1;
    }

    public String getOptions2() {
        return options2;
    }

    public String getOptions3() {
        return options3;
    }

    public String getOptions4() {
        return options4;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getStyle() {
        return style;
    }
}

