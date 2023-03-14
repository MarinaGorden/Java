package Array.NSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/*
Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]]
such that:
0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

Example 1:
Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

Example 2:
Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]

Constraints:
1 <= nums.length <= 200
-109 <= nums[i] <= 109
-109 <= target <= 109*/
// Time O(N^3) | Space O(n)
public class LC18_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }

    public List<List<Integer>> kSum(int[] nums, long target, int start, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        // over the boundary
        if (start == n) return res;
        // avoid overflow
        long average_Sum = target / k;
        if (nums[start] > average_Sum || nums[n - 1] < average_Sum) return res;
        if (k == 2) return twoSum(nums, target, start);

        for (int i = start; i < n; ++i) {
            // avoid duplicate quadruplets
            if (i == start || nums[i - 1] != nums[i]) {
                // recursion
                for (List<Integer> subset : kSum(nums, target - nums[i], i + 1, k - 1)) {
                    // add nums[i] into subset
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    // add subset into the res
                    res.get(res.size() - 1).addAll(subset);
                }
            }
        }
        return res;
    }

    public List<List<Integer>> twoSum(int[] nums, long target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        int left = start, right = n - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target || (left > start && nums[left] == nums[left - 1])) {
                ++left;
            } else if (sum > target || (right < n - 1 && nums[right] == nums[right + 1])) {
                --right;
            } else {
                res.add(Arrays.asList(nums[left++], nums[right--]));
            }
        }
        return res;
    }


}
