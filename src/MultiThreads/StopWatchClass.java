package MultiThreads;

public class StopWatchClass {
    Thread StopWatch = new Thread(
            () -> {
                int local = 0;
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("Секундомер: " + local + " сек");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("Секундомер остановлен на отметке: "+local+" сек");
                        Thread.currentThread().interrupt();
                    }
                    local++;
                }
            });

    public static void main(String[] args) throws InterruptedException {
        StopWatchClass s = new StopWatchClass();
        s.StopWatch.start();
        Thread.sleep(5000);
        s.StopWatch.interrupt();

    }
}
