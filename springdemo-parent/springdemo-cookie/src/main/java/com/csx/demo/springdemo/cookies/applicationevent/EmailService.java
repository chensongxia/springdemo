package com.csx.demo.springdemo.cookies.applicationevent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService {

    @Value("#{'${spring.email.list}'.split(',')}")
    private List<String> blackList;

    @Autowired
    private ApplicationEventPublisher publisher;

    public void sendEmail(String address, String content) {
        //通知黑名单用户
        if (blackList.contains(address)) {
            publisher.publishEvent(new BlackListEvent(this, address, content));
            return;
        }
        //正常发送邮件
        System.out.println("邮件已经发送给用户:"+address);
        return;
    }

}
