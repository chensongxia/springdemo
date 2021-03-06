package com.csx.demo.springdemo.controller;

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
        return "hello";
    }

}
