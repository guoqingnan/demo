package com.example.demo.JUC;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class  Ticket{
    private  int number = 30;
    private Lock lock = new ReentrantLock();

    public  void sale(){
        lock.lock();
        try {
            if(number>0){
                System.out.println(Thread.currentThread().getName()
               +"卖出"+(number--)+"号票\t还剩"+number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


//    public synchronized void sale(){
//        int i=0;
//        synchronized (this){
//
//        }
//        if(number>0){
//            System.out.println(Thread.currentThread().getName()
//            +"卖出"+(number--)+"号票\t还剩"+number);
//        }
//
//    }


}


public class SaleTicket {


    /**
     * 卖票程序复习线程知识：三个售票员  卖出    30张票
     * 1、线程 操作 资源类
     * 2、高内聚低耦合
     *
     * @param args
     * @throws Exception
     *
     */
    public static void main(String[] args) throws Exception {

        Ticket ticket = new Ticket();
        //Thread(Runnable target, String name)

        new Thread(()->{for (int i = 1; i <=40 ; i++)ticket.sale();},"AA").start();
        new Thread(()->{for (int i = 1; i <=40 ; i++)ticket.sale();},"BB").start();
        new Thread(()->{for (int i = 1; i <=40 ; i++)ticket.sale();},"CC").start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 1; i <=40 ; i++) {
//                    ticket.sale();
//                }
//            }
//        },"AA").start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 1; i <=40 ; i++) {
//                    ticket.sale();
//                }
//            }
//        },"BB").start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 1; i <=40 ; i++) {
//                    ticket.sale();
//                }
//            }
//        },"CC").start();

    }
}


/**
 *WWH
 *
 *
 *
 *
 **/