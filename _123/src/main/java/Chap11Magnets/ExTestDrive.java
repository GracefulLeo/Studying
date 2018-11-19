package Chap11Magnets;

public class ExTestDrive {

    public static void main(String[] args) {
        if (args.length > 0) {
            String test = args[0];
            try {
                System.out.print("t");
                doRisky(test);

                System.out.println("o");
            } catch (MyEx e) {
                System.out.print("a");
            } finally {
                System.out.println("w");
                System.out.println("s");
            }
        }
        }


    static void doRisky (String t) throws MyEx {
        System.out.println("h");
        if ("yes".equals(t)) {
            throw new MyEx();
        }
        System.out.println("r");
    }
}
