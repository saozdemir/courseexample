package com.sao.reversearray;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int[] reverseArray = reverse(array);

        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(reverseArray));

    }

    private static int[] reverse(int[] array) {
        int[] reverseArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reverseArray[array.length - 1 - i] = array[i];
        }
        return reverseArray;
    }
}
