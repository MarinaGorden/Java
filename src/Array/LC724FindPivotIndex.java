package Array;

public class LC724FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int sum = 0, leftSum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        for(int i = 0; i < nums.length; i++) {
            sum -= nums[i];
            if(sum == leftSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
