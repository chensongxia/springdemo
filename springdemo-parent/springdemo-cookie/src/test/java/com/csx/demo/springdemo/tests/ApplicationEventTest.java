package com.csx.demo.springdemo.tests;

import com.csx.demo.springdemo.cookies.applicationevent.EmailService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationEventTest {

    public static void main(String[] args) {
        ApplicationContext app1 = new ClassPathXmlApplicationContext("beans.spring.xml");
        EmailService service = app1.getBean(EmailService.class);
        service.sendEmail("chenxx@sina.com","你好,我在给你发邮件...");
        service.sendEmail("qianxx@sina.com","你好,我在给你发邮件...");
        System.out.println("end...");
    }

}
