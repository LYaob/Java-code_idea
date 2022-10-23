package com.lytest.java;

/**
 * @author ly
 * @Date:2022/09/25/13:13
 * @Description:线程通信的例子：使用两个线程交替打印 1-100，
 * 涉及的三个方法：
 * wait() :一旦执行此方法，当前线程进入阻塞状态，并释放同步监视器
 * notify() : 一旦执行此方法，会唤醒被wait()阻塞的线程，如果有多个线程阻塞，则唤醒优先级高的线程
 * notifyAll() :一旦执行此方法，会唤醒所有被wait()阻塞的线程
 *
 * 注：wait()、notify()、notifyAll()这三个方法必须使用在同步代码块或同步方法中，这三个方法的调用者必须是
 * 同步代码块或同步方法的同步监视器，否则，会出现IllegalMonitorStateException异常
 */

class Number implements  Runnable{
    private int number = 1;
    @Override
    public void run() {
        while (true){
            synchronized (this){
                notify();
                if (number <= 100){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":"+number);
                    number++;

                    try {
                        //使用wait()方法让线程进入阻塞状态
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    break;
                }

            }
        }

    }
}


public class CommunicationTest {
    public static void main(String[] args) {
        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);
        t1.setName("线程1");
        t2.setName("线程2");
        t1.start();
        t2.start();

    }
}
