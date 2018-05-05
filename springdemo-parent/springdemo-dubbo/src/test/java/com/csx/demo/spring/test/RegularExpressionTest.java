package com.csx.demo.spring.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {

    public static void main(String[] args) {
        String regularExp = "\\w+";
        System.out.println(regularExp);
        Pattern pattern = Pattern.compile(regularExp);
        Matcher matcher = pattern.matcher("chensongxia");
        System.out.println(matcher.matches());
    }

}
