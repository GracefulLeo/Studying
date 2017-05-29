package ZeckendorfNumber;

import java.util.ArrayList;

public class Fibonacci {
    // Prevent creating object of the class.
    private Fibonacci() {
    }

    /**
     * Get Fibonacci number from series.
     *
     * @param n Sequence number.
     * @return Sequence number from series.
     */
    public static long getFibonacciNumber(int n) {
        return fibonacci(n);
    }

    /**
     * Get Fibonacci series.
     *
     * @param num Count of sequence Fibonacci numbers.
     * @return Array of Fibonacci numbers.
     */
    public static long[] getSeries(int num) {
        long[] series = new long[num];

        for (int i = 0; i < num; i++) {
            series[i] = fibonacci(i);
        }

        return series;
    }

    /**
     * Get Fibonacci series where last number less than input.
     *
     * @param num Maximum number for sequence Fibonacci number.
     * @return ArrayList of Fibonacci numbers.
     */
    public static ArrayList<Long> getSeriesLessThenNumber(int num) {
        ArrayList<Long> series = new ArrayList<>();

        int i = 1;
        long next = 0;
        while (next <= num) {
            series.add(next);
            next = fibonacci(i++);
        }

        return series;
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
