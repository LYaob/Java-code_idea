package com.lytest.java;

/**
 * 测试MyThread1类
 * @author dell
 */
public class MyThreadTest2 {
    public static void main(String[] args) {
       //3、创建实现类的对象
        MyThread2 myThread2 = new MyThread2();
        //4、将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象。
        Thread t1 = new Thread(myThread2);
        //5、通过Thread类的对象调用start
        t1.start();
    }
}