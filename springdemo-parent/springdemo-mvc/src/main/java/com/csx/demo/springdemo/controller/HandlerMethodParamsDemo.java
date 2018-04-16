package com.csx.demo.springdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Map;


@Controller
@RequestMapping(value = "/methodParams")
public class HandlerMethodParamsDemo {

    private static Logger logger = LoggerFactory.getLogger(HandlerMethodParamsDemo.class);


    @ModelAttribute
    public void init(Model model){
        model.addAttribute("message", "init message...");
    }

    @ModelAttribute
    public void init1(Model model){
        model.addAttribute("message1", "init message1...");
    }


    @RequestMapping(value = "/demoA")
    @ResponseBody
    public String demoA(HttpServletRequest request,HttpServletResponse response,
                        HttpSession session){
        logger.info("into demoA");
        String id = session.getId();
        logger.info("get session id-->"+id);
        session.setAttribute("userName", "chensongxia");
        logger.info("success set session attr userName");
        return "l am a demoA...";
    }

    //这些参数类型的处理类是ServletRequestMethodArgumentResolver
    @RequestMapping(value = "/demoB")
    @ResponseBody
    public String demoB(HttpMethod method,Principal principal){
        logger.info("into demoB");

        return "l am a demoB...";
    }

    //@PathVariable处理类PathVariableMethodArgumentResolver
    //@RequestParam处理类RequestParamMethodArgumentResolver
    //@RequestHeader处理类RequestHeaderMethodArgumentResolver
    @RequestMapping(value = "/demoC/{path1}")
    @ResponseBody
    public String demoC(@PathVariable String path1,@RequestParam String name,
                        @RequestBody String body){
        logger.info("into demoC");
        return "l am a demoC...";
    }

    //@RequestBody的处理类RequestResponseBodyMethodProcessor
    //@RequestParam能拿到GET或者POST请求中url?name=xxx&age=yyy这种形式的参数
    //拿不到body体中的参数
    //@RequestBody只能用于POST请求
    @RequestMapping(value = "/demoD/{path1}")
    @ResponseBody
    public String demoD(@RequestParam String name,
                        @RequestBody String body,
                        @RequestParam Map<String,Object> params){
        logger.info("into demoD");
        return "l am a demoD...";
    }

    @RequestMapping(value = "/demoE/{path1}")
    @ResponseBody
    public String demoE(Map<String,Object> map,Model model,ModelMap modelMap){
        logger.info("into demoE");
        return "l am a demoE...";
    }
}
