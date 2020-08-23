package com.example.demo.JUC;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Administrator
 * @create 2020-07-20 15:50
 */
//读写锁，读写分离，读就用共享锁，写就用独占锁
class MyCache{

    private  Map<String,Object> map = new HashMap<>();

    private ReadWriteLock rwLock = new ReentrantReadWriteLock();

    public void put(String key,Object value){
        rwLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t开始写"+key);
            Thread.sleep(300);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"\t写完了"+key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwLock.writeLock().unlock();
        }
    }
    public void get(String key){
        rwLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t开始读"+key);
            Thread.sleep(300);
            map.get(key);
            System.out.println(Thread.currentThread().getName()+"\t读完了"+key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwLock.readLock().unlock();
        }
    }

}


public class ReadWriteLockDemo {
    public static void main(String[] args) throws InterruptedException {
        //创建资源类对象
        MyCache myCache = new MyCache();
        //创建多线程
        for (int i = 1; i <=5 ; i++) {
            int num = i;
            new Thread(()->{
                myCache.put(String.valueOf(num+1),String.valueOf(num));
            },String.valueOf(i)).start();
        }
        TimeUnit.SECONDS.sleep(3);
        //创建get方法的多线程
        for (int i = 1; i <=5 ; i++) {
            int num = i;
            new Thread(()->{
                myCache.get(String.valueOf(num));
            },String.valueOf(i)).start();
        }
    }

}
