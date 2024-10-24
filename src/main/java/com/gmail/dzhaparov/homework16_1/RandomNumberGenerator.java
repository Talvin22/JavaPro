package com.gmail.dzhaparov.homework16_1;

import java.util.Random;

public class RandomNumberGenerator {
    static Random rand = new Random();

    static int generateRandomNumber(int min, int max) {
        return rand.nextInt(min, max);

    }
}
