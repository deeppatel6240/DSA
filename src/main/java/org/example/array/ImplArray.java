package org.example.array;

import java.util.Arrays;
import java.util.Random;

public class ImplArray {


    // Get the First of an Array
    public static int getFirstElement(int[] arr) {
        return arr[0];
    }

    // Get the Last of an Array
    public static int getLastElement(int[] arr) {
        return arr[arr.length - 1];
    }

    // Get a Random Value from an Array
    public static int getRandomElement(int[] arr) {
        return arr[new Random().nextInt(arr.length)];
    }

    // Append a New Item to an Array
    public static int[] appendItemIntoArr(int[] arr, int value) {
        int[] newArr = Arrays.copyOf(arr, arr.length+1);
        newArr[newArr.length - 1] = value;

        return newArr;
    }

    // Compare Two Arrays
    public static boolean compareArrays(int[] arr, int[] arrSec) {
        return Arrays.equals(arr, arrSec);
    }

    // Check if an Array Is Empty
    public static boolean checkArrayIsEmpty(int[] arr) {
        return arr == null || arr.length == 0;
    }

    // Remove Duplicates from an Array
    public static int[] removeDuplicate(int[] arr) {
        return Arrays.stream(arr).distinct().toArray();
    }

    // Sorting Array
    public static int[] sortedArr(int[] arr) {
        Arrays.sort(arr);
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {90, 20, 30, 40, 50, 60, 70};

        System.out.println(Arrays.toString(sortedArr(arr)));
    }
}
