package com.example.demo.JUC;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Administrator
 * @create 2020-07-18 15:35
 */

class ShareOne{
    //定义一个变量1 2 对应两个线程
    private int number = 1;
    //可重入锁对象
    private Lock lock = new ReentrantLock();
    //condition对象
    private Condition cd = lock.newCondition();

    private Condition cd1 = lock.newCondition();


    public void increNumber(int num){
        //上锁
        lock.lock();
        try {
            //判断
            while (number!=1){
                cd.await();
            }
            //干活
            System.out.print(num-1);
            System.out.print(num);
            //唤醒线程2
            number=2;
            cd1.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //解锁
            lock.unlock();
        }
    }
    public void incre(int num){
        lock.lock();
        try {
            //判断
            while (number!=2){
                cd1.await();
            }
            //干活
            System.out.print((char)num);
            System.out.println();
            //唤醒线程1
            number=1;
            cd.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

/**
 * 现在两个线程
 * 两个线程，一个线程打印1-52，另一个打印字母A-Z打印顺序为12A34B...5152Z,
 * 要求用线程间通信
 *
 * 1、线程 操作 资源类
 * 2、高内聚低耦合
 *
 * 1、判断
 * 2、干活
 * 3、通知
 *
 *
 */
public class TestDemo {

    public static void main(String[] args) {
        //创建资源类
        ShareOne shareOne = new ShareOne();
        //创建线程1
        new Thread(()->{
            for (int i = 2; i <=52 ; i+=2) {
                shareOne.increNumber(i);
            }
        },"AA").start();
        //执行线程2
        new Thread(()->{
            for (int i = 65; i <=96 ; i++) {
                shareOne.incre(i);
            }
        },"BB").start();
    }
}


