package com.csx.demo.spring.test;

import java.io.Externalizable;
import java.io.Serializable;


public class Person implements Serializable {

    private String name;
    private int age;
    private transient String nickName;
    private Student student;

    private static String xx = "chen";
    private String cc = "zhao";

    static {
        System.out.println("xx:"+xx);
        System.out.println("l am a static block...");
    }

    {
        System.out.println("l am a normal block...");
        System.out.println("cc"+cc);
    }

    public Person(String name){
        System.out.println("l am constrcscd...");
        System.out.println("cc:"+cc);
    }

    public static void main(String[] args) {
        Person p = new Person("ccc");
    }

    public void showSkill(){
        System.out.println("l am"+name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
