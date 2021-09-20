package com.codel.mybatis_plus.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Test3 {
    private Logger logger = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {

        HashMap<Object, Object> map = new HashMap<>();
        map.put("key", "hello");
        map.put("key2", "hello");
        Object key = map.get("key");

        System.out.println(key);
//        map键值对遍历
        Set<Map.Entry<Object, Object>> entries = map.entrySet();
        for (Map.Entry<Object, Object> entry : entries) {
            System.out.println(entry);
        }
//        key遍历
        Set<Object> objects = map.keySet();
        for (Object object : objects) {
            System.out.println(object);
        }
//        判断是否为空
        System.out.println(map.isEmpty());

//
        System.out.println(map.size());

        Iterator<Map.Entry<Object, Object>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            System.out.println("444"+iterator.next());

        }
    }
}
