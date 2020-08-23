package com.example.demo.JUC;

import java.util.concurrent.*;

/**
 * @author Administrator
 * @create 2020-07-21 9:41
 */


public class MyThreadPollDemo {

    public static void main(String[] args) {
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                3L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy()
        );
        try {
            for (int i = 1; i <=9 ; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"--\t办理业务--");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }

    }
}
