package Array.LC1300_SumOfMutatedArrayClosestToTarget;
// Binary Search Time O(NlogN) | Space O(1)
public class BinarySearchFindBestValue {
    public int findBestValue(int[] arr, int target) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int num : arr) {
            max = Math.max(max, num);
            sum += num;
        }
        // Edge case: couldn't hit the target, there's no element meet the condition. Return the closet(largest)
        if (sum <= target) return max;

        int min = 0;
        int res = -1, diff = Integer.MAX_VALUE;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            sum = getMutatedSum(arr, mid);
            if (sum > target) {
                // go smaller partition
                max = mid - 1;
            } else  min = mid + 1;
            // compare differences to find the smallest diff
            int currDiff = Math.abs(sum - target);
            // reset diff to the smallest diff and make sure the integer is the smallest
            if (currDiff < diff || (currDiff == diff && mid < res)) {
                res = mid;
                diff = currDiff;
            }
        }
        return res;
    }

    private int getMutatedSum(int[] arr, int mid) {
        int sum = 0;
        for(int num : arr) {
            // we need to find the minimum integer so choose the smaller one
            sum += num > mid ? mid : num;
        }
        return sum;
    }
}
