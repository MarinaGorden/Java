package Randomized;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * You are given an integer n and an array of unique integers blacklist. Design an algorithm to pick a random integer in
 * the range [0, n - 1] that is not in blacklist. Any integer that is in the mentioned range and not in blacklist should
 * be equally likely to be returned.
 * Optimize your algorithm such that it minimizes the number of calls to the built-in random function of your language.
 *
 * Implement the Solution class:
 * Solution(int n, int[] blacklist) Initializes the object with the integer n and the blacklisted integers blacklist.
 * int pick() Returns a random integer in the range [0, n - 1] and not in blacklist.
 *
 * Example 1:
 * Input
 * ["Solution", "pick", "pick", "pick", "pick", "pick", "pick", "pick"]
 * [[7, [2, 3, 5]], [], [], [], [], [], [], []]
 * Output
 * [null, 0, 4, 1, 6, 1, 0, 4]
 * Explanation
 * Solution solution = new Solution(7, [2, 3, 5]);
 * solution.pick(); // return 0, any integer from [0,1,4,6] should be ok. Note that for every call of pick,
 *                  // 0, 1, 4, and 6 must be equally likely to be returned (i.e., with probability 1/4).
 * solution.pick(); // return 4
 * solution.pick(); // return 1
 * solution.pick(); // return 6
 * solution.pick(); // return 1
 * solution.pick(); // return 0
 * solution.pick(); // return 4
 *
 * Constraints:
 * 1 <= n <= 109
 * 0 <= blacklist.length <= min(105, n - 1)
 * 0 <= blacklist[i] < n
 * All the values of blacklist are unique.
 * At most 2 * 104 calls will be made to pick.
 **/
// HashMap Time O(len(blacklist)) | Space O(len(blacklist))
public class LC710_RandomPickWithBlacklist {
    int len;
    Random random;
    Map<Integer, Integer> map;
    // constructor
    public LC710_RandomPickWithBlacklist(int n, int[] blacklist) {
        map = new HashMap<>();
        for(int blocked : blacklist) {
            // mark blocked elements as -1
            map.put(blocked, -1);
        }
        // whitelist length
        len = n - map.size();
        // Re-map all blacklist numbers in [0,N−len(B)) to whitelist numbers
        for (int blocked : blacklist) {
            // blacklist element is in the whitelist scope
            if(blocked < len) {
                // skip all the blacklist elements
                while (map.containsKey(n - 1)) n--;
            // change blocked elements to the end of the map, remap all indices of blocked elements into allowed numbers
                map.put(blocked, n-1);
                n--;
            }
        }
        random = new Random();
    }

    public int pick() {
        int randomIndex = random.nextInt(len);
        // in blacklist, use map to reflect other index
        if(map.containsKey(randomIndex)) return map.get(randomIndex);
        return randomIndex;
    }
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */