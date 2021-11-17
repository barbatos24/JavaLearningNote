package com.russellzhou.javalearningnote.demo.threadPool;

import java.util.concurrent.*;

public class MyThreadPool {

    public static void main(String[] args){

        ExecutorService executorService = new ThreadPoolExecutor(2, 5, 0, TimeUnit.DAYS,
                new ArrayBlockingQueue<>(1), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                return thread;
            }
        });
        // 对象创建后，线程实际还没开始创建

        // 执行execute时，检查当前池中线程数大小是否小于core number, 如果是，则创建新线程
        executorService.execute(() -> {
            System.out.println("Task1@" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(1);
        });

        //检查当前池中线程数大小是否小于core number, 如果是，则创建新线程
        executorService.execute(() -> {
            System.out.println("Task2@" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(2);
        });

        // 检查当前池中线程数大小是否小于core number, 如果不是，则偿试放入队列
        // 这个任务是加到队列去的, 注意队列大小只有1，
        // TODO 队列中的任务是什么时候取出来的？   任务1或者2结束后所占用的线程 会运行队列中的任务，这个任务是在最后才运行，比4运行的还晚
        executorService.execute(() -> {
            System.out.println("Task3@" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(3);
        });

        // 检查当前池中线程数大小是否小于core number, 如果不是,则偿试放入队列,放入队列也失败，则增加新的worker线程
        // 这个任务是加到core以外的新线程去的
        executorService.execute(() -> {
            System.out.println("Task4@" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(4);
        });
    }

}
