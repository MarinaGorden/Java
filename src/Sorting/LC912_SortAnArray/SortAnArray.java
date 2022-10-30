package Sorting.LC912_SortAnArray;
/*
Given an array of integers nums, sort the array in ascending order and return it.
You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest
space complexity possible.

Example 1:
Input: nums = [5,2,3,1]
Output: [1,2,3,5]
Explanation: After sorting the array, the positions of some numbers are not changed (for example, 2 and 3), while
the positions of other numbers are changed (for example, 1 and 5).

Example 2:
Input: nums = [5,1,1,2,0,0]
Output: [0,0,1,1,2,5]
Explanation: Note that the values of nums are not necessarily unique.


Constraints:
1 <= nums.length <= 5 * 104
-5 * 104 <= nums[i] <= 5 * 104
*/
// QuickSort
public class SortAnArray {
    // Average Time Complexity: O(NlogN) | Space Complexity: O(1)
    // Worst Time Complexity: O(N^2) | Space Complexity: O(1)
    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }
    // very similar to the preorder traversal of a binary tree
    void sort(int[] nums, int l, int r) {
        if (l >= r) return;
        int p = partition(nums, l, r);
        sort(nums, l, p);
        sort(nums, p + 1, r);
    }

    int partition(int[] nums, int l, int r) {
        // choose the first element as the pivot
        int pivot = nums[l];
        while (l < r) {
            while (l < r && nums[r] >= pivot) r--;
            nums[l] = nums[r];
            while (l < r && nums[l] <= pivot) l++;
            nums[r] = nums[l];
        }
        nums[l] = pivot;
        return l;
    }

}
