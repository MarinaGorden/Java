package Sorting.BasicSorting.InsertionSort;
/*
Write a function that takes in an array of integers and returns a sorted version of that array. Use the Insertion Sort
algorithm to sort the array.
Sample Input
array = [8, 5, 2, 9, 5, 6, 3]
Sample Output
[2, 3, 5, 5, 6, 8, 9]
*/
/*
1. Search elements from left to right and select the smallest element each time.
2. Put the largest element at the very end for each time.
3. Continue as above until you have no unsorted elements on the left.
*/
public class InsertionSort {
    public static int[] insertionSort(int[] array) {
        // Best: Time O(N) | Space O(1)
        // Average: Time O(N^2) | Space O(1)
        // Worst: Time O(N^2) | Space O(1)
        int len = array.length;
        for (int i = 0; i < len; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j-1] > array[j]) {
                    swap(array, j-1, j);
                } else {
                    break;
                }
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
