package com.weylau.javamyblogapi.test.thread;

import lombok.SneakyThrows;

/**
 * 创建多线程
 */
public class ThreadTest extends Thread{
    @SneakyThrows
    @Override
    //执行的操作
    public void run() {
        sleep(1000);
        for (int i = 0; i< 100;i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }


}

class TestMain {
    public static void main(String args[]) {
        ThreadTest threadTest = new ThreadTest();
        //start两个作用 1.启动线程 2.调用run
        threadTest.start();
        //threadTest.run();不会创建新线程，同步操作
        ThreadTest threadTest2 = new ThreadTest();
        //start两个作用 1.启动线程 2.调用run
        threadTest2.start();

        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i< 100;i++) {
                    System.out.println(Thread.currentThread().getName()+":"+i);
                }
            }
        }.start();
        //主线程中执行
        for (int i = 0; i< 100;i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}
