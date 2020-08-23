package com.example.demo.JUC;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 请举例说明集合类是不安全的
 */
public class NotSafeDemo {
    public static void main(String[] args) {

//        List<String> list = Arrays.asList("a","b","c");
//        list.forEach(System.out::println);
        List<String> list = new CopyOnWriteArrayList<>();
                //Collections.synchronizedList(new ArrayList<>());
                //new Vector<>();
                //new ArrayList<>();
        for (int i = 1; i <=30 ; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }

    }



}
