package chapter06.item39.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 테스트 메서드임을 선언하는 에너테이션이다.
 * 매개변수 없는 정적 메서드 전용이다. -> 인스턴스 메서드 or 매개변수가 있는 메서드에서는 사용 못한다
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Test {
}
