package chapter05.item30;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class GenericMethod {

    // 제네릭 메서드 작성 예시
    public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    // 재귀적 타입 한정으로 컬렉션 원소 비교할 때 컴파일 에러 발생하지 않게 함
    public static <E extends Comparable<E>> E max(Collection<E> c) {
        if (c.isEmpty()) {
            throw new IllegalArgumentException("컬렉션이 비어있습니다.");
        }

        E result = null;
        for (E e : c) {
            if (result == null || e.compareTo(result) > 0) {
                result = Objects.requireNonNull(e);
            }
        }

        return result;
    }
}
