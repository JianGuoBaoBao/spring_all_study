package com.demo.entity;


import org.apache.ibatis.type.Alias;

@Alias("user") // 别名
public class User {
    private Integer id;
    private String username;
    private Integer age;
    private String gender;

    private Integer parentname; // 设置与数据库字段不对应的实体类

    public User() {
        // TODO document why this constructor is empty
    }

    public User(Integer id, String username, Integer age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }

    public User(Integer id, String username, Integer age, String gender, Integer parentname) {
        this.id = id;
        this.username = username;
        this.age = age;
        this.gender = gender;
        this.parentname = parentname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
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

    public Integer getParentname() {
        return parentname;
    }

    public void setParentname(Integer parentname) {
        this.parentname = parentname;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", parentname=" + parentname +
                '}';
    }
}
