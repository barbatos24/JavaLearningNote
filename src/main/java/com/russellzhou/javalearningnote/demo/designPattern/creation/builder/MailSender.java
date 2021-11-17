package com.russellzhou.javalearningnote.demo.designPattern.creation.builder;

public class MailSender implements Sender{

    @Override
    public void Send() {
        System.out.println("this is mailsender!");

    }
}
