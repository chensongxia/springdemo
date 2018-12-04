package com.csx.demo.springdemo.cookies.lifecycle;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class LifeCycleCookieBean implements InitializingBean , SmartLifecycle, BeanNameAware {

    @Value("${spring.lifecycle.key1}")
    private String cookieName;

    private String beanName;

    //首先执行
    public LifeCycleCookieBean(){
        System.out.println("l am construction...");
    }

    //在Bean的属性被设置后执行
    @PostConstruct
    public void postConstruct(){
        System.out.println("我在构造函数后面执行...");
        System.out.println("我拿到cookie的名字是:"+cookieName);
    }

    //在postConstruct后执行
    public void afterPropertiesSet() throws Exception {
        System.out.println("我在cookie的名字被设置后执行...");
        System.out.println("我拿到Cookie的名字是:"+cookieName);
    }

    //最后执行
    public void init(){
        System.out.println("我是Bean自己配置的初始化方法，我最后被执行...");
    }


    public boolean isAutoStartup() {
        return false;
    }

    public void stop(Runnable runnable) {

    }

    public void start() {
        System.out.println("我开始跑了...");
    }

    public void stop() {

    }

    public boolean isRunning() {
        return false;
    }

    public int getPhase() {
        return 0;
    }

    public void setBeanName(String beanName) {
        System.out.println("正在设置Bean名字...");
        this.beanName = beanName;
    }
}
