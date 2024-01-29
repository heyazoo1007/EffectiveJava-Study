package Chapter05.Item30;

import java.util.function.UnaryOperator;

public class IdentityMethod {
    private static UnaryOperator<Object> IDENTITY_FN = (t) -> t;

    // 항등함수는 상태가 없기에 싱글턴으로 만든다.
    @SuppressWarnings("unchecked")
    public static <T> UnaryOperator<T> identityFunction() {
        return (UnaryOperator<T>) IDENTITY_FN;
    }
}
