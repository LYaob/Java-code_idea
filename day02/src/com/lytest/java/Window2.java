package com.lytest.java;

/**
 * @author ly
 * @Date:2022/09/22/16:23
 * @Description:练习：创建三个窗口买票，总票数为100张,使用shixRunnable接口方式
 */
public class Window2 implements Runnable{
    private int ticket = 100;
    Object obj = new Object();

    @Override
    public void run() {
        while (true){
            synchronized (obj){
                if (ticket > 0) {

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "买票，票号：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}
