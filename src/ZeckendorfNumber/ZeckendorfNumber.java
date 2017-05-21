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
        int input = sc.nextInt();

        ArrayList<Integer> fibonacci = getReversedFibonacci(input);
        int size = fibonacci.size();
        byte[] bytes = new byte[size];

        for (int i = 0; i < size; i++) {
            if (input - fibonacci.get(i) == 0 || input - fibonacci.get(i) > 0) {
                bytes[i] = 1;
            } else if (input - fibonacci.get(i) < 0) {
                continue;
            } else bytes[i] = 0;

            input -= fibonacci.get(i);
        }

        for (byte b : bytes) System.out.print(b);
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
