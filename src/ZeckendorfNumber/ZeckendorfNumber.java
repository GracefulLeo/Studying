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
        ArrayList<Integer> fibonacci = getReversedFibonacci(input);
        StringBuilder output = new StringBuilder();

        for (Integer aFibonacci : fibonacci) {
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

    private static ArrayList<Integer> getReversedFibonacci(int input) {
        ArrayList<Integer> fibonacci = new ArrayList<>();
        fibonacci.add(1);
        fibonacci.add(2);

        int next = 3;
        while (next <= input) {
            fibonacci.add(next);
            next = fibonacci.get(fibonacci.size() - 1) + fibonacci.get(fibonacci.size() - 2);
        }

        Collections.reverse(fibonacci);

        return fibonacci;
    }
}
