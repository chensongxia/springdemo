package com.csx.demo.springdemo.cookies.autowire;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Integer.MIN_VALUE+2)
public class AutoWireCookieImpl2 implements IAutoWireCookie {
    public void injectCookie() {
        System.out.println("inject cookie2...");
    }
}
