package com.gmail.dzhaparov.homework16_1;

import java.util.function.Function;
import java.util.function.Supplier;

public abstract class HomeworkDemo {

    public static void main(String[] args) {
        MathOperation demo = new MathOperation() {
            @Override
            public int operate(int a, int b) {
                return a + b;
            }
        };

        System.out.println("Plus operation: " + demo.operate(3, 4));


        StringManipulator stringManipulator = String::toUpperCase;
        System.out.println("Upper case string: " + stringManipulator.toUpperCaseCustom("Hello World"));


        Function<String, Integer> upperCaseCounter = StringListProcessor::countUppercase;
        System.out.println("Upper case function: " + upperCaseCounter.apply("Hello World"));

        Supplier<Integer> integerSupplier = () -> RandomNumberGenerator.generateRandomNumber(1, 100);
        System.out.println("Random number: " + integerSupplier.get());

    }


}
