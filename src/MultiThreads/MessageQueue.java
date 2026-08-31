package MultiThreads;

import java.util.ArrayDeque;

public class MessageQueue {
    ArrayDeque queue = new ArrayDeque(5);

    synchronized void put(String message) throws InterruptedException {
        while (queue.size() == 5) {
            wait();
        }
        queue.add(message);
        notify();
    }

    synchronized void take() throws InterruptedException {
        while (queue.size() == 0) {
            wait();
        }
        String message1 = queue.poll().toString();
        System.out.println(message1);
        notify();

    }

    public static void main(String[] args) {
        MessageQueue queue = new MessageQueue();
        Thread prodecer = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                try {
                    queue.put("message"+i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread consumer = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                try {
                    queue.take();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        prodecer.start();
        consumer.start();
    }
}
