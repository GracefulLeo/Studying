package multithreading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class ThreadRunners {
    static void runInTwoThreads() {
        List<Runnable> drinkers = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();

        Thread thread1;
        Thread thread2;

        for (int i = 0; i < 2; i++) {
            drinkers.add(new Drinker());
        }

        Iterator<Runnable> iterator = drinkers.iterator();
        while (iterator.hasNext()) {
            thread1 = new Thread(iterator.next());
            thread2 = new Thread(iterator.next());

            Collections.addAll(threads, thread1, thread2);

            thread1.start();
            thread2.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static void runInFourThreads() {
        List<Runnable> drinkers = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();

        Thread thread1;
        Thread thread2;
        Thread thread3;
        Thread thread4;

        for (int i = 0; i < 1000; i++) {
            drinkers.add(new Drinker());
        }

        Iterator<Runnable> iterator = drinkers.iterator();
        while (iterator.hasNext()) {
            thread1 = new Thread(iterator.next());
            thread2 = new Thread(iterator.next());
            thread3 = new Thread(iterator.next());
            thread4 = new Thread(iterator.next());

            Collections.addAll(threads, thread1, thread2, thread3, thread4);

            thread1.start();
            thread2.start();
            thread3.start();
            thread4.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static void runInAllThreads() {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(new Drinker());
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static void runWithoutThreads() {
        for (int i = 0; i < 2; i++) {
            new Drinker().run();
        }
    }
}
