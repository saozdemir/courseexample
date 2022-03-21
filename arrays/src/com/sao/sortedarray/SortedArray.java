package com.sao.sortedarray;

import java.util.Arrays;
import java.util.Scanner;

public class SortedArray {
    static Scanner scanner = new Scanner(System.in);

    public static int[] getIntegers(int capacity) {
        int[] array = new int[capacity];
        System.out.println("Enter " + capacity +" integer values:\r");
        for (int i = 0; i < capacity; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static int[] sortIntegers(int[] array) {
        int[] sortedArray = Arrays.copyOf(array, array.length);
        boolean flag = true;
        int temp;
        while (flag) {
            flag = false;
            for (int i = 0; i < sortedArray.length - 1; i++) {
                if (sortedArray[i] < sortedArray[i + 1]) {
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i + 1];
                    sortedArray[i + 1] = temp;
                    flag = true;
                }
            }
        }
        return sortedArray;

    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Element " + i + " contents " + array[i]);
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter size: \r");
        int size = scanner.nextInt();
        int[] array = getIntegers(size);
        int[] sorted = sortIntegers(array);
        printArray(sorted);

    }
}
