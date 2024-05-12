package chapter08.item53;

// 아이템53 : 가변인수는 신중히 사용하라
public class Varags {

    // 가변인수 활용 예시1
    static int sum(int... args) {
        int sum = 0;
        for (int arg : args) {
            sum += arg;
        }
        return sum;
    }

    /**
     * 가변인수 잘못 활용한 예시
     * 1. 인수가 0개일 때 컴파일 타임이 아닌 런타임에서 실패
     * 2. 코드가 지저분하다(명시적인 매개변수 유효성 검사, for-each 문 사용 어렵)
     */
    static int min(int... args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("인수가 1개 이상 필요합니다.");
        }

        int min = args[0];
        for (int i = 1; i < args.length; i++) {
            if (args[i] < min) {
                min = args[i];
            }
        }
        return min;
    }

    /**
     * 가변인수 맞게 활용한 예시
     */
    static int min(int firstArg, int... remainingArgs) {
        int min = firstArg;
        for (int remainingArg : remainingArgs) {
            if (remainingArg < min) {
                min = remainingArg;
            }
        }
        return min;
    }
}
