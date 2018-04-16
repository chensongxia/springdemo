package com.csx.demo.springdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/schedule")
public class TaskSchedulerDemo {

    private static Logger logger = LoggerFactory.getLogger(TaskExecutorDemo.class);

    //Scheduled注解的方法一般没有入参
    @Scheduled(fixedDelay=5000)
    public void demoA(){
        logger.info("l am schedule demoA...");
    }

    @Scheduled(cron = "0/2 * * * * ?")
    public void demoB(){
        logger.info("l am schedule demoB...");
    }

}
