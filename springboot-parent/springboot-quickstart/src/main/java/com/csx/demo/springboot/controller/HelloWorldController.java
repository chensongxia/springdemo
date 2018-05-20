package com.csx.demo.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/hello")
public class HelloWorldController {

    private static Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    @GetMapping("/world")
    public String echo(String name){
        logger.info("hi {}, welcom to the springboot world...");
        logger.info("dfffd");
        return "hello world...";
    }

}
