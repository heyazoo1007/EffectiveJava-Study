package chapter12.item90;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;

public class Period implements Serializable {
    // 접근자 어떻게 해야하나?
    final Date start;
    final Date end;

    public Period(Date start, Date end) {
        this.start = start;
        this.end = end;
    }

    // 직렬화 프록시 패턴용 메서드1 - writeReplace()
    private Object writeReplace() {
        return new SerializationProxy(this);
    }

    // 직렬화 프록시 패턴용 메서드2 - readObject()
    private void readObject(ObjectInputStream stream) throws InvalidObjectException {
        throw new InvalidObjectException("프록시가 필요합니다.");
    }
}
