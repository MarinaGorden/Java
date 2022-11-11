package String.PalindromeCheck;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Test{
    @org.junit.jupiter.api.Test
    public void TestCase(){
        assertTrue(PalindromeCheck.isPalindrome("abcdefghihgfedcba"));
        assertFalse(PalindromeCheck.isPalindrome("abcdefghihgfeddcba"));
    }
}