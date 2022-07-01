package com.study.controller;

public enum Occupation {

    Stu(0,"学生"),
    Doc(1,"医生"),
    pol(2,"警察");
    private int id;
    private String value;

    Occupation(int id,String value){
        this.id=id;
        this.value=value;
    }

    String getValue(){
        return this.value;
    }
}
