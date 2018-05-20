package com.csx.demo.springboot.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {

    //PointCut匹配的方法必须是Spring中bean的方法
    //Pointcut可以有下列方式来定义或者通过&& || 和!的方式进行组合.
    //下面定义的这些切入点就可以通过&& ||组合

    private static Logger logger = LoggerFactory.getLogger(MyAspect.class);

    //*:代表方法的返回值可以是任何类型
    //整个表达式匹配controller包下面任何的的echo方法，方法入参乐意是任意
    @Pointcut("execution(* com.csx.demo.springboot.controller.*.echo(..))")
    public void pointCut1(){}

    //代表echo方法必须有一个参数 参数的类型可以是任意类型
    @Pointcut("execution(* com.csx.demo.springboot.controller.*.echo(*))")
    public  void pointCut2(){}

    //代表echo方法必须有两个参数，第一个类型任意，第二个类型必须是String
    @Pointcut("execution(* com.csx.demo.springboot.controller.*.echo(*,String))")
    public void pointCut3(){}

    //contrller包及其子包下面的任意类的任意方法
    //需要注意的是with和@with都是正对包级别的
    @Pointcut("within(com.csx.demo.springboot.controller..*)")
    public void pointCut4(){}

    //使用RestController这个注解标注任意类的任意方法
    @Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
    public void pointCut5(){}

    //用法和@Within类似
    @Pointcut("@target(org.springframework.web.bind.annotation.RestController)")
    public void pointCut10(){}

    //MyService这个接口实现类的任何方法
    //如果MyService是一个类的话，那匹配这个类内部的所有方法
    @Pointcut("this(com.csx.demo.springboot.service.MyService)")
    public void pointCut6(){}

    @Pointcut("this(com.csx.demo.springboot.service.MyServiceImpl)")
    public void pointCut7(){}

    //某个bean内部的所有方法
    @Pointcut("bean(myServiceImpl)")
    public void pointCut8(){}

    //@within和@target针对类的注解,@annotation是针对方法的注解
    //匹配任何标注GetMaping注解的方法
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void pointCut9(){}

    //匹配只有一个参数，参数类型是String的方法
    @Pointcut("args(String)")
    public void pointCut11(){}


    @Before("pointCut1()")
    public void befor(){
        logger.info("前置通知vvvv...");
        logger.info("我要做些事情...");
    }

    @After("pointCut1()")
    public void after(){
        logger.info("后置通知");
    }

    @AfterReturning("pointCut1()")
    public void afterReturn(){
       logger.info("后置返回");
    }

    @Around("pointCut1()")
    public void around(ProceedingJoinPoint point) throws Throwable {
        logger.info("环绕通知...");
        logger.info("我要做些事情...");
        point.proceed();
        logger.info("结束环绕通知");
    }

}
