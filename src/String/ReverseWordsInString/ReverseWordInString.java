package String.ReverseWordsInString;
/*
Given an input string s, reverse the order of the words.
A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
Return a string of the words in reverse order concatenated by the same spaces.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should
 have all space separating the words.
*/
public class ReverseWordInString {
    public String reverseWordsInString(String string) {
        StringBuilder res = new StringBuilder();
        int i = string.length() - 1;
        while(i >= 0) {
            int j = i;
            while(i >= 0 && string.charAt(i) != ' '){
                i--;
            }
            res.append(string.substring(i + 1, j + 1));
            while(i >= 0 && string.charAt(i) == ' ') {
                i--;
                res.append(" ");
            }

        }
        return res.toString();
    }
}
