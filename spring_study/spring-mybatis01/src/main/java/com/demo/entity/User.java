package com.demo.entity;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String userName;
    private Integer age;
    private String gender;
    private Integer parent;
}
