package com.russellzhou.javalearningnote.demo.designPattern.creation.abstractFactory;

public class SmsSender implements Sender{

    @Override
    public void send() {
        System.out.println("this is sms sender!");
    }


}
