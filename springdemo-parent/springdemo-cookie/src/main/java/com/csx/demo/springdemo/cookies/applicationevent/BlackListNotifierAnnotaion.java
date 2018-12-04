package com.csx.demo.springdemo.cookies.applicationevent;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class BlackListNotifierAnnotaion {

    //Order的值越小，越先被调用
    //基于注解@EventListener的Listenner永远先与传统的实现ApplicationListener接口的Listenner被调用。
    @Order(Integer.MIN_VALUE+1)
    @EventListener(classes = {BlackListEvent.class,ContextRefreshedEvent.class})
    public void processEvent(ApplicationEvent event){
        if(event instanceof BlackListEvent){
            System.out.println("收到BlackListEvent1");
        }
        if(event instanceof ContextRefreshedEvent){
            System.out.println("收到ContextRefreshedEvent1");

        }
    }

    @Order(Integer.MIN_VALUE+2)
    @EventListener(classes = {BlackListEvent.class,ContextRefreshedEvent.class})
    public void processEvent2(ApplicationEvent event){
        if(event instanceof BlackListEvent){
            System.out.println("收到BlackListEvent2");
        }
        if(event instanceof ContextRefreshedEvent){
            System.out.println("收到ContextRefreshedEvent2");

        }
    }

}
