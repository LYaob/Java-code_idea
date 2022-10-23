package com.lytest.java;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author ly
 * @Date:2022/09/25/15:55
 * @Description:创建多线程的方式三：实现Callable接口  --->jdk5.0新增
 * 1、创建一个实现Callable的实现类
 * 2、重写call方法，将此线程需要执行的操作声明在call中
 * 3、创建Callable接口实现类的对象
 * 4、将Callable接口实现类的对象作为参数传递到FutureTask构造器中，创造FutureTask的对象
 * 5、将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象并调用start方法
 * 6、如果需要获取Callable中call方法的返回值，则可写以下内容
 */

//1、创建一个实现Callable的实现类
class NumThread implements Callable{
    //2、重写call方法，将此线程需要执行的操作声明在call中
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 1; i <=100; i++){
            if (i % 2 == 0 ){
                System.out.println(i);
                sum +=i;
            }
        }
        return sum;
    }
}



public class NewThreadTest {
    public static void main(String[] args) {
        //3、创建Callable接口实现类的对象
        NumThread numThread = new NumThread();
        //4、将Callable接口实现类的对象作为参数传递到FutureTask构造器中，创造FutureTask的对象
        FutureTask futureTask = new FutureTask(numThread);
        //5、将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象并调用start方法
        new Thread(futureTask).start();

        //6、如果需要获取Callable中call方法的返回值，则可写以下内容
        //get()返回值即为FutureTask构造器参数Callable实现类重写的call()的返回值。
        Object sum = null;
        try {
            sum = futureTask.get();
            System.out.println("总和为：" +sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}
