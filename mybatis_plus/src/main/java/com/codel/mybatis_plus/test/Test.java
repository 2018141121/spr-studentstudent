package com.codel.mybatis_plus.test;

import java.util.Scanner;

public class Test implements Runnable {

   static final Integer int2 =34;
    int d  =23;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        new Thread(new Test(next)).start();
        new Thread(new Test("codeL2")).start();
    }

    private  String name;

    public Test(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + "运行" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
