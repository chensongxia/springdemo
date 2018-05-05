package com.csx.demo.springdemo.test;

import com.csx.demo.springdemo.service.ServiceA;
import com.csx.demo.springdemo.service.ServiceC;
import com.csx.demo.springdemo.service.ServiceD;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String []{"beans.spring.xml"});
        ServiceA serviceA = context.getBean("serviceA", ServiceA.class);
        ServiceA serviceA_alisa = context.getBean("serviceA_alise",ServiceA.class);
        ServiceA serviceA_factory = context.getBean("serviceA_factory",ServiceA.class);
        serviceA.service();
        serviceA_alisa.service();
        serviceA_factory.service();

        ServiceC serviceC =(ServiceC) context.getBean("serviceC");
        serviceC.say();
        serviceC.say();

    }

}
