package Chapter02.Item13;



public class HashTable1 implements Cloneable {
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

        // 엔트리가 가리키는 연결 리스트 재귀적으로 복사
        Entry deepCopy() {
            return new Entry(key, value, next == null ? null : next.deepCopy());
        }
    }

    // 복잡한 가변 상태를 갖는 클래스의 clone 메서드 구현 방법2
    @Override
    public HashTable1 clone() {
        try {
            HashTable1 result = (HashTable1) super.clone();
            result.buckets = new Entry[buckets.length];
            for (int i = 0; i < buckets.length; i++) {
                if (buckets[i] != null) {
                    result.buckets[i] = buckets[i].deepCopy();
                    return result;
                }
            }
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }

        return null;
    }
}
