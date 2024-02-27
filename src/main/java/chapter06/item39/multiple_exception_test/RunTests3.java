package chapter06.item39.multiple_exception_test;

import chapter06.item39.exception_test.ExceptionTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @MultipleExceptionTest 실행 로직
 */
public class RunTests3 {

    // 매개변수로 예외 배열 넘김
    @MultipleExceptionTest({IndexOutOfBoundsException.class,
                            NullPointerException.class})
    public static void doubleBad() {
        List<String> list = new ArrayList<>();
        list.addAll(5, null);
    }

    public static void main(String[] args) throws ClassNotFoundException {
        int tests = 0;
        int passed = 0;
        Class<?> testClass = Class.forName(args[0]);
        for (Method method : testClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(ExceptionTest.class)) { // @Test 선언한 메서드 차례로 호추
                tests++;
                try {
                    method.invoke(null);
                    System.out.printf("테스트 %s 실패 : 예외를 던지지 않음%n", method);
                } catch (InvocationTargetException wrappedException) {
                    Throwable exceptionCause = wrappedException.getCause();
                    int oldPassed = passed;
                    Class<? extends Throwable>[] exceptionTypes =
                            method.getAnnotation(MultipleExceptionTest.class).value();
                    for (Class<? extends Throwable> exceptionType : exceptionTypes) {
                        if (exceptionType.isInstance(exceptionCause)) {
                            passed++;
                            break;
                        }
                    }
                    if (passed == oldPassed) {
                        System.out.printf("테스트 %s 실패 : %s %n", method, exceptionCause);
                    }
                    System.out.println(method + " 실패 : " + exceptionCause);
                } catch (Exception e) {
                    System.out.println("잘못 사용한 @Test : " + method);
                }
            }
        }
        System.out.printf("성공 : %d, 실패 : %d%n", passed, tests - passed);
    }
}
