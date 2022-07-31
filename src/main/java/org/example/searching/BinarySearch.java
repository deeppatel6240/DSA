package org.example.searching;

import java.util.Arrays;

public class BinarySearch {

    public static int binarySearch(int[] arr, int size, int element) {
        int low, mid, high;

        low = 0;
        high = size - 1;

        while (low <= high) {
            mid = (low + high) / 2;

            if (element == arr[mid]) {
                return mid;
            }

            if (element > arr[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {1, 20, 124, 234, 342, 532, 564, 652, 765, 875, 976};
        int size = arr.length;
        int element = 532;

        int index = binarySearch(arr, size, element);

        System.out.println("element " + element + " found at index: " + index);
    }
}
