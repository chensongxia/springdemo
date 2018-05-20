package com.csx.demo.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootAppAOP {

    private static Logger logger = LoggerFactory.getLogger(SpringBootAppAOP.class);

    public static void main(String[] args) {
        logger.info("app xxxx success...");
        SpringApplication.run(SpringBootAppAOP.class,args);
        logger.info("app start success...");
    }
}
