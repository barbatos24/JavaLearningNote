package com.russellzhou.javalearningnote.demo.designPattern.creation.abstractFactory;

public class MailSender implements Sender{

    @Override
    public void send() {
        System.out.println("this is mail sender!");
    }
}
