package com.kuang.myrule;


import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


// https://www.springcloud.cc/spring-cloud-dalston.html#netflix-ribbon-starter
@Configuration
public class KuangRule {

    @Bean
    public IRule myRule(){
//        return new RandomRule();
        return new KuangRandomRule(); // 自定义
    }
}
