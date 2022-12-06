package BinarySearch;
/*
Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and
 will come back in h hours.
Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas
 from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas
  during this hour.
Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
Return the minimum integer k such that she can eat all the bananas within h hours.

Example 1:
Input: piles = [3,6,7,11], h = 8
Output: 4

Example 2:
Input: piles = [30,11,23,4,20], h = 5
Output: 30

Example 3:
Input: piles = [30,11,23,4,20], h = 6
Output: 23

Constraints:
1 <= piles.length <= 104
piles.length <= h <= 109
1 <= piles[i] <= 109
*/
public class LC875_KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int maxValue = 1;
        for(int pile : piles) {
            maxValue = Math.max(maxValue, pile);
        }
        // min speed, max hour
        int left = 1;
        // max speed, min hour
        int right = maxValue;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(calculateHour(piles, mid) > h) {
                // speed up, [mid+1, right]
                left = mid + 1;
            } else right = mid;
        }
        return left;
    }

    private int calculateHour(int[] piles, int speed) {
        int hours = 0;
        for(int pile: piles) {
            // Time to finish = bananas / speed
            hours += pile / speed;
            if(pile % speed > 0) {
                hours++;
            }
        }
        return hours;
    }
}
