package com.csx.demo.springboot.service;

import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl implements MyService {
    @Override
    public void doService() {
        System.out.println("我都不知道自己是谁，但是我还是很勤劳的服务他人...");
    }

    @Override
    public void doService(String name) {
        System.out.println("hi,l am "+name+" 很高兴为您服务员");
    }
}
