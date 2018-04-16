package com.csx.demo.springdemo.test;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackTest {

    private static Logger logger = LoggerFactory.getLogger(LogbackTest.class);

    public static void main(String[] args) {
        int count = 100000;
        while (count>0) {
            logger.info("l am a logger...{}",count);
            count--;
        }
    }
}
