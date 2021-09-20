package com.codel.test.test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapTest implements Runnable {
    private Integer id;

    public HashMapTest(Integer id) {
        this.id = id;
    }

    public static void main(String[] args) {
//        new HashMapTest().testHashMap();
//        new HashMapTest().testHashTable();
//        new HashMapTest().testTreeMap();
//        new HashMapTest().concurrentHashMap();
        new Thread(new HashMapTest(1)).start();
        new Thread(new HashMapTest(2)).start();
        new Thread(new HashMapTest(3)).start();

    }

    public void testHashMap() {
//        hashmap的数据结构是数组加链表，但是节点数据到了8个之后，就会转化为红黑树来提高查询的效率
        HashMap<Object, Object> map = new HashMap<>();
        map.put("codel", "hello");
//        key的值冲突了，就会根据key的hashcode值进行比较，如果冲突了就会进行更新
        map.put("codel1", "hello");
        map.put("codel1", "hellos");

        System.out.println(map.get("codel1"));
    }

    public void testHashTable() {
        //hashtable每一个方法里面都添加了一个synchronized同步锁，所以效率很低，基本不用了，
        Hashtable<Object, Object> objectObjectHashtable = new Hashtable<>();
        objectObjectHashtable.put("1", 1);
        objectObjectHashtable.put("2", 12);
        objectObjectHashtable.put("3", 13);
        objectObjectHashtable.put("4", 14);
        System.out.println(objectObjectHashtable);
        System.out.println(objectObjectHashtable);
    }

    public void testTreeMap() {
//        这个treemap主要是有序遍历很快，因为是红黑树的方式进行遍历
        TreeMap<Object, Object> objectObjectTreeMap = new TreeMap<>();
        objectObjectTreeMap.put(1, 2);
        objectObjectTreeMap.put(12, 2);
        objectObjectTreeMap.put(14, 2);
        objectObjectTreeMap.put(13, 2);
        objectObjectTreeMap.put(15, 2);
        System.out.println(objectObjectTreeMap);
    }

    /**
     * 并发散列映射  也就是这个map是加到了lock锁了
     */
    public void concurrentHashMap() {
        //就是在方法中添加了lock锁，然后不允许键值对有null值
//        因为添加了锁，所以是线程安全的 和hashtable的区别就是两个的添加说锁的方式是不同的
//        hashtable是使用synchronized同步锁，而concurrentHashMap的使用的是lock锁
//        底层的数据结构页不一样的，主要区别就是一个使用了红黑树，一个没有使用红黑树
        ConcurrentHashMap<Object, Object> objectObjectConcurrentHashMap = new ConcurrentHashMap<>();
        objectObjectConcurrentHashMap.put(1, 2);
        objectObjectConcurrentHashMap.put(2, 2);
        objectObjectConcurrentHashMap.put(21, 2);
        objectObjectConcurrentHashMap.put(22, 2);
        objectObjectConcurrentHashMap.put(23, 3);
        objectObjectConcurrentHashMap.put(24, 2);
        System.out.println(objectObjectConcurrentHashMap);
    }


    @Override
    public void run() {
        ConcurrentHashMap<Object, Object> objectObjectConcurrentHashMap = new ConcurrentHashMap<>();
        objectObjectConcurrentHashMap.put(1, 2);
        objectObjectConcurrentHashMap.put(2, 2);
        objectObjectConcurrentHashMap.put(21, 2);
        objectObjectConcurrentHashMap.put(22, 2);
        objectObjectConcurrentHashMap.put(23, 3);
        objectObjectConcurrentHashMap.put(24, 2);
        System.out.println(id + ":");
        System.out.println(objectObjectConcurrentHashMap.get(21));
    }
}
