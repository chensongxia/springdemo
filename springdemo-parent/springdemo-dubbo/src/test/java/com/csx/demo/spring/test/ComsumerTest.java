package com.csx.demo.spring.test;

import com.csx.demo.springdemo.service.ServiceProvider;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ComsumerTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext(
                new String[]{"dubbo.comsumer.xml"});
        app.start();
        ServiceProvider provider = (ServiceProvider)app.getBean("serviceProvider");
        provider.sayHello();
        String ss = provider.sayHello("chensongxia");
        System.out.println("xxxx"+ss);
    }
}
