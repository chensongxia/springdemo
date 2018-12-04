package com.csx.demo.springdemo.cookies.applicationevent;

import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class BlackListNotifier implements ApplicationListener<BlackListEvent> {

    public void onApplicationEvent(BlackListEvent blackListEvent) {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("用户:"+blackListEvent.getAddress()+"你好，你已经进入邮件黑名单...");
    }
}
