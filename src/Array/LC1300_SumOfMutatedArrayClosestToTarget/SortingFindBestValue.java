package Array.LC1300_SumOfMutatedArrayClosestToTarget;
import java.util.*;
/**
 * Given an integer array arr and a target value target, return the integer value such that when we change all the
 * integers larger than value in the given array to be equal to value, the sum of the array gets as close as possible (in absolute difference) to target.
 * In case of a tie, return the minimum such integer.
 * Notice that the answer is not necessarily a number from arr.
 *
 * Example 1:
 * Input: arr = [4,9,3], target = 10
 * Output: 3
 * Explanation: When using 3 arr converts to [3, 3, 3] which sums 9 and that's the optimal answer.
 *
 * Example 2:
 * Input: arr = [2,3,5], target = 10
 * Output: 5
 *
 * Example 3:
 * Input: arr = [60864,25176,27249,21296,20204], target = 56803
 * Output: 11361
 *
 * Constraints:
 * 1 <= arr.length <= 104
 * 1 <= arr[i], target <= 105
**/
// Sort Time O(NlogN) | Space O(1)
public class SortingFindBestValue {
    public int findBestValue(int[] arr, int target) {
        // Sorts the specified array into ascending numerical order.
        Arrays.sort(arr);
        int i = 0, len = arr.length;
        // start from minimum elements. If target>=arr[i]*remaining length, couldn't hit the target. try bigger one.
        while (i < len && target >= arr[i] * (len - i)) {
            // because it's too smaller, we can simply remove it from target
            target -= arr[i++];
        }
        // exit when the element is bigger than target
        // iterate all the array couldn't find the res. return the maximum element.
        if (i == len) return arr[len - 1];
        // spilt target evenly depends on the remaining element numbers
        int res = target / (len - i);
        // compare res, res+1 to find the nearest number
        if (target - res * (len - i) > (res + 1) *(len - i) - target) {
            res++;
        }
        return res;
    }
}
