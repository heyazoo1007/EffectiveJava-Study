package chapter02;

import java.util.Arrays;
import java.util.EmptyStackException;

public class item07 {

    public class Stack {
        private Object[] elements;
        private int size = 0;
        private static final int DEFAULT_INITIAL_CAPACITY = 16;

        public Stack() {
            elements = new Object[DEFAULT_INITIAL_CAPACITY];
        }

        public void push(Object e) {
            ensureCapacity();
            elements[size++] = e;
        }

        public Object pop() {
            if (size == 0) {
                throw new EmptyStackException();
            }
            return elements[--size];
        }

        private void ensureCapacity() {
            if (elements.length == size) {
                elements = Arrays.copyOf(elements, 2 * size + 1);
            }
        }

        // 메모리 누수 해결한 코드
        public Object popNoReference() {
            if (size == 0) {
                throw new EmptyStackException();
            }

            Object result = elements[--size];
            elements[size] = null;
            return result;
        }
    }
}
