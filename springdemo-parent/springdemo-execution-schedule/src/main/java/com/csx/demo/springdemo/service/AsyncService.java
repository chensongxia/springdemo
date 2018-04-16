package com.csx.demo.springdemo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Service
public class AsyncService {

    private static Logger logger = LoggerFactory.getLogger(AsyncService.class);

    @Async("myExecutor")
    public void printMessage() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("l am a async method...xx");
    }

    @Async("myExecutor")
    Future<String> returnSomething(int i) {
        return null;
    }
}
