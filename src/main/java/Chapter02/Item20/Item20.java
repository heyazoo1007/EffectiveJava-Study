package Chapter02.Item20;

import java.util.AbstractList;
import java.util.List;
import java.util.Objects;

public class Item20 {

    // AbstractList 골격 구현을 사용해 완성한 구체 클래스
    // 1. 골격 구현의 예시
    // 2. int[] -> List<Integer> 어댑터 역할
    // 3. 익명 클래스 사용
    static List<Integer> intArrayAsList(int[] a) {
        Objects.requireNonNull(a);

        return new AbstractList<Integer>() {
            @Override
            public Integer get(int i) {
                return a[i];
            }

            @Override public Integer set(int i, Integer val) {
                int oldVal = a[i];
                a[i] = val;  // 오토 언박싱
                return oldVal; // 오토 박싱
            }

            @Override
            public int size() {
                return a.length;
            }
        };
    }
}
