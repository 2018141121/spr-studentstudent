package com.codel.test.test;

import java.util.*;

public class LinkedListTest implements Runnable {
    private String name;

    public static void main(String[] args) {
//        new LinkedListTest("3").test_();
//        new LinkedListTest("1").test_1();
//        new LinkedListTest("2").test_2();
//        new LinkedListTest("3").test_3();
        new Thread(new LinkedListTest("a")).start();
        new Thread(new LinkedListTest("b")).start();

    }

    public LinkedListTest(String name) {
        this.name = name;
    }

    public void test_() {
//        arraylist是基于动态数组的数据结构实现的，
        ArrayList<Object> list = new ArrayList<>();
        list.add(234);
        list.add(234);
        list.add(234);

        for (Object o : list) {
            System.out.println(o);

        }
    }

    public void test_1() {
//        linkedList是基于双向链表的数据结构实现的  这个跟占用内存，
//        因为它占用了数据存储位置，还占用了两个引用的存储地址，前指针和后指针
        LinkedList<Object> linkedList = new LinkedList<>();
        System.out.println("linkedList");
        linkedList.add(234);
        linkedList.add(234);
        linkedList.add(234);
        linkedList.add(234);
//        指定位置添加 但是arrayList就不行 相当于是一个指针来到，指定位置插入
        linkedList.add(3, 43534);
        for (Object o : linkedList) {
            System.out.println(name + o + "dfdfdd");

        }

    }

    public void test_2() {
        Vector<Object> list = new Vector<>();
        list.add(3124);
        list.add(3124);
        list.add(3124);
        list.add(3124);
        System.out.println(list.size());

    }

    public void test_3() {

    }

    @Override
    public void run() {
        ArrayList<Object> list = new ArrayList<>();
        List<Object> synchronizedList = Collections.synchronizedList(list);
        synchronizedList.add(123);
        synchronizedList.add(234);
        synchronizedList.add(4324);
        synchronizedList.add(1242343);

        for (int i = 0; i < synchronizedList.size(); i++) {
            System.out.println(name + ":" + synchronizedList.get(i));
        }


    }
}
