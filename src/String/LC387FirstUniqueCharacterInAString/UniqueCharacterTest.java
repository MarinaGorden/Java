package String.LC387FirstUniqueCharacterInAString;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UniqueCharacterTest {
    @Test
    public void Test(){
        String[] input = new String[] {"abcdcaf", "faadabcbbebdf", "a", "ab", "abc", "abac", "ababac",
                "ababacc", "lmnopqldsafmnopqsa", "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxy",
                "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz", "", "ggyllaylacrhdzedddjsc",
                "aaaaaaaaaaaaaaaaaaaabbbbbbbbbbcccccccccccdddddddddddeeeeeeeeffghgh","aabbccddeeff"};

        int[] expected = new int[] {1, 6, 0, 0, 0, 1, 5, -1, 7, 25, -1, -1, 10, -1, -1};

        for(int i = 0; i < expected.length; i++) {
            assertTrue(expected[i] == LC387FirstUniqueCharacterInAString.firstUniqChar(input[i]));
        }
        if(input.length != expected.length) return;
    }
}
