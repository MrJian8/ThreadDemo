package com.jian8.juc.test;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
//        Runtime runtime = Runtime.getRuntime();
//        System.out.println(runtime.availableProcessors());//线程数
//        System.out.println(runtime.totalMemory()/(double)1024);//初始内存-Xms
//        System.out.println(runtime.maxMemory()/(double)1024);//最大内存-Xmx
        String str = "jian8";
        while (true){
            str += str+new Random().nextInt(88888888)+new Random().nextInt(88888888);
        }
    }
}
