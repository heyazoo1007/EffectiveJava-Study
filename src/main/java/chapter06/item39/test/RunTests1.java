package chapter06.item39.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Test 실행 로직
 */
public class RunTests1 {

    public static void main(String[] args) throws ClassNotFoundException {
        int tests = 0; // 실행된 테스트 개수
        int passed = 0; // 실행된 것 중 통과한 테스트 개수
        Class<?> testClass = Class.forName(args[0]); // 명령줄로부터 완전 정규화된 클래스 불러옴
        for (Method method : testClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Test.class)) { // @Test 선언한 메서드 차례로 호추
                tests++;
                try {
                    method.invoke(null);
                    passed++;
                } catch (InvocationTargetException wrappedException) {
                    Throwable cause = wrappedException.getCause();
                    System.out.println(method + " 실패 : " + cause);
                } catch (Exception e) {
                    System.out.println("잘못 사용한 @Test : " + method);
                }
            }
        }
        System.out.printf("성공 : %d, 실패 : %d%n", passed, tests - passed);
    }
}
