package chapter06.item39.exception_test;

/**
 * @ExceptionTest 선언 코드
 */
public class Sample2 {

    // 성공 케이스
    @ExceptionTest(ArithmeticException.class)
    public static void m1() {
        int i = 0;
        i /= i;
    }

    // 실패 케이스 - @ExceptionTest 에 설정한 Arithmetic 예외가 아닌 다른 예외 발생
    @ExceptionTest(ArithmeticException.class)
    public static void m2() {
        int[] a = new int[0];
        int i = a[1]; // IndexOutOfBoundException
    }

    // 예외가 발생하지 않는 케이스
    @ExceptionTest(ArithmeticException.class)
    public static void m3() { }
}
