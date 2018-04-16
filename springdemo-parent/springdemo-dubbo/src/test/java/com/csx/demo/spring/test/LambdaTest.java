package com.csx.demo.spring.test;

import java.util.ArrayList;
import java.util.Iterator;

public class LambdaTest {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("chensongxia");
        list.add("zhaoru");
        list.add("qianxxx");

        list.forEach(System.out::println);

        list.removeIf(item -> {
            if (item.length() > 10)
                return true;
            else
                return false;
        });

        list.forEach(System.out::println);

    }

}
