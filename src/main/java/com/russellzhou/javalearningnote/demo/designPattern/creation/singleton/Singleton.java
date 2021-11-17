package com.russellzhou.javalearningnote.demo.designPattern.creation.singleton;

public class Singleton {

    /*
    持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载
    */
    private static Singleton instance = null;

    /*
    私有构造方法，防止被实例化
     */
    private Singleton() {
    }

    private static class SingletonFactory{
        private static Singleton instance = new Singleton();
    }

    /*
    获取实例
    JVM内部的机制能够保证当一个类被加载的时候，这个类的加载过程是线程互斥的。这样当我们第一次调用getInstance的时候，JVM能够帮我们保证instance只被创建一次，并且会保证把赋值给instance的内存初始化完毕
     */
    public static Singleton getInstance(){
        return SingletonFactory.instance;
    }

    /*
    静态工程方法，创建实例
     */
//    public static Singleton getInstance() {
//        if (instance == null) {
//            //只有在instance为null，并创建对象的时候才需要加锁
//            synchronized (instance) {
//                if (instance == null) {
//                    instance = new Singleton();
//                }
//            }
//        }
//        return instance;
//    }

    /*
    如果该对象被用于序列化，可以保证对象在序列化前后保持一致
     */
    public Object readResolve() {
        return instance;
    }
}
