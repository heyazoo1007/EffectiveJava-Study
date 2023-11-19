package Chapter02.Item13;


public class HashTable2 implements Cloneable {
    private Entry[] buckets = {};

    private static class Entry {
        final Object key;
        Object value;
        Entry next;

        Entry(Object key, Object value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        // 복잡한 가변 상태를 갖는 클래스의 clone 메서드 구현 방법3
        // 엔트리 자신이 가리키는 연결 리스트를 반복적으로 복사
        Entry deepCopy() {
            Entry result = new Entry(key, value, next);
            for (Entry p = result; p.next != null; p = p.next) {
                p.next = new Entry(p.next.key, p.next.value, p.next.next);
            }
            return result;
        }
    }
}
