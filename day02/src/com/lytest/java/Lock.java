package com.lytest.java;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ly
 * @Date:2022/09/25/10:01
 * @Description:解决线程安全问题方式三：lock锁  jdk5.0新增
 * 面试题：synchronized 与 lock的异同
 * 相同：二者都可以解决线程同步问题
 * 不同：synchronized机制在执行完相应的同步代码以后，自动的释放同步监视器
 *      lock需要手动的自动同步（lock()），和手动的释放（unlock()）。
 *      三种同步方式优先使用lock ---->同步代码块 ---->同步方法
 *
 */
public class Lock implements Runnable{
    private int tickit = 100;
    //实例化ReentrantLock
    ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true){

           try {
               //调用锁定方法
               lock.lock();
               try {
                   Thread.sleep(100);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               if(tickit > 0){
                   System.out.println(Thread.currentThread().getName() + "买票，票号：" + tickit);
               }
           }finally {
               //调用解锁方法
               lock.unlock();
           }
        }
    }
}
