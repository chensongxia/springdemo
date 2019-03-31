package com.csx.demo.springdemo.tests;

import org.springframework.util.FileCopyUtils;

import java.net.URL;

public class ClassLoaderTest {

//    public static void main(String[] args) throws Exception {
//        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
//        URL resource = contextClassLoader.getResource("config/cookies.properties");
//        //resource = contextClassLoader.getSystemResource("/config/cookies.properties");
//        byte[] bytes = FileCopyUtils.copyToByteArray(resource.openStream());
//        System.out.println(new String(bytes));

//        Class<ClassLoaderTest> aClass = ClassLoaderTest.class;
//        URL resource1 = aClass.getResource("cookies.properties");
//        byte[] bytes1 = FileCopyUtils.copyToByteArray(resource1.openStream());
//        System.out.println(new String(bytes1));
//        System.out.println(System.getProperty("java.class.path"));
////        System.out.println("user.dir: " + System.getProperty("user.dir"));
////    }

    Class<ClassLoaderTest> cls = ClassLoaderTest.class;
    ClassLoader ldr = cls.getClassLoader(); // Thread.currentThread().getContextClassLoader()

    public static void println(Object s) {
        System.out.println(s);
    }

    void showResource(String name) {
        println("## Test resource for: “" + name + "” ##");
        println(String.format("ClassLoader#getResource(\"%s\")=%s", name, ldr.getResource(name)));
        println(String.format("Class#getResource(\"%s\")=%s", name, cls.getResource(name)));
    }
    public final void testForResource() throws Exception {
        showResource("");
        showResource("/");
        showResource(cls.getSimpleName() + ".class");
        String n = cls.getName().replace('.', '/') + ".class";
        showResource(n);
        showResource("/" + n);
        showResource("java/lang/Object.class");
        showResource("/java/lang/Object.class");
    }

    public static void main(String[] args) throws Exception {
        println("java.class.path: " + System.getProperty("java.class.path"));
        println("user.dir: " + System.getProperty("user.dir"));
        println("");
        ClassLoaderTest t = new ClassLoaderTest();
        t.testForResource();
    }

}
