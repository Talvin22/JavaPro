package com.gmail.dzhaparov.homework19_1;

import com.gmail.dzhaparov.homework21_1.Author;
import com.gmail.dzhaparov.homework21_1.MethodInfo;

import java.util.Arrays;

public class ArrayUtils {

    @MethodInfo(name = "mergeSort", description = "method for mergeSorting", returnType = "void")
    @Author("Talvin")
    public static void mergeSort(int[] array) {
        if (array.length < 2) {
            return;
        }
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);

        mergeSort(left);
        mergeSort(right);
        merge(array, left, right);
    }

    @MethodInfo(name = "merge", description = "method for merging", returnType = "void")
    @Author("Talvin")
    private static void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }
        while (i < left.length) {
            array[k++] = left[i++];
        }
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }


    @MethodInfo(name = "binarySearch", description = "method for binarySearch", returnType = "int")
    @Author("Talvin")
    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

}