package ZeckendorfNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Zeckendorf Number.
 */
public class ZeckendorfNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        convertDecimalToFibonacciBinary(sc.nextInt());
    }

    private static void convertDecimalToFibonacciBinary(int input) {
        ArrayList<Long> fibonacci = getReversedFibonacci(input);
        StringBuilder output = new StringBuilder();

        for (Long aFibonacci : fibonacci) {
            if (input - aFibonacci == 0 || input - aFibonacci > 0) {
                output.append(1);
            } else if (input - aFibonacci < 0) {
                output.append(0);
                continue;
            } else output.append(0);

            input -= aFibonacci;
        }
        output.append("\n");

        System.out.print(output);
    }

    private static ArrayList<Long> getReversedFibonacci(int input) {
        ArrayList<Long> fibonacci = new ArrayList<>();

        // Zeckendorf use Fibonacci numbers not from 0. That the first distinct Fibonacci numbers are: 1, 2, 3, 5.
        // Start save Fibonacci numbers to array from 3 step. Fibonacci: 0->0, 1->1, 2->1, 3->2, 4->3, 5->5, ...
        int i = 3;
        long next = 1;
        while (next <= input) {
            fibonacci.add(next);
            next = fibonacci(i++);
        }

        Collections.reverse(fibonacci);

        return fibonacci;
    }

    /**
     * Returns Fibonacci number starts from 0.
     *
     * @param n Sequence number of number from Fibonacci numeric series.
     * @return Fibonacci number.
     */
    private static long fibonacci(int n) {
        if (n <= 1) return n;
        else return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
