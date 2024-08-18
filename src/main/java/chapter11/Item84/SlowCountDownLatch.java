package chapter11.Item84;

// 아이템84 : 프로그램의 동작을 스레드 스케줄러에 기대지 말라

// BAD CASE : 바쁜 대기 상태 예시
public class SlowCountDownLatch {
    private int count;

    public SlowCountDownLatch(int count) {
        if (count < 0) {
            throw new IllegalArgumentException(count + " < 0");
        }
        this.count = count;
    }

    public void await() {
        while (true) {
            synchronized (this) {
                if (count == 0) {
                    return;
                }
            }
        }
    }

    public synchronized void countDown() {
        if (count != 0) {
            count--;
        }
    }
}
