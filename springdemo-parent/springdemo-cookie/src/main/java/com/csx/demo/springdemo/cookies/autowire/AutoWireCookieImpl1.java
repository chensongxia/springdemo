package com.csx.demo.springdemo.cookies.autowire;

import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Integer.MIN_VALUE+3)
public class AutoWireCookieImpl1 implements IAutoWireCookie {
    public void injectCookie() {
        System.out.println("inject cookie1...");
    }
}
