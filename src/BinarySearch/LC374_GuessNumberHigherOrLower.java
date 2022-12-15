package BinarySearch;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
We are playing the Guess Game. The game is as follows:
I pick a number from 1 to n. You have to guess which number I picked.
Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.
You call a pre-defined API int guess(int num), which returns three possible results:
-1: Your guess is higher than the number I picked (i.e. num > pick).
1: Your guess is lower than the number I picked (i.e. num < pick).
0: your guess is equal to the number I picked (i.e. num == pick).
Return the number that I picked.
Example 1:
Input: n = 10, pick = 6
Output: 6

Example 2:
Input: n = 1, pick = 1
Output: 1

Example 3:
Input: n = 2, pick = 1
Output: 1

Constraints:
1 <= n <= 231 - 1
1 <= pick <= n
*/
// Binary Search Time O(log2N) | Space O(1)
public class LC374_GuessNumberHigherOrLower {
    static int pick;
    static int num;
    public LC374_GuessNumberHigherOrLower(int num, int pick) {
        this.num = num;
        this.pick = pick;
        guess(num, pick);
    }

    public static int guessNumber(int n) {
        // boundary because of picked number=[1, n]
        int left = 1;
        int right = n;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(guess(mid) == 0) return mid;
                // num < picked, guess(n) = 1
            else if(guess(mid) == 1){
                // [mid+1, right]
                return left = mid + 1;
            } else {
                // [left, mid-1]
                return right = mid - 1;
            }
        }
        // couldn't find picked number
        return -1;
    }
    private static int guess(int n){
        return guess(n, pick);
    }
    public static int guess(int n, int picked){
        if(n > picked) return -1;
        // num < picked, guess(n) = 1
        else if(n < picked) return 1;
        return 0;
    }

    public static void main(String[] args){
        LC374_GuessNumberHigherOrLower case1 = new LC374_GuessNumberHigherOrLower(10, 6);
        assertEquals(case1.guessNumber(10), 6);
        LC374_GuessNumberHigherOrLower case2 = new LC374_GuessNumberHigherOrLower(1, 1);
        assertEquals(case2.guessNumber(1), 1);
        LC374_GuessNumberHigherOrLower case3 = new LC374_GuessNumberHigherOrLower(2, 1);
        assertEquals(case3.guessNumber(1), 1);
    }
}
