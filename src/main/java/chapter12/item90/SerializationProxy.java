package chapter12.item90;

import java.io.Serializable;
import java.util.Date;

// 아이템90 : 직렬화된 인스턴스 대신 직렬화 프록시 사용을 검토하라
public class SerializationProxy implements Serializable {
    private static final long serialVersionUID  = 234209470239740923L;
    private final Date start;
    private final Date end;

    public SerializationProxy(Period period) {
        this.start = period.start;
        this.end = period.end;
    }

    // Period.SerializationProxy 용 메서드 - readResolve()
    private Object readResolve() {
        return new Period(start, end);
    }
}
