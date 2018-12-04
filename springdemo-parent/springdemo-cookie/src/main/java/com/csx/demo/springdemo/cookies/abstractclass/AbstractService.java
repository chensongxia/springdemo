package com.csx.demo.springdemo.cookies.abstractclass;

public abstract class AbstractService {

    private static final String str1 = "abstratct";

    public void commonService(){
        System.out.println("common service...");
    }

    public abstract void selfService();

}
