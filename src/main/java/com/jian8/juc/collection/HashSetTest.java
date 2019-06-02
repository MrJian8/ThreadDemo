package com.jian8.juc.collection;

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * hashSet线程不安全
 */
public class HashSetTest {
    public static void main(String[] args) {
//        notSafe();
//        safe1();
        safe2();
    }
    /**
     * 故障现象
     * java.util.ConcurrentModificationException
     */
    public static void notSafe() {
        Set<String> list = new HashSet<>();
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, "Thread " + i).start();
        }
    }
    public static void safe1() {
        Set<String> list = Collections.synchronizedSet(new HashSet<>());
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, "Thread " + i).start();
        }
    }

    public static void safe2() {
        Set<String> list = new CopyOnWriteArraySet<>();
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, "Thread " + i).start();
        }
    }
}
