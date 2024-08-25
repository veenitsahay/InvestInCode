package practice;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.util.StopWatch;

public class CreateThread {
        public static void main(String[] args) throws InterruptedException {
            StopWatch sw = new StopWatch();
            sw.start();
            AtomicInteger count = new AtomicInteger(0);
            for (int i = 0; i <= 100; i++) {
                synchronized (count) {
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("Thread number: " + count.getAndIncrement());
                        }
                    });
                    Thread.sleep(100);
                    thread.start();
                }
            }

            sw.stop();
            System.out.println("Total time taken : "+sw.getTotalTimeMillis());
        }

}
