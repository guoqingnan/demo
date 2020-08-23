package com.example.demo.JUC;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @create 2020-07-20 11:49
 */

//实现runable接口
class MyThread implements Runnable{

    @Override
    public void run() {

    }
}

//实现callable接口
class MyThread2 implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"----Callable----");
        TimeUnit.SECONDS.sleep(4);
        return 200;
    }
};



public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //通过创建FutureTask实现类，因为Thread类的构造方法没有Callable，只有Runable，所以需要FutrueTask（是Runable的实现类）来做中间人，
        // 把Callable接口的实现类作为参数传递，
        //
        FutureTask<Integer> ft = new FutureTask(new MyThread2());

        FutureTask<Integer> ft1 = new FutureTask<>(()->{
            System.out.println(Thread.currentThread().getName()+"----Callable----");
            TimeUnit.SECONDS.sleep(4);
            return 1024;
        });

        new Thread(ft,"zhang3").start();

        new Thread(ft1,"lisi4").start();

        System.out.println(Thread.currentThread().getName());
        System.out.println(ft.get());

        System.out.println(ft1.get());
    }

}
