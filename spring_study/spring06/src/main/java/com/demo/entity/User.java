package com.demo.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component //等价于<bean id="user" class="com.demo.entity.user"> //把类当做bean
@Scope("prototype")  //等价于<bean scope="prototype">
public class User {
    @Value("meepo")  //等价于 <property name="name" value="meepo">
    public String name;


}
