package Math.LC9PalindromeNumber;
// When the length is an odd number, we can get rid of the middle digit by revertedNumber/10
// For example when the input is 12321, at the end of the while loop we get x = 12, revertedNumber = 123,
// since the middle digit doesn't matter in palindrome(it will always equal to itself), we can simply get rid of it.

public class PalindromeNumber3 {
    // Time O(log10N) Space O(1)
    public boolean isPalindrome(int x) {
        // if the last digit is 0, the first digit should also be 0 => only 0 satisfy this property
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int reversed = 0;
        while (x > reversed) {
            reversed = reversed *10 + x % 10;
            x /= 10;
        }
        return x == reversed || x == reversed / 10;
    }
}
