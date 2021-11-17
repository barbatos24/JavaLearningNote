package com.russellzhou.javalearningnote.demo.designPattern.creation.builder;

public class SmsSender implements Sender{

    @Override
    public void Send() {
        System.out.println("this is sms sender!");
    }
}
