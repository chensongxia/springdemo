package com.csx.demo.springdemo.controller;

import com.csx.demo.springdemo.service.AsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/executor")
public class TaskExecutorDemo {

    private static Logger logger = LoggerFactory.getLogger(TaskExecutorDemo.class);

    @Resource(name="myExecutor")
    private TaskExecutor taskExecutor;

    @Autowired
    private AsyncService asyncService;

    @RequestMapping("/demoA")
     @ResponseBody
     public String demoA(){
        for(int i=0;i<50;i++){
            MessagePrinterTask task = new MessagePrinterTask("message-->"+i);
            taskExecutor.execute(task);
        }
        logger.info("task end...");
        return "a successful demoA...";
    }

    @RequestMapping("/demoB")
    @ResponseBody
    public String demoB(){
        asyncService.printMessage();
        logger.info("task end...");
        return "a successful demoB...";
    }

    private class MessagePrinterTask implements Runnable {
        private String message;
        public MessagePrinterTask(String message) {
            this.message = message;
        }
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            logger.info(message);
        }
    }
}
