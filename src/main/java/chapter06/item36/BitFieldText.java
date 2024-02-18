package chapter06.item36;

// Item 36 : 비트 필드 대신 EnumSet 을 사용하라

/**
 * 비트필드를 사용할 때의 문제점
 *
 * 1. 비트 필드는 정수 열거 상수의 단점을 그대로 안고 있다
 * 2. 비트 필드 값이 그대로 출력되면 정수 열거 상수를 출력할 때보다 해석하기가 훨씬 어렵다
 * 3. API 작성 시 고려사항이 하나 더 추가된다
 */
public class BitFieldText {

    // 비트 필드 열거 상수 : 각 상수에 서로 다른 2의 거듭제곱을 할당한 정수 열거 패턴
    public static final int STYLE_BOLD = 1 << 0; // 1
    public static final int STYLE_ITALIC = 1 << 1; // 2
    public static final int STYLE_UNDERLINE = 1 << 2; // 4
    public static final int STYLE_STRIKETHROUGH = 1 << 3; // 8

    public void applyStyles(int styles) { }
}

// 클라이언트 applyStyles() 호출
// text.applyStyles(STYLE_BOLD | STYLE_ITALIC);
