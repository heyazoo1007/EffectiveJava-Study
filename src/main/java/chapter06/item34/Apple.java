package chapter06.item34;

public enum Apple {
    // 열거 타입을 사용하자.

    // 열거 타입을 사용해야 하는 3가지 이유
    // 이유1 : 컴파일타임 타입 안정성
    // 이유2 : 상수 변경 시에도 재컴파일 안해도 됨
    // 이유3 : 싱글턴 가능
    FUJI, PIPPIN, GRANNY_SMITH
}
