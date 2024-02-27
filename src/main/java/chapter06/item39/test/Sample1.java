package chapter06.item39.test;

/**
 * @Test 선언 코드
 */
public class Sample1 {

    @Test // Test 도구가 체크하는 메서드 & 성공 케이스
    public static void m1() {
    }

    @Test // Test 도구가 체크하는 메서드 & 실패 케이스
    public static void m2() {
        throw new RuntimeException("실패");
    }

    @Test // Test 도구가 체크하는 메서드 & 잘못 사용한 케이스(정적 메서드가 아님)
    public void m3() {
    }

    // Test 도구가 체크하지 않는 메서드
    public static void m4() {
    }
}
