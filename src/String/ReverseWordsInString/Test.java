package String.ReverseWordsInString;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Test {
    @org.junit.jupiter.api.Test
    public static void test(){
        String[] input = new String[] {"Algo is the best!", "Reverse These Words", "..H,, hello 678",
                "this this words this this this words this", "1 12 23 34 56", "APPLE PEAR PLUM ORANGE",
                "this-is-one-word", "a", "ab", "",
                "algo is the best platform to use to prepare for coding interviews!",
                "words, separated, by, commas", "this      string     has a     lot of   whitespace", "a ab a",
                "test        ", " "
        };
        String[] expected = new String[] {"best! the is Algo", "Words These Reverse", "678 hello ..H,,",
                "this words this this this words this this", "56 34 23 12 1", "ORANGE PLUM PEAR APPLE",
                "this-is-one-word", "a", "ab", "",
                "interviews! coding for prepare to use to platform best the is algo",
                "commas by, separated, words,", "whitespace   of lot     a has     string      this", "a ab a",
                "        test", " "
        };
        for (int i = 0; i < input.length; i++) {
            assertTrue(input[i] == expected[i]);
        }
    }
}
