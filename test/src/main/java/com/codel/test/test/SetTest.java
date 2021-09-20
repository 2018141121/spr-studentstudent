package com.codel.test.test;

import java.util.HashSet;

public class SetTest {
    public static void main(String[] args) {

        new SetTest().testSet();
    }

    public void testSet() {
//        不允许重复  不能通过for i的方进行遍历  插入删除的效率很高
//        底层是hashmap 可以点进去源码看一下  怎么进行查重呢，首先要对hashcode进行比较，然后equals进行比较

        /*          public HashSet() {
//        底层就是hashmap
        map = new HashMap<>();
    }*/
        HashSet<Object> hashSet = new HashSet<>();
        hashSet.add(234);
        hashSet.add(5345);
        hashSet.add(345);
        hashSet.add(543);
        System.out.println(hashSet.size());
        for (Object o : hashSet) {
            System.out.println(o);
        }


    }


}
