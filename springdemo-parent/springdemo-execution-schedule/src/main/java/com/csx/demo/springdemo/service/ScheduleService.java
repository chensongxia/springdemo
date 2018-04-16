package com.csx.demo.springdemo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@Service
public class ScheduleService {

    private static Logger logger = LoggerFactory.getLogger(ScheduleService.class);

    //@Scheduled(fixedDelay=500)
    public void demoA(){
        logger.info("l am schedule demoA...");
    }

    //@Scheduled(fixedDelay=500)
    public void demoB(){
        logger.info("l am schedule demoB...");
    }

    //@Scheduled(fixedDelay=500)
    public void demoC(){
        logger.info("l am schedule demoC...");
    }
}
