package com.csx.demo.springdemo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

//@CrossOrigin 支持所有origins
//@CrossOrigin(origins = "http://domain2.com", maxAge = 3600)
//上面这种配置，如果想修改origins的值，每次要修改代码再发版，如果不想
//修改代码，可以考虑在Springmvc.xml中配置。
//<mvc:cors>
//<mvc:mapping path="/cross/*"/>
//</mvc:cors>
//@CrossOrigin(origins = "http://domain2.com", maxAge = 3600)
//@CrossOrigin
@Controller
@RequestMapping("/cors")
public class CORSDemo {

    @RequestMapping(value = "/demoA",method = RequestMethod.GET )
    @ResponseBody
    //@CrossOrigin
    public String demoA(){
        return "l am demo Axx...";
    }
}
