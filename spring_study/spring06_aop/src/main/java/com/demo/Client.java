package com.demo;

public class Client {
    public static void main(String[] args) {

        ProxyInvocationHandle pi = new ProxyInvocationHandle();
        Rent host = new Host();
        //调用程序处理角色，来处理我们调用的接口对象,可以放置任何需要的代理
        pi.setTarget(host);
        Rent hostProxy = (Rent)pi.getProxy();
        hostProxy.rent();

    }

}
