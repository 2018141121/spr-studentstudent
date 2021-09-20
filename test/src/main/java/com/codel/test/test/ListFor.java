package com.codel.test.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 列表
 * 容器遍历的方式
 *
 * @author codel
 * @date 2021/10/27
 */
public class ListFor {

    public List<Object> listcreat() {
//        arraylist是底层是基于数组开发的，所以是一种随机访问的模式，查找很快，添加一个数组在末尾页很快
//        但是删除和插入数据的时候就会很慢，因为要进行一次数组的复制，所以就会很消耗性能
        ArrayList<Object> list = new ArrayList<>();

        list.add("234");
        list.add("234");
        list.add("234");
        list.add("234");
        list.add("234");
        return list;
    }

    /**
     * 主要
     *
     * @param args arg游戏
     */
    public static void main(String[] args) {
        new ListFor().testFor();
        new ListFor().testIter();
        new ListFor().testForEach();

    }

    /**
     * 测试for
     */
    public void testFor() {
        List<Object> listcreat = listcreat();
        long l1 = System.currentTimeMillis();
        System.out.println(l1);
        for (int i = 0; i < listcreat.size(); i++) {
            System.out.println(listcreat.get(i));
        }

        long l = System.currentTimeMillis();
        System.out.println(l - l1);
        System.out.println("这是for循环遍历");
    }

    /**
     * 测试iter
     */
    public void testIter() {
        List<Object> listcreat = listcreat();
        Iterator<Object> iterator = listcreat.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("这是迭代器循环遍历");
    }

    /**
     * 测试forEach
     */
    public void testForEach() {
        List<Object> listcreat = listcreat();
        for (Object o : listcreat) {
            System.out.println(o);
        }
        System.out.println("这是foreach循环遍历");
    }

}
