package com.demo;

public class Proxy2 implements Rent{
    private Host host;

    public Proxy2() {
    }

    public Proxy2(Host host) {
        this.host = host;
    }

    public void rent() {
        System.out.println("代理租房子");
    }
    public void seeHouse(){
        System.out.println("中介带你看房子");
    }
    public void fare(){
        System.out.println("收中介费");
    }
    public void hetong(){
        System.out.println("签合同");
    }
}
