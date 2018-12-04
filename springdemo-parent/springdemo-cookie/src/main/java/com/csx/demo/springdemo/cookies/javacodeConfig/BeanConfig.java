package com.csx.demo.springdemo.cookies.javacodeConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.csx.demo.springdemo.cookies.javacodeConfig.**"})
public class BeanConfig {

    @Bean
    public JavacodeConfigCookieImpl2 xx(){
        return new JavacodeConfigCookieImpl2();
    }

}
