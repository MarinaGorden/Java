package PriorityQueue;

import java.util.HashMap;
import java.util.Stack;

/**
 * The next greater element of some element x in an array is the first greater element that is to the right of x in the
 * same array.
 * You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
 * For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater
 * element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.
 * Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.
 *
 * Example 1:
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
 * Output: [-1,3,-1]
 * Explanation: The next greater element for each value of nums1 is as follows:
 * - 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
 * - 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
 * - 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
 *
 * Example 2:
 * Input: nums1 = [2,4], nums2 = [1,2,3,4]
 * Output: [3,-1]
 * Explanation: The next greater element for each value of nums1 is as follows:
 * - 2 is underlined in nums2 = [1,2,3,4]. The next greater element is 3.
 * - 4 is underlined in nums2 = [1,2,3,4]. There is no next greater element, so the answer is -1.
 *
 * Constraints:
 * 1 <= nums1.length <= nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 104
 * All integers in nums1 and nums2 are unique.
 * All the integers of nums1 also appear in nums2.
 **/
// Monotonic Stack Time O(nums1.length + nums2.length
public class LC496_NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] greaterElement = nextGreaterElement(nums2);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            // map nums2[i] -> its greater element
            map.put(nums2[i], greaterElement[i]);
        }
        // nums1 is the subset of nums2
        int[] res= new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }

    public int[] nextGreaterElement(int[] nums) {
        int len = nums.length;
        int [] res = new int[len];
        Stack<Integer> stack = new Stack<>();
        // stack is first-in-last-out, so all elements should be stored reversely
        for (int i = len - 1; i >= 0; i++) {
            stack.push(nums[i]);
            // judge the elements if the tail isn't the biggest, pop
            while(!stack.isEmpty() && nums[i] >= stack.peek()) {
                // pop the smaller number
                stack.pop();
            }
            // get the next greater one
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            // nums[i] is bigger than the peak, store the number
            stack.push(nums[i]);
        }
        return res;
    }
}
