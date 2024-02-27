package chapter06.item39.exception_test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ExceptionTest 실행 로직
 */
public class RunTests2 {

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
                    Class<? extends Throwable> exceptionType =
                            method.getAnnotation(ExceptionTest.class).value();
                    if (exceptionType.isInstance(exceptionCause)) { // 기대한 예외 == 발생한 예외
                        passed++;
                    } else { // 기대한 예외 != 발생한 예외
                        System.out.printf("테스트 %s 실패 : 기대한 예외 %s, 발생한 예외 %s%n", method, exceptionType.getName(), exceptionCause);
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
