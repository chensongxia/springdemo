package com.csx.demo.springdemo.cookies.javacodeConfig;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionBeanConfig {

    @Bean
    public String str1(){
        return "xx";
    }

}
