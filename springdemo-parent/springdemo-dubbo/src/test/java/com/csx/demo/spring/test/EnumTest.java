package com.csx.demo.spring.test;

public enum  EnumTest implements Runnable {

    MALE("male"){
        @Override
        public void run() {
            System.out.println("l like run...");
        }

        @Override
        public void tellSex() {
            System.out.println("l am a man");
        }
    },

    Female("female"){
        @Override
        public void run() {
            System.out.println("l hate running...");
        }

        @Override
        public void tellSex() {
            System.out.println("l am a gile");
        }
    };

    private String sex;

    //默认是private修饰
    EnumTest(String sex){
        this.sex = sex;
    }
    //包含抽象方法
    public abstract void tellSex();
}
