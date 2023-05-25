package com.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyInvocationHandle implements InvocationHandler {

    private Object target;
    public void setTarget(Object target){
        this.target = target;
    }


    //生成得到代理类
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                target.getClass().getInterfaces(),//代表接口
                this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log(method.getName());
        //动态代理的本质，就是使用反射机制实现；
        return method.invoke(target,args);
    }

    public void log(String msg){
        System.out.println("执行了"+msg+"方法");
    }
}
