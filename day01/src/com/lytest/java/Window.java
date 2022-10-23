package com.lytest.java;

/**
 * @author ly
 * @Date:2022/09/22/15:43
 * @Description:练习：创建三个窗口买票，总票数为100张,使用继承Thread方式
 */
public class Window extends Thread{
    private static int ticket = 100;
    @Override
    public void run() {
        while (true){
            if(ticket > 0){
                System.out.println(getName() + "买票，票号为："+ ticket);
                ticket--;
            }else{
                break;
            }
        }

    }
}
