package com.csx.demo.springdemo.cookies.methodlookup;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

@Service
public abstract class MyService {

    private MyService1 service1;

    public void useService(){
        service1 = createService1();
        service1.service();
    }

    @Lookup("myService1")
    public abstract MyService1 createService1();

}
