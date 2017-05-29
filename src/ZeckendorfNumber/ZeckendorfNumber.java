package ZeckendorfNumber;

import java.util.*;

/**
 * Zeckendorf Number.
 */
public class ZeckendorfNumber {
    private TreeMap<Integer, ArrayList<Byte>> decimalsWithFibonacciBinariesList = new TreeMap<>();

    public void addDecimal(int decimal) {
        this.decimalsWithFibonacciBinariesList.put(decimal, convertDecimalToFibonacciBinary(decimal));
    }

    public void requestDecimal() {
        System.out.print("Enter decimal number: ");

        Scanner scanner = new Scanner(System.in);
        int decimal = scanner.nextInt();

        this.decimalsWithFibonacciBinariesList.put(decimal, convertDecimalToFibonacciBinary(decimal));
    }

    public void printZackendorfNumbers() {
        StringBuilder s = new StringBuilder();

        for (Map.Entry<Integer, ArrayList<Byte>> pair : decimalsWithFibonacciBinariesList.entrySet()) {
            s.append("Zeckendorf number for ").append(pair.getKey()).append(": ").append(arrayListToString(pair.getValue()));
            s.append("\n");
        }

        System.out.println(s);
    }

    private static ArrayList<Byte> convertDecimalToFibonacciBinary(int input) {
        ArrayList<Long> fibonacci = Fibonacci.getSeriesLessThenNumber(input);
        // Zeckendorf use Fibonacci numbers not from 0. That the first distinct Fibonacci numbers are: 1, 2, 3, 5.
        // Start save Fibonacci numbers to array from 3 step. Fibonacci: 0->0, 1->1, 2->1, 3->2, 4->3, 5->5, ...
        // Remove 2 first numbers from regular series.
        fibonacci.remove(0);
        fibonacci.remove(0);
        // We need to reverse Fibonacci series.
        Collections.reverse(fibonacci);

        ArrayList<Byte> fibonacciBinary = new ArrayList<>();

        for (Long aFibonacci : fibonacci) {
            if (input - aFibonacci == 0 || input - aFibonacci > 0) {
                fibonacciBinary.add((byte) 1);
            } else if (input - aFibonacci < 0) {
                fibonacciBinary.add((byte) 0);
                continue;
            } else fibonacciBinary.add((byte) 0);

            input -= aFibonacci;
        }

        return fibonacciBinary;
    }

    private static StringBuilder arrayListToString(ArrayList list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Object o : list) stringBuilder.append(o);

        return stringBuilder;
    }
}
