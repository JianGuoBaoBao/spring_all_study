package com.demo.config;

import com.demo.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration //这个也会被spring容器托管，注册到容器中，就是一个component，是个配置类和beans.xml一样
@ComponentScan("com.demo.entity")
@Import(UserConfig2.class)
public class UserConfig {


    // 注册一个bean, 就相当于之前写的一个bean标签
    // 这个方法的名字，就相当于bean标签中的id属性
    // 这个方法的返回值，就相当于bean标签中的class属性
    @Bean
    public User getUser(){
       return new User(); //返回要注入到bean的对象
    }
}
