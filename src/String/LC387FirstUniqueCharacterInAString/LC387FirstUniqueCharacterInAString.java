package String.LC387FirstUniqueCharacterInAString;
/*
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

Example 1:
Input: s = "leetcode"
Output: 0

Example 2:
Input: s = "loveleetcode"
Output: 2

Example 3:
Input: s = "aabb"
Output: -1

Constraints:
1 <= s.length <= 105
s consists of only lowercase English letters.
*/
import java.util.HashMap;

public class LC387FirstUniqueCharacterInAString {
    public static int firstUniqChar(String s) {
        int len = s.length();
        HashMap<Character, Integer> seen = new HashMap<>();
        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);
            /*
            * if(seen.containsKey(c)) seen.put(c, seen.get(c) + 1);
            *  else seen.put(c, 1);
            */
            seen.put(c, seen.getOrDefault(c,0) + 1);
        }
        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if(seen.get(c) == 1){
                return i;
            }
        }
        return -1;
    }
}
