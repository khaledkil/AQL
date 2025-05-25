package org.example;

public class BinarySearch {
    public static int binarySearch(int[] array, int element) {
        if (array == null) {
            throw new NullPointerException("Array must not be null");
        }
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {  // Fixed: changed < to <=
            int mid = (low + high) / 2;
            if (array[mid] == element) {
                return mid;
            } else if (array[mid] < element) {  // Fixed: removed = from <=
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}