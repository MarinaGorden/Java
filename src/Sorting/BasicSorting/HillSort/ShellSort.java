package Sorting.BasicSorting.HillSort;
/*
Shell Sort is the optimization of Insertion Sort.
1. Reduce the increment(interval), then divide the subsequence with increment
2. Apply insertion sort to each subsequence, continuously shrinking the increment until the increment == 1
*/
public class ShellSort {
    // Worst: Time Complexity less than O（N^2） | Space Complexity O(1)
    // Best: Time Complexity O（NlogN） | Space Complexity O(1)
    // Average: Time Complexity O（NlogN） | Space Complexity O(1)
    public int[] shellSortArray(int[] nums) {
        int len = nums.length;
        int gap = len / 2;
        int step = 1;
        while (gap >= 1) {
            // shrink the increment and apply the insertion sort
            for (int i = step; i < len; i++) {
                insertionForSubsequence(nums, i, step);
            }
            gap /= 2;
        }
        return nums;
    }

    private void insertionForSubsequence(int[] nums, int gap, int end) {
        int tmp = nums[end];
        int j = end;
        while (j >= gap && nums[j - gap] > tmp) {
            nums[j] = nums[j - gap];
            j -= gap;
        }
        nums[j] =tmp;
    }
}
