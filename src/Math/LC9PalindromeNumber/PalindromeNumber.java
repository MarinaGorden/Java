package Math.LC9PalindromeNumber;
/*
Given an integer x, return true if x is a palindrome, and false otherwise.

Example 1:
Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.

Example 2:
Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.


Constraints:
-231 <= x <= 231 - 1
*/
//Two Pointer
public class PalindromeNumber {
    // Time O(N^2) | Space O(1)
    public boolean isPalindrome(int x) {
        String value = String.valueOf(x);
        int l = 0;
        int r = value.length()-1;
        while (l < r) {
            if(value.charAt(l) != value.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
