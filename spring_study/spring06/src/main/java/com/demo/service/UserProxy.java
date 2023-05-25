package com.demo.service;

public class UserProxy implements UserService {
    UserServiceImpl usi = new UserServiceImpl();

    private void log(String log){
        System.out.println(log+"方法");
    }

    public void add() {
        log("add");
        usi.add();
    }

    public void delete() {
        log("del");
        usi.delete();
    }

    public void update() {
        log("update");
        usi.update();
    }

    public void query() {
        log("query");
        usi.query();
    }
}
