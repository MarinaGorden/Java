package TwoPointer;
/*
* Write a function that reverses a string. The input string is given as an array of characters s.
You must do this by modifying the input array in-place with O(1) extra memory.

Example 1:
Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]

Example 2:
Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]

Constraints:
1 <= s.length <= 105
s[i] is a printable ascii character.*/
// Two pointer Time O(N) | Space O(1)
public class LC344ReverseString {
    public void reverseString(char[] s) {
        int slow = 0;
        int fast = s.length - 1;
        while (slow < fast) {
            char tmp = s[slow];
            s[slow++] = s[fast];
            s[fast--] = tmp;
        }
    }
}
