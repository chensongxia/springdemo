package com.csx.demo.spring.test;

public class OutterClass {

    private String name;
    private InnerClass innerClass = new InnerClass("chensongxia");

    public OutterClass(String name){
        this.name = name;
    }

    public OutterClass(String name,InnerClass innerClass){
        this.name = name;
        this.innerClass = innerClass;
    }

    public void say(){
        System.out.println("out name-->"+name);
        innerClass.say();
    }

    public static void main(String[] args) {
        OutterClass outterClass = new OutterClass("zhaoru...");
        outterClass.say();

        //我们需要先new一个OutterClass的对象后，再通过这个对象创建内部类
        //OutterClass.InnerClass var = new OutterClass.new InnerClass()
        OutterClass.InnerClass inClass = outterClass.new InnerClass("chenhui...");
        OutterClass outterClass1 = new OutterClass("qiandanping...",inClass);
        outterClass1.say();
    }

    private class InnerClass{
        private String name;

        public InnerClass(String name){
            this.name = name;
        }

        public void say(){
            System.out.println(name);
        }

    }

}
