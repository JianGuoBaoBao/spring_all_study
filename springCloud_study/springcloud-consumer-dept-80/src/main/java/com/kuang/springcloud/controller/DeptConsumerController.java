package com.kuang.springcloud.controller;


import com.kuang.springcloud.pojo.Dept;
import com.kuang.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {

    // 消费者，不应该有service层
    // RestTemplate ...供我们之间调用， 注册到springboot中
    // (url, 实体： Map, Class<T> responseType)


    @Autowired
    private RestTemplate restTemplate;  // 提供多种便捷访问远程http服务的方法， 简单的restful服务模板

    // Ribbon 我们这里的地址应该是个变量， 通过服务名来访问
    // Ribbon 和 Eureka整合以后， 客户端可以直接访问， 不用关心IP地址和端口
    // private static final String REST_URL_PREFIX = "http://localhost:8001";
     private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIER-DEPT";


    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
    }

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/"+id, Dept.class);
    }

    @RequestMapping("/consumer/dept/list")
    public List queryAll(){
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
    }



    // RestTemplate可以适用但是java需要更规范的写法,Feign意指在使编写JavaHttp客户端变得容易
    // 前面在使用Ribbon + RestTemplate时，利用RestTemplate对Http请求的封装处理，形成了一套模板化的调用方法。但是在实际开发中。
    // 由于对服务依赖的调用可能不止一处，往往一个接口会被多出调用，，所以通常都会针对每个微服务自行封装一些客户端类来包装这些依赖服务的费用。
    // 所以Feign在此基础上做了进一步封装，有他来帮助我们定义和实现依赖服务接口的定义，在Feign的实现下，我们指需要床架一个接口并使用注解的方式来配置
    // 它（类似于以前Dao接口上标志Mapper注解，现在是一个微服务接口上面标注一个Feign注解即可完成对服务提供方的接口绑定，简化了使用Spring Cloud Ribbon时
    // 自动封装服务调用客户端的开发量

//    @Autowired
//    private DeptClientService service = null;
//
//    @RequestMapping(name = "/consumer/dept/add" , produces={"application/json;charset=UTF-8"})
//    public boolean add1(Dept dept){
//        return service.addDept(dept);
//    }
//
//    @RequestMapping(name = "/consumer/dept/get/{id}" ,produces={"application/json;charset=UTF-8"})
//    public Dept get1(@PathVariable("id") Long id){
//        return service.queryById(id);
//    }
//
//    @RequestMapping(name ="/consumer/dept/list" , produces={"application/json;charset=UTF-8"})
//    public List queryAll1(){
//        return service.queryAll();
//    }
}
