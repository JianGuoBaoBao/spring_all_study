package com.demo.entity;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Parent{
    private int parentId;
    private String fatherName;
    private String motherName;

    private User user;
}
