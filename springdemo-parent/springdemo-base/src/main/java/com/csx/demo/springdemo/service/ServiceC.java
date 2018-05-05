package com.csx.demo.springdemo.service;

public abstract class ServiceC {

    //单例类注入原型类的问题
    private ServiceD serviceD;

    public void say(){
        serviceD = createService();
        serviceD.say();
    }

    public abstract ServiceD createService();

}
