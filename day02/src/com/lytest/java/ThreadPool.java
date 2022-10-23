package com.lytest.java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author ly
 * @Date:2022/08/01/8:40
 * @Description:线程的创建方式四：使用线程池
 * 1、提供指定线程数量的线程池
 * 2、执行指定的线程的操作，需要提供实现Runnable接口或Callable接口实现类的对象。
 * 3、关闭线程池
 */
class Number1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <= 100;i++){
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}


public class ThreadPool {
    public static void main(String[] args) {
//        1、提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        //强制类型转换，方便管理线程池
        ThreadPoolExecutor s1 = (ThreadPoolExecutor) service;
        //设置线程池的属性
//        s1.setCorePoolSize(10);

//        2、执行指定的线程的操作，需要提供实现Runnable接口或Callable接口实现类的对象。
        s1.execute(new Number1());//适用于Runnable接口
//        s1.submit(new Number1());//适用于Callable接口

        //3、关闭连接池
        s1.shutdown();
    }
}
