package com.csx.demo.springdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping(value = "/base")
public class BaseDemo {

    Logger logger = LoggerFactory.getLogger(BaseDemo.class);

    @RequestMapping(value = "/demoA",method = RequestMethod.GET)
    @ResponseBody
    public String demoA(String name){
        return "l am demoaA...";
    }

    @GetMapping(value = "/{pathValue}")
    @ResponseBody
    public String demoB(@PathVariable String pathValue,
                        @PathVariable Map<String,String> params ){
        logger.info("get path value:"+pathValue);
        return "l am demoaB...";
    }

    //match /demoC/xx
    @GetMapping(value = "/demoC/*")
    @ResponseBody
    public String demoC(){
        return "l am demoaC...";
    }

    //match /demoC/xx/xx/xx
    @GetMapping(value = "/demoC/**")
    @ResponseBody
    public String demoD(){
        return "l am demoaD...";
    }

    //占位符
    @GetMapping(value = "/${path1}/**")
    @ResponseBody
    public String demoE(){
        return "l am demoa...";
    }

    //只匹配Content-Type是json的请求
    @GetMapping(value = "/demoF/xx",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String demo(){
        return "l am demoaF...";
    }

    //只匹配accept-Type是json的请求
    @GetMapping(value = "/demoG/xx",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String demoG(){
        return "l am demoaG...";
    }


    //如果请求中有param这个参数就不匹配
    //http://localhost:8080/base/demoH/xx?param=chen
    @GetMapping(value = "/demoH/xx",params = "!param")
    @ResponseBody
    public String demoH(){
        return "l am demoaH...";
    }

    //请求参数中必须要有param这个参数，而且值一定要是chen才能匹配上
    @GetMapping(value = "/demoI/xx",params = "param=chen")
    @ResponseBody
    public String demoI(){
        return "l am demoaI...";
    }

    //请求头中必须要有param这个参数，而且值一定要是chen才能匹配上
    @GetMapping(value = "/demoJ/xx",headers = "param=chen")
    @ResponseBody
    public String demoJ(){
        return "l am demoaJ...";
    }


}
