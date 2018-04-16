package com.csx.demo.springdemo.service.impl;


import com.csx.demo.springdemo.service.ServiceProvider;

public class ServiceProviderImpl implements ServiceProvider {

    public String sayHello() {
        System.out.println("hi,l am a provider...");
        return "你好,我是provider...";
    }

    public String sayHello(String name) {
        return "hi "+name;
    }
}
