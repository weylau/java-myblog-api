package com.weylau.javamyblogapi.test.thread.method;

class Test {
    public static void main(String args[]) {
        Clerk clerk = new Clerk();
        Producer producer = new Producer(clerk);
        Consumer consumer = new Consumer(clerk);
        Thread t1 = new Thread(producer);
        t1.setName("生产者");
        Thread t2 = new Thread(consumer);
        t2.setName("消费者1");
//        Thread t3 = new Thread(consumer);
//        t3.setName("消费者2");

        t1.start();
        t2.start();
//        t3.start();
    }
}

class Clerk {
    static Integer goodsNum = 0;

    public synchronized void productGoods() {
        if(Clerk.goodsNum < 20) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            goodsNum++;
            System.out.println(Thread.currentThread().getName()+":生产了第"+goodsNum+"个产品");
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    public  synchronized void consumerGoods() {
        if(Clerk.goodsNum > 0) {
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":消费了第"+goodsNum+"个产品");
            goodsNum--;
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class Producer implements Runnable {
    Clerk clerk;
    Producer(Clerk clerkObj) {
        clerk = clerkObj;
    }

    @Override
    //执行的操作
    public void run() {
        while(true) {
            clerk.productGoods();
        }

    }
}
class Consumer implements Runnable {
    Clerk clerk;
    Consumer(Clerk clerkObj) {
        clerk = clerkObj;
    }

    @Override
    //执行的操作
    public void run() {
        while(true) {
            clerk.consumerGoods();
        }

    }
}

