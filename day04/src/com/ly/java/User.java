package com.ly.java;

/**
 * @author ly
 * @Date:2022/10/23/19:18
 * @Description:
 */
public class User implements Comparable{
    private String name;
    private double price;

    public User() {
    }

    public User(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof User){
            User user = (User)o;
            if(this.price > user.price){
                return 1;
            }else if (this.price < user.price){
                return -1;
            }else{
                return 0;
            }

        }
        throw new RuntimeException("类型不匹配");
    }
}
