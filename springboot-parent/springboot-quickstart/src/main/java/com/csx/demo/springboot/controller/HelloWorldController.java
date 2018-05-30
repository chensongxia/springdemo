package com.csx.demo.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/hello")
public class HelloWorldController {

    private static Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    @GetMapping("/world")
    public String echo(String name){
        logger.info("hi {}, welcom to the springboot world...");
        return "hello world...";
    }

    @GetMapping("/getJSON")
    public Map<String,Object> getJSON(){
        Map<String,Object> map = new HashMap<>();
        map.put("chen","songxia");
        map.put("zhao","ru");
        return map;
    }

}
