package com.csx.demo.springdemo.cookies.abstractclass;

import org.springframework.stereotype.Component;

@Component
public class SelfService1 extends AbstractService {

    public void selfService() {
        System.out.println("selfservice1...");
    }
}
