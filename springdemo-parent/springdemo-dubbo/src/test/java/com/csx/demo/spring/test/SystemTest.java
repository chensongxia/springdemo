package com.csx.demo.spring.test;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class SystemTest {

    public static void main(String[] args) {
        Properties properties = System.getProperties();
        Set<String> set = properties.stringPropertyNames();

        set.forEach(key->{
            System.out.println(key+"-->"+properties.getProperty(key));
        });

        System.out.println("------------------------------------");

        Map<String,String> map = System.getenv();
        map.forEach((key,value)->{
            System.out.println(key+"-->"+value);
        });


    }

}
