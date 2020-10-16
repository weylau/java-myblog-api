package com.weylau.javamyblogapi.test.thread.method;

import java.util.concurrent.*;

class Test {
    public static void main(String args[]) {
        NumCallable numCallable = new NumCallable();
        NumRunable numRunable = new NumRunable();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor)executorService;
        //设置线程池参数
        threadPoolExecutor.setCorePoolSize(15);
        threadPoolExecutor.execute(numRunable);//传入Runable类
        threadPoolExecutor.submit(numCallable);//传入Callable类
        threadPoolExecutor.shutdown();
    }
}


class NumCallable implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i=0;i<100;i++) {
            if(i%2 == 0) {
                System.out.println(Thread.currentThread().getName()+": 偶数");
            }
            sum+=i;
        }
        return sum;
    }
}

class NumRunable implements Runnable{

    @Override
    public void run() {
        for (int i=0;i<100;i++) {
            if(i%2 != 0) {
                System.out.println(Thread.currentThread().getName()+": 奇数");
            }
        }
    }
}

