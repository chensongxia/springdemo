package com.csx.demo.springdemo.cookies.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import javax.annotation.PostConstruct;

@Component
public class ResourceLoaderCookie {

    @Autowired
    private ResourceLoader resourceLoader;

    //推荐使用这种方式
    @Autowired
    private ResourcePatternResolver resolver;

    //classpath:/只加载当前classpath下的文件
    //classpath*:/会加载classpath下jar包中的同名文件
    private static final String path1 = "/cookies.properties";
    private static final String path2 = "/config/cookies.properties";
    private static final String path3 = "classpath:/cookies.properties";
    private static final String path4 = "classpath:/config/cookies.properties";
    private static final String path5 = "classpath*:/**/cookies.properties";
    private static final String path6 = "classpath*:/**/spring.factories";

    @PostConstruct
    public void loadFile() throws Exception{
        Resource resource1 = resourceLoader.getResource(path1);
        byte[] bytes1 = FileCopyUtils.copyToByteArray(resource1.getInputStream());
        System.out.println("从"+path1+"读取文件:");
        System.out.println(new String(bytes1));

        Resource resource2 = resourceLoader.getResource(path2);
        byte[] bytes2 = FileCopyUtils.copyToByteArray(resource2.getInputStream());
        System.out.println("从"+path2+"读取文件:");
        System.out.println(new String(bytes2));

        Resource resource3 = resourceLoader.getResource(path3);
        byte[] bytes3 = FileCopyUtils.copyToByteArray(resource3.getInputStream());
        System.out.println("从"+path3+"读取文件:");
        System.out.println(new String(bytes3));

        Resource resource4 = resourceLoader.getResource(path4);
        byte[] bytes4 = FileCopyUtils.copyToByteArray(resource4.getInputStream());
        System.out.println("从"+path4+"读取文件:");
        System.out.println(new String(bytes4));

        Resource[] resource5 = ((ClassPathXmlApplicationContext)resourceLoader).getResources(path5);
        byte[] bytes5 = FileCopyUtils.copyToByteArray(resource5[0].getInputStream());
        System.out.println("从"+path5+"读取文件:");
        System.out.println(new String(bytes5));

        Resource[] resource6 = ((ClassPathXmlApplicationContext)resourceLoader).getResources(path6);
        byte[] bytes6 = FileCopyUtils.copyToByteArray(resource6[0].getInputStream());
        System.out.println("从"+path6+"读取文件:");
        System.out.println(new String(bytes6));

        System.out.println("end...");
    }

}
