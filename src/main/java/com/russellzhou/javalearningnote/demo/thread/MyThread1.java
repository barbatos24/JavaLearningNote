package com.russellzhou.javalearningnote.demo.thread;

/**
 * 线程创建方式①：继承Thread类
 */
//1.自定义CustomThread类，继承Thread类
public class MyThread1 extends Thread{

    public MyThread1(){

    }

    //2.重写run()
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread() + ":" + i);
        }
    }

    public static void main(String[] args){
        //3.创建CustomThread的对象
        MyThread1 myThread1 = new MyThread1();
        MyThread1 myThread2 = new MyThread1();

        //4.调用start()
        myThread1.start();
        myThread2.start();
    }
}
