package com.russellzhou.javalearningnote.demo.designPattern.creation.abstractFactory;

public class SendSmsFactory implements Provider{

    @Override
    public Sender produce() {
        return new SmsSender();
    }
}
