package com.lytest.exer;

/**
 * @author ly
 * @Date:2022/09/25/14:35
 * @Description:线程通信的应用：经典例题：生产者/消费者问题
 * 生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处
 * 取走产品，店员一次只能持有固定数量的产品(比如:20），如果生产者试图
 * 生产更多的产品，店员会叫生产者停一下，如果店中有空位放产品了再通
 * 知生产者继续生产；如果店中没有产品了，店员会告诉消费者等一下，如
 * 果店中有产品了再通知消费者来取走产品。
 *
 * 分析：
 * 1、是否有多线程？    是 生产者线程，消费者线程
 * 2、是否有数据共享？ 是  店员（产品）
 * 3、如何解决线程安全问题？    同步机制
 */
class Clerk{
    private int productCoun;
    //生产产品
    public synchronized void produceProduct(){
        if(productCoun < 20){
            productCoun++;
            notify();
            System.out.println(Thread.currentThread().getName() + ":生产了第" + productCoun + "个产品");
        }else{
            //等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized void consumeProduct(){
        if(productCoun > 0){
            System.out.println(Thread.currentThread().getName() + ":消费者开始消费第" + productCoun + "个产品");
            productCoun--;
            notify();
        }else{
            //等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
class Producer extends Thread{  //生产者
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + ":开始生产产品");
        while (true){
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produceProduct();
        }

    }
}


class Customers extends Thread{ //消费者者
    private Clerk clerk;

    public Customers(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + ":开始消费产品");
        while (true){
            try {
                sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumeProduct();
        }
    }
}



public class ProductTest {
    public static void main(String[] args) {
        Clerk c = new Clerk();
        Producer p1 = new Producer(c);
        p1.setName("生产者1");
        Customers c1 = new Customers(c);
        Customers c2 = new Customers(c);
        c1.setName("消费者1");
        c2.setName("消费者2");
        p1.start();
        c1.start();
        c2.start();
    }
}
