package ZeckendorfNumber;

import java.util.Scanner;

/**
 * Studying.
 */
public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ZeckendorfNumber zeckendorfNumber = new ZeckendorfNumber();
//        zeckendorfNumber.addDecimal(scanner.nextInt());
//        zeckendorfNumber.addDecimal(scanner.nextInt());
        zeckendorfNumber.requestDecimal();
        zeckendorfNumber.requestDecimal();
        zeckendorfNumber.requestDecimal();
        zeckendorfNumber.printZackendorfNumbers();
    }
}
