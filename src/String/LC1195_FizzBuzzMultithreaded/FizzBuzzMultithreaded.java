package String.LC1195_FizzBuzzMultithreaded;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.Predicate;

/*
You have the four functions:
printFizz that prints the word "fizz" to the console,
printBuzz that prints the word "buzz" to the console,
printFizzBuzz that prints the word "fizzbuzz" to the console, and
printNumber that prints a given integer to the console.

You are given an instance of the class FizzBuzz that has four functions: fizz, buzz, fizzbuzz and number. The same
instance of FizzBuzz will be passed to four different threads:
Thread A: calls fizz() that should output the word "fizz".
Thread B: calls buzz() that should output the word "buzz".
Thread C: calls fizzbuzz() that should output the word "fizzbuzz".
Thread D: calls number() that should only output the integers.
Modify the given class to output the series [1, 2, "fizz", 4, "buzz", ...] where the ith token (1-indexed) of the series
 is:
"fizzbuzz" if i is divisible by 3 and 5,
"fizz" if i is divisible by 3 and not 5,
"buzz" if i is divisible by 5 and not 3, or
i if i is not divisible by 3 or 5.

Implement the FizzBuzz class:
FizzBuzz(int n) Initializes the object with the number n that represents the length of the sequence that should be
 printed.
void fizz(printFizz) Calls printFizz to output "fizz".
void buzz(printBuzz) Calls printBuzz to output "buzz".
void fizzbuzz(printFizzBuzz) Calls printFizzBuzz to output "fizzbuzz".
void number(printNumber) Calls printNumber to output the numbers.

Example 1:
Input: n = 15
Output: [1,2,"fizz",4,"buzz","fizz",7,8,"fizz","buzz",11,"fizz",13,14,"fizzbuzz"]

Example 2:
Input: n = 5
Output: [1,2,"fizz",4,"buzz"]

Constraints:
1 <= n <= 50
 */
public class FizzBuzzMultithreaded {
    private int n;
    private int currNumber;

    public FizzBuzzMultithreaded(int n) {
        this.n =n;
        this.currNumber = 1;
    }

    public void fizz(Runnable printFizz) throws InterruptedException {
        checkDivisibilityAndRun(
                (x) -> (x % 3 == 0 && x % 5 != 0), (x) -> printFizz.run()
        );
    }

    public void buzz(Runnable printBuzz) throws InterruptedException {
        checkDivisibilityAndRun(
                (x) -> (x % 3 != 0 && x % 5 == 0), (x) -> printBuzz.run()
        );
    }

    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        checkDivisibilityAndRun(
                (x) -> (x % 15 == 0), (x) -> printFizzBuzz.run()
        );
    }

    public void number(IntConsumer printNumber) throws InterruptedException {
        checkDivisibilityAndRun(
                (x) -> (x % 3 != 0 && x % 5 != 0), (x) -> printNumber.accept(x)
        );
    }

    private synchronized void checkDivisibilityAndRun(Predicate<Integer> predicate, Consumer<Integer> consumer)
            throws InterruptedException {
        while(currNumber <= n) {
            if(predicate.test(currNumber)) {
                consumer.accept(currNumber);
                currNumber++;
                notifyAll();
            } else wait();
        }
    }

}
