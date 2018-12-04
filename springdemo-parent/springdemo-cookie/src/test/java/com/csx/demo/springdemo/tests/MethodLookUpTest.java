package com.csx.demo.springdemo.tests;

import com.csx.demo.springdemo.cookies.methodlookup.MyService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.SimpleIdGenerator;

public class MethodLookUpTest {

    public static void main(String[] args) {
        ApplicationContext app1 = new ClassPathXmlApplicationContext("beans.spring.xml");
        ((ClassPathXmlApplicationContext)app1).start();
        MyService bean = app1.getBean(MyService.class);
        bean.useService();
        bean.useService();

        SimpleIdGenerator simpleIdGenerator = new SimpleIdGenerator();
        System.out.println(simpleIdGenerator.generateId());
    }

}
