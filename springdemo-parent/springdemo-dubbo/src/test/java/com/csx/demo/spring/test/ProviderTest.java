package com.csx.demo.spring.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProviderTest {

    public static void main(String[] args) throws Exception{

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"dubbo.provider.xml"});
        context.start();
        // press any key to exit
        System.in.read();
    }

}
