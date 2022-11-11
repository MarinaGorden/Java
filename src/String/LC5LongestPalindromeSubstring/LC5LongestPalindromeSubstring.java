package String.LC5LongestPalindromeSubstring;
/*
Given a string s, return the longest palindromic substring in s.

Example 1:
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

Example 2:
Input: s = "cbbd"
Output: "bb"

Constraints:
1 <= s.length <= 1000
s consist of only digits and English letters.
*/
public class LC5LongestPalindromeSubstring {
    public String longestPalindrome(String s) {
        String res = "";
        for(int i = 0; i < s.length(); i++){
            String s1 = palindrome(s, i ,i);
            String s2 = palindrome(s, i, i + 1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    static String palindrome(String str, int l, int r) {
        while (l >= 0 && r < str.length() && str.charAt(l) == str.charAt(r)) {
            l--;
            r++;
        }
        return str.substring(l + 1, r);
    }
}
