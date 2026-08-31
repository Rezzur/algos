package MultiThreads;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Task1 {
    int idx = 10000000 / 4;
    int sum = 0;
    int sum1 = 0;
    int sum2 = 0;
    int sum3 = 0;
    int sum4 = 0;
    Object object = new Object();
    ArrayList<Thread> Threads = new ArrayList<>();

    void sum(int[] arr) {
        Thread thread1 = new Thread(
                () -> {
                    for (int j = 0; j < idx; j++) {

                        sum1 += arr[j];

                    }
                }
        );
        Threads.add(thread1);
        Thread thread2 = new Thread(
                () -> {
                    for (int j = idx; j < 2 * idx; j++) {
                        sum2 += arr[j];
                    }
                }
        );
        Threads.add(thread2);
        Thread thread3 = new Thread(
                () -> {
                    for (int j = 2 * idx; j < idx * 3; j++) {
                        sum3 += arr[j];
                    }
                }
        );
        Threads.add(thread3);
        Thread thread4 = new Thread(
                () -> {
                    for (int j = idx * 3; j < idx * 4; j++) {
                        sum4 += arr[j];
                    }
                }
        );
        Threads.add(thread4);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

    }

    public static void main(String[] args) throws InterruptedException {
        Task1 t = new Task1();
        int[] arr = new int[10000000];
        Arrays.fill(arr, 1);
        t.sum(arr);
        for (Thread thread : t.Threads) {
            thread.join();
        }
        int sum = t.sum1 + t.sum2 + t.sum3 + t.sum4;
        System.out.println(sum);
    }
}
