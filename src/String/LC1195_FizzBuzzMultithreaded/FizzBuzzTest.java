package String.LC1195_FizzBuzzMultithreaded;

import org.junit.jupiter.api.Test;

import java.util.function.IntConsumer;

public class FizzBuzzTest {
    @Test
    public static void testcase() {
        FizzBuzzMultithreaded fizzBuzz = new FizzBuzzMultithreaded(15);

        Runnable fizz = () -> System.out.print("fizz");
        Runnable buzz = () -> System.out.print("buzz");
        Runnable fBuzz = () -> System.out.print("fizzbuzz");

        IntConsumer number = System.out::print;


        new Thread(() -> {

            try {
                fizzBuzz.fizz(fizz);
            } catch (InterruptedException e) {

                e.printStackTrace();

                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {

            try {
                fizzBuzz.buzz(buzz);
            } catch (InterruptedException e) {

                e.printStackTrace();

                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {

            try {
                fizzBuzz.fizzbuzz(fBuzz);
            } catch (InterruptedException e) {

                e.printStackTrace();

                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {

            try {
                fizzBuzz.number(number);
            } catch (InterruptedException e) {

                e.printStackTrace();

                throw new RuntimeException(e);
            }
        }).start();
    }
}
