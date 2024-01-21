package Chapter05.Item29;

import java.util.Arrays;
import java.util.EmptyStackException;

// Item29 : 이왕이면 제네릭 타입으로 만들라
// Stack 을 제네릭 클래스 Stack<E> 로 변경하기
@SuppressWarnings("unchecked")
public class Stack<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        E elements = (E) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        E result = elements[--size];
        elements[size] = null; // 다 쓴 객체 참조 해제

        return result;
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}
