package chapter02;

import java.util.regex.Pattern;

public class item06 {

    // 동일 기능 객체는 매번 생성하지 말고 '재사용' 하자
    // 불필요한 객체 생성을 피하는 방법

    // 방법 1. No new String() instance

    // NG
    String NG = new String("hello");

    // OK
    String OK = "hello";


    // 방법 2. 정적 팩터리 메서드 사용
    // 정적 팩터리 메서드를 이용해 Flyweight 패턴을 구현하면 불변 객체 재사용이 가능하다

    // ng : Boolean(String)
    // ok : Boolean.valueOf(String)


    // 방법 3. 생성 비용이 비싸면 캐싱 & 재사용

    // NG
    static boolean isRomanNumberNG(String s) {
        return s.matches("...some reg exp here");
    }

    // WHY?
    // String.matches가 내부에서 만드는 정규표현식용 Pattern 인스턴스는, 생성 비용이 높은데,
    // 여기서는 한번 쓰고 버려져 곧바로 GC대상이 된다.

    // Good
    // 필요한 정규 표현식 불변 인스턴스를 정적 초기화 과정에서 생성해 캐싱
    private static final Pattern ROMAN = Pattern.compile("...some reg exp here");

    // 메서드 호출시마다 재사용
    static boolean isRomanNumberOK(String s) {
        return ROMAN.matcher(s).matches();
    }


    // 방법 4. 오토박싱 금지
    // 오토박싱은 기본타입과 박싱된 기본 타입을 섞어 쓸 때, 자동으로 상호 변환해주는 기술
    // 의미상으로는 큰 차이 없어보이지만, 성능에서는 그렇지 않다.

    // NG
    static long sumNG() {
        // long 타입인 i가, Long 타입인 sum에 더해질때마다, 불필요한 Long 인스턴스가 엄청나게 생긴다
        Long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            sum += i;
        }
        return sum;
    }

    // OK
    static long sumOK() {
        long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            sum += i;
        }
        return sum;
    }
}
