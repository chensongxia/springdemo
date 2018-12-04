package com.csx.demo.springdemo.cookies.methodlookup;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class MyService1 {

    public void service() {
        System.out.println(this.toString() + ":id");
    }

}
