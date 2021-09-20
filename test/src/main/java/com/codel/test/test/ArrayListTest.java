package com.codel.test.test;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListTest {


    public static void main(String[] args) {
        new ArrayListTest().arrayList1();
//        new ArrayListTest().arrayList2();
//        new ArrayListTest().arrayList3();
//        new ArrayListTest().arrayList4();
    }

    //    转换
    public void arrayList1() {
//        arraylist只能用于存储对象，所以如果存储数据类型的要用对象，也就是包装类
        ArrayList<Object> list = new ArrayList<>();
        list.add("234");
        list.add("234");
        list.add("234");
        list.add("234");

//        list转化为array
        System.out.println(list.toArray().length);

        System.out.println(list.removeAll(list));

//        list 转化为 array
        int[] array = {123, 43, 4324354, 354};

        int[] ints = Arrays.copyOf(array, array.length);
        for (int[] ints1 : Arrays.asList(ints)) {
            for (int i : ints1) {
                System.out.println(i);

            }

        }

    }

    public void arrayList2() {

    }

    public void arrayList3() {

    }

    public void arrayList4() {

    }


}
