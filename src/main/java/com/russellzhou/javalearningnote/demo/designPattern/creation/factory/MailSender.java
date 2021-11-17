package com.russellzhou.javalearningnote.demo.designPattern.creation.factory;

public class MailSender implements Sender{

    @Override
    public void Send() {
        System.out.println("this is mailsender!");

    }
}
