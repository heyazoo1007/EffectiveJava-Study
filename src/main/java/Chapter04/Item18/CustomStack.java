package Chapter04.Item18;

// Item18 : 상속보다는 컴포지션을 사용하라
// 상속은 캡슐화를 위반하기 때문에 명확한 경우가 아니면 사용하지 말아야 한다.
// 그렇기에 상속보다는 컴포지션을 사용해야 한다.

import java.util.EmptyStackException;
import java.util.Vector;

// 자바의 Stack 은 Vector 를 상속받기 때문에 Stack 에 정의에 어긋나게 동작할 수 있다.
// CustomStack 은 Vector 를 컴포지션으로 구성해 위 문제를 해결했다.
public class CustomStack<E> {
    private final Vector<E> vector = new Vector(); // vector 를 컴포지션으로 구현

    public CustomStack(){}

    // 원소 삽입
    public E push(E item) {
        vector.addElement(item);

        return item;
    }

    // 원소 제거
    public synchronized E pop() {
        E obj;
        int len = vector.size();
        obj = peek();
        vector.removeElement(len - 1);

        return obj;
    }

    // 최근에 추가된 데이터 조회
    private E peek() {
        int len = vector.size();

        if (len == 0) {
            throw new EmptyStackException();
        }

        return vector.elementAt(len - 1);
    }

    // vector empty 여부
    public boolean empty() {
        return vector.size() == 0;
    }
}
