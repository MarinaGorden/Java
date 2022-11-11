package String.PalindromeCheck;

public class PalindromeCheck {
    public static boolean isPalindrome(String str) {
        // Write your code here.
        int l = 0;
        int r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
