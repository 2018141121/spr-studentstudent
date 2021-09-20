package com.codel.test.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ListTest {
    public static void main(String[] args) {
//       确保一个不能修改的集合
        ArrayList<Object> objects = new ArrayList<>();
        objects.add("codel");
//        这里创建了一个不能修改的集合，保证只能进行读的操作
        Collection<Object> objects1 = Collections.unmodifiableCollection(objects);
        try {
            objects1.add("hello");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(objects.size());
    }
}
