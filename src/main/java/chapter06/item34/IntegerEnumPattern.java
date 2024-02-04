package chapter06.item34;

// Item34 : int 상수 대신 열거 타입을 사용하라
public class IntegerEnumPattern {

    // 정수 열거 타입은 되도록이면 사용하지 말자
    // 이유1 : 타입 안정성 보장 안됨
    // 이유2 : 표현력 좋지 않음
    // 이유3 : 코드 깨지기 쉬움
    public static final int APPLE_FUJI = 0;
    public static final int ORANGE_NAVEL = 0;
}
