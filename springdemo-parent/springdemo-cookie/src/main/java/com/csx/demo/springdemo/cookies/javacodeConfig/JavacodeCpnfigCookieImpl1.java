package com.csx.demo.springdemo.cookies.javacodeConfig;


import org.springframework.stereotype.Component;

@Component
public class JavacodeCpnfigCookieImpl1 implements JavacodeConfigCookie {
    public void makeCookie() {
        System.out.println("cookie1");
    }
}
