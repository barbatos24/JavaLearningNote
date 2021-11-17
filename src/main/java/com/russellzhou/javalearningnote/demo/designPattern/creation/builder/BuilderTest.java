package com.russellzhou.javalearningnote.demo.designPattern.creation.builder;

/**
 * 建造者模式
 */
public class BuilderTest {

    public static void main(String[] args) {
        Builder builder = new Builder();
        builder.produceMailSender(10);
    }

}
