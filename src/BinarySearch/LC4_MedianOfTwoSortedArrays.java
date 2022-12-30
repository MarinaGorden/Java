package BinarySearch;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 *
 * Example 1:
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 *
 * Example 2:
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 *
 * Constraints:
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 */
public class LC4_MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        // default len1 <= len2 else reverse
        if (len1 > len2) return findMedianSortedArrays(nums2, nums1);
        int median1 = 0, median2 = 0;
        int left = 0, right = len1;

        while (left <= right) {
            int mid1 = left + (right - left) / 2;
            // mid + mid2 = (len1 + len2 + 1) / 2;
            int mid2 = len1 + (len2 - len1 + 1) / 2 - mid1;
            // nums_mid1m1: nums1[mid1 - 1] max value of left partition
            int nums_mid1m1 = (mid1 == 0 ? Integer.MIN_VALUE : nums1[mid1 - 1]);
            // nums_mid1: nums1[mid1] min value of right partition
            int nums_mid1 = (mid1 == len1 ? Integer.MAX_VALUE : nums1[mid1]);
            // nums_mid1m1: nums2[mid2 - 1] max value of left partition
            int nums_mid2m1 = (mid2 == 0 ? Integer.MIN_VALUE : nums2[mid2 - 1]);
            // nums_mid1: nums2[mid2] min value of right partition
            int nums_mid2 = (mid2 == len2 ? Integer.MAX_VALUE : nums2[mid2]);

            if (nums_mid1m1 <= nums_mid2) {
                median1 = Math.max(nums_mid1m1, nums_mid2m1);
                median2 = Math.min(nums_mid1, nums_mid2);
                left = mid1 + 1;
            } else right = mid1 - 1;
        }
        // if the merged array is even length, return the average of two medians
        return (len1 + len2) % 2 == 0 ? (median1 + median2) / 2 : median1;
    }
}
