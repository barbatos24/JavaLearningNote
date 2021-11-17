package com.russellzhou.javalearningnote.demo.designPattern.creation.factory;

/**
 * 普通工场模式
 */
public class FactoryTest {

    public static void main(String[] args) {
        SendFactory factory = new SendFactory();
        Sender sender = factory.produce("sms");
        sender.Send();
    }

}
