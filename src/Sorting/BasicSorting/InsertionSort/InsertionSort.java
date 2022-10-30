package Sorting.BasicSorting.InsertionSort;
/*
Write a function that takes in an array of integers and returns a sorted version of that array. Use the Insertion Sort
algorithm to sort the array.
Sample Input
array = [8, 5, 2, 9, 5, 6, 3]
Sample Output
[2, 3, 5, 5, 6, 8, 9]
*/
public class InsertionSort {
    public static int[] insertionSort(int[] array) {
        // Best: Time O(N) | Space O(1)
        // Average: Time O(N^2) | Space O(1)
        // Worst: Time O(N^2) | Space O(1)
        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            // pick the minimum element index at [i+1, len-1)
            int minIndex = i;
            for (int j = i + 1; j <len; j++) {
                if(array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);
        }
        return array;
    }

    static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
