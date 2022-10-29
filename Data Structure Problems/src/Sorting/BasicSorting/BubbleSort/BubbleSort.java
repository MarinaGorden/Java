package Sorting.BasicSorting.BubbleSort;
/*
Write a function that takes in an array of integers and returns a sorted version of that array. Use the Bubble Sort
algorithm to sort the array.
Sample Input
array = [8, 5, 2, 9, 5, 6, 3]
Sample Output
[2, 3, 5, 5, 6, 8, 9]
 */
import java.util.*;

public class BubbleSort {
    // Best: Time O(N) | Space O(1)
    // Average: Time O(N^2) | Space O(1)
    // Worst: Time O(N^2) | Space O(1)
    public static int[] bubbleSort(int[] array) {
        int len = array.length;
        for (int i = 0; i < len - 1; i++){
            for (int j = 0; j < len - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
        return array;
    }
    static int[] bubbleSortII(int[] array) {
        int len = array.length;
        boolean flag = false;
        for (int i=0; i < len -1; i++) {
            for (int j = 0; j < len -1; j++) {
                if (array[j]> array[j + 1]) {
                    swap(array, j, j+1);
                    flag = true;
                }
                if (!flag) break;
            }
        }
        return array;
    }
    static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }


}
