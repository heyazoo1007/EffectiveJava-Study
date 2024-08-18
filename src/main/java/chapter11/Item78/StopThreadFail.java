package chapter10.Item78;

import java.util.concurrent.TimeUnit;

// 아이템78 : 공유 중인 가변 데이터는 동기화해 사용하라
public class StopThreadFail {
    private static boolean stopRequested;

    // 동기화를 사용하지 않아 무한루프를 도는 코드
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
}
