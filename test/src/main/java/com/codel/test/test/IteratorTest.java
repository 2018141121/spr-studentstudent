package com.codel.test.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class IteratorTest {


    //    静态方法，没有返回值，只能创建一个这样的主线程方法
    public static void main(String[] args) {

        ArrayList<Object> list = new ArrayList<>();
        list.add("codel");
        list.add("123");
        list.add("1234");
        list.add("34123");

//        使用迭代器进行遍历输出 只能单向遍历，但是很安全，因为遍历的时候，发现元素被更改会抛出异常
        Iterator<Object> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());

        }
//================
        new IteratorTest().collection();
        new IteratorTest().listIterator();

    }

    //    这个是什么呢，这个就是在遍历数据的时候怎么进行list元素的删除
    public void collection() {
//        只能使用迭代器的方式

        ArrayList<String> list = new ArrayList<>();
        list.add("codel");
        list.add("123");
        list.add("1234");
        list.add("34123");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals("123")) {
                iterator.remove();
            }

        }
        System.out.println(list.size());
    }


    //    =========== 这个只能遍历list 但是可以前后遍历  添加了一些功能，添加一个元素，替换一个元素
    public void listIterator() {

        ArrayList<String> list = new ArrayList<>();
        list.add("codel");
        list.add("123");
        list.add("1234");
        list.add("34123");
        ListIterator<String> stringListIterator = list.listIterator();
        while (stringListIterator.hasNext()) {
            stringListIterator.add("24353453456");
            stringListIterator.next();
        }
    }
}
