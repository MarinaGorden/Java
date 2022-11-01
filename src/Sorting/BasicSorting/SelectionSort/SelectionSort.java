package Sorting.BasicSorting.SelectionSort;


public class SelectionSort {
    public static int[] selectionSort(int[] array) {
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
