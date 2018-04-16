package com.csx.demo.springdemo.controller;

import ch.qos.logback.classic.LoggerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    private static Logger log = LoggerFactory.getLogger(HelloWorldController.class);

    @RequestMapping("/world")
    @ResponseBody
    public String helloWorld(){

            log.info("hello world... l am a controller.");
            LoggerContext context =(LoggerContext) LoggerFactory.getILoggerFactory();
            //contex是这个配置的上下文

        return "hello";
    }

}
