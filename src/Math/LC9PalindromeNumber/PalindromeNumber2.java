package Math.LC9PalindromeNumber;
// half reversed
public class PalindromeNumber2 {
    // Time O(log10N) Space O(1)
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int tmp = x;
        int reversed = 0;
        while (tmp > 0) {
            int currDigit = tmp % 10;
            tmp /= 10;
            reversed = reversed *10 + currDigit;
        }
        return x == reversed;
    }
}
