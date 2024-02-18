package chapter04.item21;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.Predicate;


// 이펙티브 자바 아이템21 : 인터페이스는 구현하는 쪽을 생각해 설계하라
// 요약 : 자바 8부터 디폴트 메서드의 도입으로 기존의 인터페이스를 문제없이 수정할 수 있게 되었지만, 되도록이면 신중하게 디폴트 메서드를 추가하자.

// 문제
// 1. 변경 전 인터페이스를 사용하는 클라이언트에서 문제 발생 가능성 존재
// 2. 컴파일 에러가 발생하지 않더라도, 런타임 에러의 위험성
// 3. 예기치 못한 충돌/API 재앙, 사용자 불편 상황 발생 가능성 존재


// 해결 방법
// 1. 인터페이스 구현체에서 디폴트 메서드 재정의 강제
// 2. 다른 메서드에서는 디폴트 메서드를 호출하기 전에 필요한 작업 강제
// 3. 기존 인터페이스에 디폴트 메서드로 새 메서드를 추가하는 일은 꼭 필요한 경우가 아니면 하지 말자
// 4. 기존 인터페이스가 아닌 새로운 인터페이스를 설계하는 경우라면 위험성 적음
public interface Example1<E> {


    // java 8부터 도입된 디폴트 메서드 예시, removeIf() 함수
    default boolean removeIf(Predicate<? super E> filter) {
        Objects.requireNonNull(filter);
        boolean result = false;
        for (Iterator<E> it = iterator(); it.hasNext();) {
            if (filter.test(it.next())) {
                it.remove();
                result = true;
            }
        }
        
        return result;
    }

    Iterator<E> iterator();
}
