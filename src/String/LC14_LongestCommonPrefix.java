package String;
/*
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".


Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

Constraints:
1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.
*/
public class LC14_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int m = strs.length;
        int n = strs[0].length();
        for(int col = 0; col < n; col++) {
            for(int row = 1; row < m; row++) {
                String prevStr = strs[row - 1], currStr = strs[row];
                if(col >= prevStr.length() || col >= currStr.length() || currStr.charAt(col) != prevStr.charAt(col)) {
                    return strs[row].substring(0, col - 1);
                }
            }
        }
        return strs[0];
    }
}
