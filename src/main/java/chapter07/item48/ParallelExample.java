package chapter07.item48;

import java.math.BigInteger;
import java.util.stream.LongStream;

public class ParallelExample {

    // 스트림 병렬 적용 전 : 실행시간 31초
    static long pi(long n) {
        return LongStream.rangeClosed(2, n)
                .mapToObj(BigInteger::valueOf)
                .filter(i -> i.isProbablePrime(50))
                .count();
    }

    // 스트림 병렬 적용 후 : 실행시간 9.2초
    static long piParallel(long n) {
        return LongStream.rangeClosed(2, n)
                .parallel()
                .mapToObj(BigInteger::valueOf)
                .filter(i -> i.isProbablePrime(50))
                .count();
    }
}
