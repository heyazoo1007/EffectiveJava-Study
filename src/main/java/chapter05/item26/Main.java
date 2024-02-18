package chapter05.item26;

import java.util.ArrayList;
import java.util.List;


// List<String> 은 List 로 넘길 수 있지만, List<Object> 로 넘길 수 없다.
public class Main {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();

        // 1. List 에 List<String> 넘길 수 있음
        unsafeAdd(strings, Integer.valueOf(42));
        strings.get(0); // 컴파일러가 자동 형변환

        // 2. List<Object> 에 List<String> 넘길 수 없음
        // safeAdd(strings, Integer.valueOf(42));
    }

    // 매개변수에 로 타입 List 존재
    private static void unsafeAdd(List list, Object o) {
        list.add(o);
    }

    // 매개변수에 제네릭 타입 List<Object> 존재
    private static void safeAdd(List<Object> list, Object o) {
        list.add(o);
    }
    
}
