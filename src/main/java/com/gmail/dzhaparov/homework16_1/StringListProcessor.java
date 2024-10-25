package com.gmail.dzhaparov.homework16_1;

import java.util.function.Supplier;

public class StringListProcessor {

    static int countUppercase(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                count++;
            }
        }
        return count;
    }
}
