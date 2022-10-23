package com.lytest.java;

/**
 * @author ly
 * @Date:2022/10/11/10:58
 * @Description:模拟一个trim方法，去除字符串两端的空格
 */
 class MyUtil{
    public String getTrimString(String str){
        String newstr = str.trim();
        return newstr;
    }

    /**
     *
     * @param str
     * 将一个字符串进行反转。将字符串中指定部分进行反转。
     */
//    方法一；
    public String reverseString(String str,int startIndex,int endIndex){
        if(str != null){
            //将String数组转化成char[],使用toCharArray
            char[] arr = str.toCharArray();
            //遍历arr
            for(int x = startIndex,j = endIndex; x < j; x++,j--){
                char temp = arr[x];
                arr[x] = arr[j];
                arr[j] = temp;
            }
            //返回一个字符串，将原来的char[]转换成String，使用String的构造器
            return new String(arr);
        }
        return null;
    }
//    方法二
    public String reverse(String str,int startIndex,int endIndex){
        if(str != null){
            //第一步，将不变的字符串截取出来，使用substring()
            String reverseStr = str.substring(0,startIndex);
            //第二步，遍历剩下的字符串，从需要反转的结尾从后往前遍历，放入reverseStr,使用charAt()
            for (int i = endIndex;i >= startIndex;i--){
                reverseStr += str.charAt(i);
            }
            //第三步，将剩余没有变化的字符串尾添加
            reverseStr += str.substring(endIndex+1);
            return reverseStr;
        }
        return null;

    }
    //        方式三，在方式二的基础上改造
    public String reverse2(String str,int startIndex,int endIndex){
        if(str != null){
            StringBuilder builder = new StringBuilder(str.length());
            //使用append()进行拼接操作
            builder.append(str.substring(0,startIndex));
            //遍历
            for (int i = endIndex;i >= startIndex;i--){
                builder.append(str.charAt(i));
            }
            //将剩余的部分进行拼接
            builder.append(str.substring(endIndex+1));
            //返回一个字符串，需要将builder转化
            return builder.toString();
        }
        return null;
    }

    /**
     * 获取一个字符串在另一个字符串中出现的次数
     * 比如：获取“ab"在”abcksdsdsabsksdjab"中出现的次数。
     */
    public int getStringIndex(String str1,String str2){
        int str1Length = str1.length();
        int str2Length = str2.length();
        int count = 0;
        int index = 0;
       if(str1Length >= str2Length){
           while ((index = str1.indexOf(str2,index)) != -1){
               count++;
               index +=1;
           }
           return count;
       }
       return 0;

    }
    /**
     * 获取两个字符串中最大相同子串。比如：
     * str1 = "abcwerthelloyuiodef" str2="cvhellobnm"
     * 将短的那个串进行长度一次递减的子串与较长的串比较
     */
    public String getMaxSameString(String str1,String str2){
        if(str1 != null && str2 != null){
            String maxStr = (str1.length() >= str2.length()) ? str1 : str2;
            String minStr = (str1.length() < str2.length()) ? str1 : str2;
            int length = minStr.length();
            for(int i = 0;i < length;i++){
                for(int x = 0,y = length-i;y < length;x++,y++){
                    String subStr = minStr.substring(x,y);
                    if(maxStr.contains(subStr)){
                        return subStr;
                    }
                }
            }
        }
        return null;
    }

}



public class StringDemo {
    public static void main(String[] args) {
        //trim方法测试
        MyUtil str = new MyUtil();
        String trimString = str.getTrimString("          --string             --        ");
        String str2 = "      --abc--   ";
        System.out.println(str2);
        System.out.println(trimString);


        //reverse方法测试
        MyUtil str3 = new MyUtil();
//        String str4 = str3.reverseString("abcdefg", 2, 5);
        String str4 = str3.reverse("abcdefg",2,5);
        System.out.println(str4);

        //getStringIndex方法测试
       MyUtil str5 = new MyUtil();
        int str6 = str5.getStringIndex("abkkcadkabkebfkaabkskab", "ab");
        System.out.println(str6);
        //get
    }
}
