package com.csx.demo.springdemo.factory;

import com.csx.demo.springdemo.service.ServiceA;
import com.csx.demo.springdemo.service.ServiceB;

public class ServiceFactory {

    ServiceA serviceA = new ServiceA();
    ServiceB serviceB = new ServiceB();

    public ServiceA getServiceA() {
        return serviceA;
    }

    public ServiceB getServiceB(){
        return serviceB;
    }
}
