package com.lytest.java;

/**
 * 多线程的创建，方式一：继承于Thread类
 * 1、创建一个继承于Thread类的子类
 * 2、重写Thread类的run()
 * 3、创建Thread类的子类的对象
 * 4、通过此对象调用start()
 * 例：遍历100以内的所有的偶数
 * @author dell
 */


//1、创建一个继承于Thread类的子类
public class MyThread1 extends Thread{
    //2、重写Thread类的run()


    @Override
    public void run() {
        for (int i = 0; i < 100 ; i++){
            if (i % 2 == 0){
                System.out.println(i);
            }
        }
    }
}