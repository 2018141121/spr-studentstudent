package com.codel.mybatis_plus.test;

import java.util.Random;

public class test02 {
    public static void main(String[] args) {

        String test1 = "10";
        String test2 = "10";
        Integer test3 = 34;

        String concat = test1.concat(test2);
        System.out.println(concat);
        System.out.println(test1 == String.valueOf(test3));
        String s = new String("10");
        String s2 = new String("10");
        StringBuffer stringBuffer = new StringBuffer("11");
        StringBuffer stringBuffer2 = new StringBuffer("11");
//        比较地址
        System.out.println(test1 == s);
//        比较值
        System.out.println(test1.equals(test2));

        System.out.println(s2.equals(test1));
//        从上面可以看到equals就是值的比较，但是这里为什么不行呢，
//        答案就是因为string这个类里面对equals进行了重写，实现了值的比较
        System.out.println(stringBuffer.equals(stringBuffer2));

        double random1 = Math.random() * 10;

        Random random = new Random();
        int i = random.nextInt();
        System.out.println(i * 10);
    }
}
