package com.russellzhou.javalearningnote.demo.designPattern.creation.factory;

public class SendFactory {

    public Sender produce(String type) {
        if ("mail".equals(type)) {
            return new MailSender();
        } else if ("sms".equals(type)) {
            return new SmsSender();
        } else {
            System.out.println("please input right type!");
            return null;
        }
    }
}
