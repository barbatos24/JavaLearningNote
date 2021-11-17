package com.russellzhou.javalearningnote.demo.designPattern.creation.abstractFactory;

/**
 * 抽象工场模式
 */
public class AbstractFactoryTest {

    public static void main(String[] args) {
        Provider provider = new SendMailFactory();
        Sender sender = provider.produce();
        sender.send();
    }

}
