package chapter08.item52;

import java.math.BigInteger;
import java.util.*;

// 아이템52 : 다중정의는 신중히 사용하라

// 다중정의가 정적 선택을 하기 때문에 발생하는 오류 예시
public class CollectionClassifier {
    public static String classify(Set<?> c) {
        return "집합";
    }

    public static String classify(List<?> c) {
        return "리스트";
    }

    public static String classify(Collection<?> c) {
        return "그 외";
    }

    public static void main(String[] args) {
        Collection<?>[] collections = {
                new HashSet<String>(),
                new ArrayList<BigInteger>(),
                new HashMap<String, String>().values()
        };

        for (Collection<?> c : collections) {
            System.out.println(classify(c));
        }
    }
}
