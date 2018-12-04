package com.csx.demo.springdemo.cookies.autowire;

import com.csx.demo.springdemo.cookies.abstractclass.SelfService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.Set;

@Service
public class Cookie {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private IAutoWireCookie[] cookies;

    @Autowired
    private Set<IAutoWireCookie> cookieSet;

    @Autowired
    private Map<String,IAutoWireCookie> cookiesMap;

//    @Autowired
//    private Map<String,Map<String,String>> map;

    @PostConstruct
    public void showAutowireInfo(){
        System.out.println("...");
    }

}
