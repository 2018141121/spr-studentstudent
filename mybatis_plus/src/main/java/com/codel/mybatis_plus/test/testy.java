package com.codel.mybatis_plus.test;

import java.util.Arrays;

public class testy {
    public static void main(String[] args) {
        int[] intss = {234, 3, 3, 5,5,3,4,4,6,6};
       testLookup(intss);
//        System.out.println(Arrays.stream(intss).iterator());
//        int[] ints = new testy().SortTest(intss);
//        for (int anInt : ints) {
//            System.out.println(anInt);
//        }


    }


    public static void testLookup(int[] ints) {
        int max = 0;
        for (int anInt : ints) {
            if (anInt > max) {
                max = anInt;
            }

        }

        int max2 = ints[0];
        for (int i = 1; i < ints.length; i++) {
            if (ints[i] > max2) {
                max2 = ints[i];

            }

        }
        System.out.println(max2);
        System.out.println(max);
    }

    public int testMax(int i) {
        System.out.println("shuchu ");
        return i;
    }


    //    选择排序
//    先判断比较的轮数，每一轮要比较的次数，每一轮比较过后都会产生一个排序好的值
    public int[] SortTest(int[] sourceArray) {
//        复制一份数组
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        // 总共要经过 N-1 轮比较
        for (int i = 0; i < arr.length - 1; i++) {
//            假设i为最大或 最小值
            int min = i;

            // 每轮需要比较的次数 N-i
            for (int j = i + 1; j < arr.length; j++) {
//                判断是否为小于前者
                if (arr[j] < arr[min]) {
                    // 记录目前能找到的最小值元素的下标
                    min = j;
                }
            }

            // 将找到的最小值和i位置所在的值进行交换
            if (i != min) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }
        return arr;
    }


}
