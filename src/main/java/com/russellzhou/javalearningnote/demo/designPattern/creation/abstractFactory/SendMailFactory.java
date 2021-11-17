package com.russellzhou.javalearningnote.demo.designPattern.creation.abstractFactory;

public class SendMailFactory implements Provider{

    @Override
    public Sender produce() {
        return new MailSender();
    }
}
