package com.ly.exer;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * @author ly
 * @Date:2022/10/21/20:06
 * @Description:将字符串“2020-09-08”转换为java.sql.Data
 */
public class SimpleDataFormatDemo {
    @Test
    public void test2(){
//        now()：获取当前的日期、时间、日期时间
//        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(LocalDate.now());
        System.out.println(localTime);
        System.out.println(localDateTime);
//        of()设置指定的年、月、日、时、分、秒
        Date date = new Date();
        long time = date.getTime();
        System.out.println(time);
        Instant instant =Instant.now();
        long epochMilli = instant.toEpochMilli();
        System.out.println(epochMilli);

    }


    @Test
    public void testSimpleDataFormat() throws ParseException {
//        1、实例化SimpleDateFormat
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String str1 = "2020-09-08";
        Date data1 = sdf.parse(str1);
        java.sql.Date date2 = new java.sql.Date(data1.getTime());
        System.out.println(date2);

    }
}
