package chapter11.Item78;

import java.util.concurrent.atomic.AtomicLong;

public class StopThreadAtomic {
    private static final AtomicLong nextSerialNum = new AtomicLong();

    public static long generateSerialNumber() {
        return nextSerialNum.getAndIncrement();
    }
}
