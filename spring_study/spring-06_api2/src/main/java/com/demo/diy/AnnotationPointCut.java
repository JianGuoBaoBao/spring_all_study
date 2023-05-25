package com.demo.diy;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AnnotationPointCut {

    @Before("execution(* com.demo.service.UserServiceImpl.*(..))")
    public void before(){
        System.out.println("++++方法使用前+++");
    }

    @After("execution(* com.demo.service.UserServiceImpl.*(..))")
    public void after(){
        System.out.println("++++方法使用后+++");
    }

    //环绕增强中，我们可以给定一个参数，代表我们要 获取处理切入的点；
    @Around("execution(* com.demo.service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕前");
        joinPoint.getSignature();//获得签名
        System.out.println( joinPoint.getSignature());

        //执行方法
        Object proceed = joinPoint.proceed();
        System.out.println("环绕后");

        System.out.println(proceed);
    }
}
