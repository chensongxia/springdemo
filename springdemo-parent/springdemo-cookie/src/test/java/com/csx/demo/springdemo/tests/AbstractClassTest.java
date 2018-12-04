package com.csx.demo.springdemo.tests;

import com.csx.demo.springdemo.cookies.abstractclass.AbstractService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class AbstractClassTest {

    public static void main(String[] args) {
        ApplicationContext app1 = new ClassPathXmlApplicationContext("beans.spring.xml");
        Map<String, AbstractService> beans = app1.getBeansOfType(AbstractService.class);
        for (String beanName : beans.keySet()){
            AbstractService bean = beans.get(beanName);
            System.out.println("beanName:"+beanName);
            bean.commonService();
            bean.selfService();
        }
    }


}
