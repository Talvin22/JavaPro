package com.gmail.dzhaparov.homework24_1;

public class LoggerDemo {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("Demo1");
        logger2.log("Demo2");

        if (logger1 == logger2){
            System.out.println("Logger1 is the same instance as Logger2");
            return;
        }
        System.out.println("Logger1 is NOT the same instance as Logger2");
    }
}
