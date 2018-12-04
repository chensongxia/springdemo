package com.csx.demo.springdemo.tests;

import com.csx.demo.springdemo.cookies.javacodeConfig.BeanConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationConfigTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(BeanConfig.class);
        System.out.println("xx");
    }

}
