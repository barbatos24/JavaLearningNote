package com.russellzhou.javalearningnote.demo.designPattern.creation.factory;

public class SmsSender implements Sender{

    @Override
    public void Send() {
        System.out.println("this is sms sender!");
    }
}
