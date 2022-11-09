package Array.LC1243ArrayTransformation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
1243. Array Transformation
Given an initial array arr, every day you produce a new array using the array of the previous day.

On the i-th day, you do the following operations on the array of day i-1 to produce the array of day i:

If an element is smaller than both its left neighbor and its right neighbor, then this element is incremented.
If an element is bigger than both its left neighbor and its right neighbor, then this element is decremented.
The first and last elements never change.
After some days, the array does not change. Return that final array.

Example 1:

Input: arr = [6,2,3,4]
Output: [6,3,3,4]
Explanation:
On the first day, the array is changed from [6,2,3,4] to [6,3,3,4].
No more operations can be done to this array.
Example 2:

Input: arr = [1,6,3,4,3,5]
Output: [1,4,4,4,4,5]
Explanation:
On the first day, the array is changed from [1,6,3,4,3,5] to [1,5,4,3,4,5].
On the second day, the array is changed from [1,5,4,3,4,5] to [1,4,4,4,4,5].
No more operations can be done to this array.


Constraints:

3 <= arr.length <= 100
1 <= arr[i] <= 100
*/
// brute force
public class ArrayTransformation {
    public static List<Integer> transformArray(int[] arr) {
        int len = arr.length;
        int[] tmp;
        List<Integer> res = new ArrayList<>();
        boolean change = true;
        while(change) {
            change = false;
            tmp = Arrays.copyOf(arr, len);
            for(int i = 1; i < len - 1; i++) {
                // store the original value
                tmp[i] = arr[i];
                if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                    tmp[i]--;
                    change = true;
                } else if (arr[i] < arr[i - 1] && arr[i] < arr[i + 1]) {
                    tmp[i]++;
                    change = true;
                }
                arr = tmp;
            }
        }
        for(int val : arr) {
            res.add(val);
        }
        return res;
    }

}
