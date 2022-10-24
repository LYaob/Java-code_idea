package com.ly.java;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author ly
 * @Date:2022/10/23/19:20
 * @Description:
 */
public class test {
    @Test
    public void testUser(){
        User[] arr = new User[5];
        arr[0] = new User("huawei",3000);
        arr[1] = new User("dell",3478);
        arr[2] = new User("mi",7544);
        arr[3] = new User("mac",3478);
        arr[4] = new User("hp",4564);
       Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
