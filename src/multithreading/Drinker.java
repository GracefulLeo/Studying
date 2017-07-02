package multithreading;

class Drinker implements Runnable {
    private static int nextId = 1;
    private final int id = nextId++;

    @Override
    public void run() {
        System.out.println("Hello, " + sayDrinker());

        for (int beer = 1; beer <= 1_000_000; beer++) {
            System.out.println(sayDrinker() + " I drink my " + beer + " beer.");
        }

        System.out.println("Goodbye. " + sayDrinker());
    }

    private String sayDrinker() {
        return "I'm " + id + " drinker.";
    }
}
