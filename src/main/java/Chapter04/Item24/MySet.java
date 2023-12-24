package Chapter04.Item24;

import java.util.AbstractSet;
import java.util.Iterator;

// 아이템 24 : 멤버 클래스는 되도록 static 으로 만들라.
// 중첩 클래스에는 정적 멤버 클래스, 비정적 멤버 클래스, 익명 클래스, 지역 클래스가 있다.
// 상황에 맞추어 가장 적절한 클래스를 사용하되, 되도록이면 정적 멤버 클래스를 사용해라.


// 본 코드는 비정적 멤버 클래스를 이용해 자신의 반복자를 구현한 것이다.
public class MySet<E> extends AbstractSet<E> {

    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    @Override
    public int size() {
        return 0;
    }

    private class MyIterator implements Iterator<E> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public E next() {
            return null;
        }
    }
}
