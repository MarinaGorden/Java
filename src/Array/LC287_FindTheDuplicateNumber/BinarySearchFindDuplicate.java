package Array.LC287_FindTheDuplicateNumber;
/** the practice of exchanging time for space is counter-intuitive. This problem can be regarded as an exercise.
 * It is absolutely not recommended in development, unless space resources are expensive.
 */
// binary search Time O(NlogN) | Space O(1)
public class BinarySearchFindDuplicate {
    public int findDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left +(right - left) / 2;
            int count = 0;
            for (int num :nums) {
                if(num < count) count++;
            }
            if(count <= mid) {
                left = mid + 1;
            } else right = mid;
        }
        return left;
    }
}
