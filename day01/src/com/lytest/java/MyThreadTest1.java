package com.lytest.java;

/**
 * 测试MyThread类
 * @author dell
 */
public class MyThreadTest1 {
    public static void main(String[] args) {
        //3、创建Thread类的子类的对象
        MyThread1 t = new MyThread1();
        //4、通过此对象调用start()，作用：① 启动当前线程，② 调用当前线程的run()方法
        //想要创建多个线程，需要创建多个对象去调用start()方法来启动线程，一个对象只能调用一次start()
        t.start();
        //t.run(),不能通过直接调用run()的方式启动线程

        for (int i = 0; i < 100;i++){
            if (i % 2 == 0){
                System.out.println(i + "****************************");
            }
        }

    }
}