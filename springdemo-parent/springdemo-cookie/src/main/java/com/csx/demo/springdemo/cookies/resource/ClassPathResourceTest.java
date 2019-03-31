package com.csx.demo.springdemo.cookies.resource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;

public class ClassPathResourceTest {

    public static void main(String[] args) throws Exception {
        String path1 = "/cookies.properties";
        String path2 = "/config/cookies.properties";
        Resource resource = new ClassPathResource(path1);
        byte[] bytes = FileCopyUtils.copyToByteArray(resource.getInputStream());
        System.out.println(new String(bytes));
    }

}
