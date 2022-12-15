package BinarySearch;
/*
* Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return
*  the index where it would be if it were inserted in order.
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [1,3,5,6], target = 5
Output: 2

Example 2:
Input: nums = [1,3,5,6], target = 2
Output: 1

Example 3:
Input: nums = [1,3,5,6], target = 7
Output: 4

Constraints:
1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums contains distinct values sorted in ascending order.
-104 <= target <= 104
*/
// Binary Search Time O(Log2N) Space O(1)
public class LC35_SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        // left boundary bs
        int left = 0;
        // insert position could be the end of array
        int right = nums.length;
        // [left, right]
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                right = mid;
            } else if(nums[mid] < target) {
                //[mid+1, right]
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
