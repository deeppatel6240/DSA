package org.example.searching;

public class LinearSearch {

    public static int linearSearch(int[] arr, int size, int element) {

        // for loop to access each element of array
        for (int i=0; i < size; i++) {

            // check if element is found then return index
            if (arr[i] == element)
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 20, 124, 234, 342, 532, 564, 652, 765, 875, 976};
        int size = arr.length;
        int element = 200;

        int index = linearSearch(arr, size, element);

        System.out.println("element " + element + " found at index: " + index);
    }
}
