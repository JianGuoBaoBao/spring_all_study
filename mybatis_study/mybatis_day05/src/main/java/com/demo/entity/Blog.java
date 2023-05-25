package com.demo.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author wanglingjie
 */
@Data
public class Blog {
    private String id;
    private String title;
    private String author;
    private Date createTime;
    private int views;
}
