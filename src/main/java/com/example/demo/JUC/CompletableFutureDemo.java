package com.example.demo.JUC;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author Administrator
 * @create 2020-07-21 21:35
 */
public class CompletableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //同步
        CompletableFuture<Void> completableFuture =CompletableFuture.runAsync(()->{
            System.out.println(Thread.currentThread().getName()+"\tCompletableFuture.runAsync");
        });
        completableFuture.get();

        //异步
        CompletableFuture<Integer> completableFuture1 = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName()+"\tCompletableFuture.supplyAsync");
            return 1024;
        });
        completableFuture1.whenComplete((t,u)->{
            System.out.println("---t="+t);
            System.out.println("---u="+u);

        }).get();

    }
}
