package com.csx.demo.springboot.util;

public class ForEcheUtil {

    public static <T> void foreche(T[] array){
        for (T item:array){
            System.out.println("get item:"+item.toString());
        }
    }

    public static void main(String[] args) {
        String[] arr = new String[]{"sdf","sfd"};
        ForEcheUtil.foreche(arr);
    }

}
