package com.example.demo.JUC;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @create 2020-07-20 16:35
 */
public class BlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        //第一组  抛出异常
        System.out.println(blockingQueue.add("1"));
        System.out.println(blockingQueue.add("2"));
        System.out.println(blockingQueue.add("3"));
//        //System.out.println(blockingQueue.add("X"));
        System.out.println(blockingQueue.element());   //检查第一个进入队列的值
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
//        //System.out.println(blockingQueue.remove());
        //第二组  特殊值
//        System.out.println(blockingQueue.offer("a"));
//        System.out.println(blockingQueue.offer("b"));
//        System.out.println(blockingQueue.offer("c"));
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());    //true ture ture a b c null
       //第三组  阻塞
//        blockingQueue.put("a");
//        blockingQueue.put("b");
//        blockingQueue.put("c");
//
//        System.out.println(blockingQueue.take());
//        System.out.println(blockingQueue.take());
//        System.out.println(blockingQueue.take());
        //第四组  超时
//        System.out.println(blockingQueue.offer("1"));
//        System.out.println(blockingQueue.offer("2"));
//        System.out.println(blockingQueue.offer("3"));
//        System.out.println(blockingQueue.offer("4",3, TimeUnit.SECONDS));  //超过时间报false
//
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll(3,TimeUnit.SECONDS));    //超过时间报null


    }
}
