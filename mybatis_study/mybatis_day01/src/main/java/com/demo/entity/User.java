package com.demo.entity;

public class User {
    private Integer id;
    private String userName;
    private Integer age;
    private String gender;
    private Integer parent;

    public User() {
        // TODO document why this constructor is empty
    }

    public User(Integer id, String userName, Integer age) {
        this.id = id;
        this.userName = userName;
        this.age = age;
    }

    public User(Integer id, String userName, Integer age, String gender, Integer parent) {
        this.id = id;
        this.userName = userName;
        this.age = age;
        this.gender = gender;
        this.parent = parent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", parent=" + parent +
                '}';
    }
}
