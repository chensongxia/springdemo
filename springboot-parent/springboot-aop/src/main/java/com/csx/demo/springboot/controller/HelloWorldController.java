package com.csx.demo.springboot.controller;

import com.csx.demo.springboot.service.MyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hello")
public class HelloWorldController {

    private static Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    @Autowired
    private MyService myService;

    @GetMapping("/world")
    public String echo(String name){
        logger.info("hi {}, welcom to the springboot world...");
        return "hello world...";
    }

    @GetMapping("/service")
    public String service(){
        myService.doService();
        return "服务结束...";
    }

    @GetMapping("/service1")
    public String service1(String name){
        myService.doService(name);
        return "hi"+name+ "服务结束...";
    }


}
