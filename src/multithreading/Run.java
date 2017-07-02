package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();

        // Custom multithreading.
        ThreadRunners.runInTwoThreads(); // 26892 ms // 6815
        ThreadRunners.runInFourThreads(); // 26336 ms
        ThreadRunners.runInAllThreads(); // 27712 ms
        ThreadRunners.runWithoutThreads(); // 22078 ms // 4897

        // Run with executors.
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 4; i++) {
            service.submit(new Drinker());
        }
        service.shutdown();


        System.out.println("Bar is closed.");

        long end = System.currentTimeMillis();
        System.out.println("Time: " + ((end - start)));
    }
}
