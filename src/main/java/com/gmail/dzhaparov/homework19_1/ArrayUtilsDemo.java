package com.gmail.dzhaparov.homework19_1;

import java.util.Arrays;
import java.util.Random;

public class ArrayUtilsDemo {
    public static void main(String[] args) {

        ArrayUtils arrayUtils = new ArrayUtils();

        int[] array = new Random().ints(10, 0, 100).toArray();


        System.out.println("Початковий масив:");
        System.out.println(Arrays.toString(array));


        arrayUtils.mergeSort(array);

        // Виводимо відсортований масив
        System.out.println("Відсортований масив:");
        System.out.println(Arrays.toString(array));


        int target = array[5];
        int result = arrayUtils.binarySearch(array, target);


        if (result != -1) {
            System.out.println("Елемент " + target + " знайдено на індексі: " + result);
        } else {
            System.out.println("Елемент " + target + " не знайдено");
        }
    }
}
