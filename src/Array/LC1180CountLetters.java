package Array;
/*
Given a string s, return the number of substrings that have only one distinct letter.

Example 1:
Input: s = "aaaba"
Output: 8
Explanation: The substrings with one distinct letter are "aaa", "aa", "a", "b".
"aaa" occurs 1 time.
"aa" occurs 2 times.
"a" occurs 4 times.
"b" occurs 1 time.
So the answer is 1 + 2 + 4 + 1 = 8.
Example 2:
Input: s = "aaaaaaaaaa"
Output: 55

Constraints:
1 <= s.length <= 1000
s[i] consists of only lowercase English letters.
*/
// brute force
public class LC1180CountLetters {
    // Time O(N) | Space O(1)
    public int countLetters(String s) {
        int res = 0;
        int count = 1;
        int len = s.length();
        if(s == null || len == 0) return 0;
        for (int i = 1; i < len; i++) {
            if (s.charAt(i - 1) == s.charAt(i)) count++;
            else{
                //count the sum
                res += (count * (count+1)) / 2;
                count = 1;
            }
        }
        res += (count * (count+1)) / 2;
        return res;
    }
}
