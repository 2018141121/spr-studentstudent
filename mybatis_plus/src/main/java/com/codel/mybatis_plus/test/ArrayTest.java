package com.codel.mybatis_plus.test;

/**
 * 查找重复元素
 *
 * @author codel
 * @date 2021/10/14
 */
public class ArrayTest {
    /**
     * 主要入口
     *
     * @param args arg游戏
     */
    public static void main(String[] args) {
        int[] arr1 = {45, 345324, 3, 3, 4, 4, 45};
//        new ArrayTest().testArray(arr1);
        new ArrayTest().test_01_(arr1);
    }

    /**
     * 方法
     *
     * @param a 一个
     */
    public void testArray(int[] a) {

        boolean flag = false;
//        先把数组遍历出来  也就是要比较的轮数
        for (int j = 0; j < a.length; j++) {
//            比较的次数
            for (int k = j + 1; k < a.length; k++) {
//                进行比较
                if (a[j] == a[k]) {
                    flag = true;
                }
            }
            if (flag)
                System.out.println("重复元素 : " + a[j]);
            flag = false;
        }
    }

    public void test_01_(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int i1 = i + 1; i1 < a.length; i1++) {
                if (a[i] == a[i1]) {
                    System.out.println(a[i]);
                }

            }

        }
    }
}
