package chapter06.item36;

import java.util.Set;

// Item 36 : 비트 필드 대신 EnumSet 을 사용하라
public class EnumSetText {

    public enum Style { BOLD, ITALIC, UNDERLINE, STRIKETHROUGH }

    // 어떤 Set을 넘겨도 상관없으나, EnumSet이 가장 좋다.
    public void applyStyles(Set<Style> styles) { }
}

// 클라이언트 applyStyles() 호출
// text.applyStyles(EnumSet.of(STYLE.BOLD, STYLE.ITALIC));
