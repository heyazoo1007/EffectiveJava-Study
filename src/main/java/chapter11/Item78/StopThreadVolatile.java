package chapter11.Item78;

import java.util.concurrent.TimeUnit;

// volatile 필드를 사용해 스레드 정상 종료
public class StopThreadVolatile {
    private static volatile boolean stopRequested;

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested) {
                i++;
            }
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
    }

    // volatile 사용시 주의할 점
    private static volatile int nextSerialNumber = 0;
    public static int generateSerialNumber() {
        return nextSerialNumber++;
    }
}
