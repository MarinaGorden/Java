package BinarySearch.LC1095_FindInMountainArray;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
(This problem is an interactive problem.)

You may recall that an array arr is a mountain array if and only if:
- arr.length >= 3
- There exists some i with 0 < i < arr.length - 1 such that:
-- arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
-- arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target. If such an
index does not exist, return -1.

You cannot access the mountain array directly. You may only access the array using a MountainArray interface:
- MountainArray.get(k) returns the element of the array at index k (0-indexed).
- MountainArray.length() returns the length of the array.
Submissions making more than 100 calls to MountainArray. get will be judged Wrong Answer. Also, any solutions that
attempt to circumvent the judge will result in disqualification.

Example 1:
Input: array = [1,2,3,4,5,3,1], target = 3
Output: 2
Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum index, which is 2.

Example 2:
Input: array = [0,1,2,4,2,1], target = 3
Output: -1
Explanation: 3 does not exist in the array, so we return -1.

Constraints:
3 <= mountain_arr.length() <= 104
0 <= target <= 109
0 <= mountain_arr.get(index) <= 109
**/



public class LC1095_FindInMountainArray implements MountainArray{
    ArrayList<Integer> mountainArray;

    public LC1095_FindInMountainArray(){
        this.mountainArray = new ArrayList<Integer>();
    }
    @Override
    public int get(int index) {
        return mountainArray.get(index);
    }

    @Override
    public int length() {
        return mountainArray.size();
    }

    public int findInMountainArray(MountainArray mountainArr, int target) {
        int peakIdx = findPeakIndex(mountainArr, target);
        int targetIdx = binarySearchTarget(mountainArr, target, 0, peakIdx, true);
        if(targetIdx == -1) targetIdx = binarySearchTarget(mountainArr, target, peakIdx + 1,
                mountainArr.length() - 1, false);
        return targetIdx;
    }

    public int findPeakIndex(MountainArray mountainArr, int target) {
        int left = 0;
        int right = mountainArr.length() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) > mountainArr.get(mid + 1)) {
                // shrink to the left partition
                right = mid;
            } else left = mid + 1;
        }
        return left;
    }

    public int binarySearchTarget(MountainArray mountainArr, int target, int left, int right, boolean isAscending) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) > target) {
                if (isAscending) right = mid - 1;
                else left = mid + 1;
            } else if (mountainArr.get(mid) < target) {
                if (isAscending) left = mid + 1;
                else right = mid - 1;
            } else return mid;
        }
        return -1;
    }

}
