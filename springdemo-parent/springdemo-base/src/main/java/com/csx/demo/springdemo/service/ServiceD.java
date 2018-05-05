package com.csx.demo.springdemo.service;

public  class ServiceD  {



    public void say(){
        System.out.println("l am serviceD..."+this.toString());
    }

    public ServiceD createService(){
        return this;
    }


}
