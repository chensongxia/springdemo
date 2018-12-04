package com.csx.demo.springdemo.tests;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoWireTest {

    private static String xx = "ssss";

    public static void main(String[] args) {
//        ApplicationContext app1 = new ClassPathXmlApplicationContext("beans.spring.xml");
//        ((ClassPathXmlApplicationContext)app1).refresh();
//        System.out.println("end...");
        long data = 100L;
        float cc = data;


    }

    static {
        System.out.println(xx);
        xx = "xxxxxx";
        System.out.println(xx);
    }

}
