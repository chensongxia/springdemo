package com.csx.demo.springdemo.cookies.abstractclass;

import org.springframework.stereotype.Component;

@Component
public class SelfService2 extends AbstractService {
    public void selfService() {
        System.out.println("selfService2...");
    }
}
