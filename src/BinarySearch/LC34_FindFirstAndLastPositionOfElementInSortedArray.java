package BinarySearch;
/*
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target
 value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Example 3:
Input: nums = [], target = 0
Output: [-1,-1]

Constraints:
0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109
*/
// Binary Search Time O(log2N) | Space O(1)
public class LC34_FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        return new int[] {left_bound(nums, target), right_bound(nums, target)};
    }
    int left_bound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        // [left, right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // [mid + 1, right]
            if (nums[mid] < target) left = mid + 1;
            // [left, mid - 1]
            else if (nums[mid] > target) right = mid - 1;
            // Shrink the right border
            else right = mid + 1;
        }
        // edge case out boundary
        if(left > nums.length || nums[left] != target) return -1;
        return left;
    }

    int right_bound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        // [left, right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // [mid + 1, right]
            if (nums[mid] < target) left = mid + 1;
                // [left, mid - 1]
            else if (nums[mid] > target) right = mid - 1;
            // Shrink the left border
            else left = mid + 1;
        }
        if(right < 0 || nums[right] != target) return -1;
        return right;
    }
}
