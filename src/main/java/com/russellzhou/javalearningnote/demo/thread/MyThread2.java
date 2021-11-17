package com.russellzhou.javalearningnote.demo.thread;

/**
 * 线程创建方式②：实现Runnable接口
 */
//1.创建一个自定义类ThreadTarget
public class MyThread2 implements Runnable{

    public static int count=20;

    //2.实现Runnable接口的Run方法
    @Override
    public void run() {
        while(count>0){
            try{
                Thread.sleep(200);
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"-remain thread size:"+count--);
        }
    }

    public static void main(String[] args){
        MyThread2 myThread = new MyThread2();

        //3.将ThreadTarget类的实例对象作为Thread的构造器入参target，实际的线程对象还是Thread实例
        Thread thread1 = new Thread(myThread,"Thread1");
        Thread thread2 = new Thread(myThread,"Thread2");

        thread1.start();
        thread2.start();
    }
}
