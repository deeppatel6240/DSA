package org.example.searching;

public class ExponentialSearch {

    public static int exponentialSearch(int[] arr, int size, int element) {

        if (arr[0] == element)
            return 0;

        int i = 1;

        while (i < size && arr[i] <= element)
            i = i * 2;


        return binarySearch(arr, element, i/2, Math.min(i, size-1));
    }

    public static int binarySearch(int[] arr, int element, int low, int high) {
        int mid;

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
        int element = 96;

        int index = exponentialSearch(arr, size, element);

        System.out.println("element " + element + " found at index: " + index);
    }
}
