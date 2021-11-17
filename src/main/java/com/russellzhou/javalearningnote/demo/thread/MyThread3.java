package com.russellzhou.javalearningnote.demo.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//1.创建一个自定义类CallableTarget用来实现Callable接口
public class MyThread3 implements Callable<String> {

    private int count = 20;

    //2.实现带有返回值的call()方法
    @Override
    public String call() throws Exception {
        for (int i = count; i > 0; i--) {
            System.out.println(Thread.currentThread().getName()+"-current ticket quantity:" + i);
        }
        return "sale out";
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable<String> callable  =new MyThread3();

        //3.根据CallableTarget创建FutureTask
        FutureTask<String> futureTask=new FutureTask<>(callable);

        //4.根据FutureTask来创建一个线程Thread
        Thread mThread=new Thread(futureTask);
        Thread mThread2=new Thread(futureTask);

        //5.调用Thread的start()
        mThread.start();
        mThread2.start();
        System.out.println(futureTask.get());

    }

}
