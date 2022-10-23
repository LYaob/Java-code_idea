package com.lytest.java;

/**
 * @author ly
 * @Date:2022/09/22/16:23
 * @Description:练习：创建三个窗口买票，总票数为100张,使用shixRunnable接口方式
 */
public class Window2 implements Runnable{
    private int ticket = 100;

    @Override
    public void run() {
        while (true){
            if (ticket >0){
                System.out.println(Thread.currentThread().getName() + "买票，票号：" + ticket);
                ticket--;
            }else{
                break;
            }
        }
    }
}
