package com.gmail.dzhaparov.homework19_1;

import com.gmail.dzhaparov.homework21_1.Author;
import com.gmail.dzhaparov.homework21_1.MethodInfo;


import java.text.Annotation;
import java.util.Arrays;
import java.util.Random;

public class ArrayUtilsDemo {

    static <T extends MethodInfo> void printMethodInfo(T annotation) {
        System.out.println("Description of method: " + annotation.description());
        System.out.println("Name of method: " + annotation.name());
        System.out.println("Return type of method: " + annotation.returnType());


    }

    static <T extends Author> void printAuthor(T annotation) {
        System.out.println("Author: " + annotation.value());


    }

    public static void main(String[] args) throws NoSuchMethodException {

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
        System.out.println();

        MethodInfo mergeSort = arrayUtils.getClass().getDeclaredMethod("mergeSort", int[].class).getAnnotation(MethodInfo.class);
        Author mergeSort1 = arrayUtils.getClass().getDeclaredMethod("mergeSort", int[].class).getAnnotation(Author.class);
        printMethodInfo(mergeSort);
        printAuthor(mergeSort1);

        System.out.println();

        MethodInfo merge = arrayUtils.getClass().getDeclaredMethod("merge", int[].class, int[].class, int[].class).getAnnotation(MethodInfo.class);
        Author merge1 = arrayUtils.getClass().getDeclaredMethod("merge", int[].class, int[].class, int[].class).getAnnotation(Author.class);
        printMethodInfo(merge);
        printAuthor(merge1);

        System.out.println();

        MethodInfo binarySearch = arrayUtils.getClass().getDeclaredMethod("binarySearch", int[].class, int.class).getAnnotation(MethodInfo.class);
        Author binarySearch1 = arrayUtils.getClass().getDeclaredMethod("binarySearch", int[].class, int.class).getAnnotation(Author.class);
        printMethodInfo(binarySearch);
        printAuthor(binarySearch1);


    }
}
