package com.lytest.exer;

//package com.lytest.exer;

/**
 * @author ly
 * @Date:2022/09/25/10:16
 * @Description:练习：银行有一个账户，有两个客户分别向同一个账户存3000元，每次存1000元，存三次，每次打印银行账户余额
 * 分析：
 * 1、是否是多线程问题？  是 两个客户
 * 2、是否有共享数据？   有 账户
 * 3、是否有线程安全问题？ 有
 * 4、如何解决线程安全问题？    同步机制（三种）
 */
//错误的写法
//class Account{
//
//    private double balance=0;
//
//    //存钱
//    public void deposit(int amt){
//        //判断
//        if (amt > 0){
//            balance += amt;
//            System.out.println(Thread.currentThread().getName() + "存钱成功，账户余额为："+ balance);
//        }
//
//    }
//}
//class Customer implements Runnable{
//    private Account account;
//
//    @Override
//    public void run() {
//        //取钱
//        for (int i = 0; i < 3 ;i++){
//            account.deposit(1000);
//        }
//    }
//
//}
//public class AccountTest{
//    public static void main(String[] args) {
//
//      Customer c = new Customer();
//      Thread t1 = new Thread(c);
//      Thread t2 = new Thread(c);
//
//        t1.setName("甲");
//        t2.setName("乙");
//
//        t1.start();
//        t2.start();
//    }
//}
class Customer implements Runnable{
    private double account = 0;
    private double balance;
    //存钱
    public synchronized void deposit(int amt){
        if(amt > 0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance += amt;
            System.out.println(Thread.currentThread().getName() + "存钱成功！账户余额为：" + balance);
        }
    }

    @Override
    public void run() {
        for (int i = 0;i < 3;i++){
            this.deposit(1000);
        }

    }
}
public class AccountTest {
    public static void main(String[] args) {
        Customer c = new Customer();
        Thread t1 = new Thread(c);
        Thread t2 = new Thread(c);
        t1.setName("甲");
        t2.setName("乙");
        t1.start();
        t2.start();


    }
}