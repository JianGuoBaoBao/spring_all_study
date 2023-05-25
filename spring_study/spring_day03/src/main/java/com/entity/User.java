package com.entity;

public class User {
    private String name;
    private Detail detail;
    private Student student;
    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }

    public void show(){
        System.out.println("show方法");
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name, Detail detail) {
        this.name = name;
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "com.entity.User{" +
                "name='" + name + '\'' +
                '}';
    }

    public User(Detail detail) {
        this.detail = detail;
    }
}
