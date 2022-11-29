package String.FizzBuzz;
/*
You need to write a program that prints the numbers from 1 to 100 such that:
* If the number is a multiple of 3, you need to print "Fizz" instead of that number.
* If the number is a multiple of 5, you need to print "Buzz"  instead of that number.
* If the number is a multiple of both 3 and 5, you need to print "FizzBuzz" instead of that number.
*/
import java.util.*;
public class FizzBuzz {
    public static void main(String[] args) {
        for(int i = 1; i <= 100; i++) {
            System.out.println(fizzBuzzPrinter(i));
        }
    }

    public static String fizzBuzzPrinter(int nums) {
        if(nums % 3 == 0 && nums % 5 == 0) return "FizzBuzz";
        if(nums % 3 == 0) return "Fizz";
        if(nums % 5 == 0) return "Buzz";
        return String.valueOf(nums);
    }
}
